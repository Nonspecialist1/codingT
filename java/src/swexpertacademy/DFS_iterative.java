package swexpertacademy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DFS_iterative {
    static boolean visited[] = new boolean[8];
    static boolean[][] arr = new boolean[8][8];
    static Stack<Integer> st = new Stack<>();
    static ArrayList<Integer> road = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.next().split(",");

        for(int i=0; i+2<str.length; i+=2){
            arr[Integer.parseInt(str[i])][Integer.parseInt(str[i+1])] = true;
        }
        for(int i=1; i<arr.length; i++){
            for(int j=1; j<arr.length; j++){
                if(arr[i][j]){ arr[j][i] = true; }
            }
        }
        DFS_iter(1);

        for(int i=0; i< road.size(); i++){
            if(i == road.size() -1){ System.out.printf("%d", road.get(i)); }
            else{ System.out.printf("%d - ", road.get(i)); }
        }
    }


    static void DFS_iter(int v){
        st.push(v);
        while (!st.isEmpty()){
            v = st.pop();
            if(!visited[v])
            {
                visited[v] = true;
                road.add(v);
                for(int i=arr.length-1; i>0; i--){
                    if(arr[v][i]){
                        if(!visited[i]){ st.push(i); }
                    }
                }
            }
        }
    }

}
