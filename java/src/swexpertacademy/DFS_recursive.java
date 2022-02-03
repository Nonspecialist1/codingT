package swexpertacademy;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_recursive {
    static boolean visited[];
    static ArrayList<Integer> road = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.next().split(",");

        int max = 0;
        for(String s : str){
            if(Integer.parseInt(s) > max){ max = Integer.parseInt(s); }
        }


        boolean[][] arr = new boolean[max+1][max+1];
        visited = new boolean[max+1];

        for(int i=0; i+2<str.length; i+=2){
            arr[Integer.parseInt(str[i])][Integer.parseInt(str[i+1])] = true;
        }
        for(int i=1; i<arr.length; i++){
            for(int j=1; j<arr.length; j++){
                if(arr[i][j]){ arr[j][i] = true; }
            }
        }

        DFS_recur(arr, 1);

        for(int i=0; i< road.size(); i++){
            if(i == road.size() -1){ System.out.printf("%d", road.get(i)); }
            else{ System.out.printf("%d - ", road.get(i)); }
        }
    }

    static void DFS_recur(boolean[][] arr, int v){
        visited[v] = true; // v 방문 : 1번부터
        road.add(v);

        ArrayList<Integer> w = adjacency(arr, v);
        for(int i=0; i<w.size(); i++){
            if(!visited[w.get(i)]){ DFS_recur(arr, w.get(i)); }
        }

    }

    static ArrayList<Integer> adjacency(boolean[][] arr, int v){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<arr.length; i++){
                if(arr[v][i]){ list.add(i); }
        }
        return list;
    }

}
