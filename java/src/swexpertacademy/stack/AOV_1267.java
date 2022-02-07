package swexpertacademy.stack;

import java.util.ArrayList;
import java.util.Scanner;

public class AOV_1267 {
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb;
    // 설명은 어렵지만 구현은 쉬운 것 : 진입차수를 거꾸로 배열에 저장하고 마지막 노드에서 저장 (DFS 재귀, 난 이게 더 어려워)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            int v = sc.nextInt() + 1;
            arr = new int[v][v];
            visited = new boolean[v];
            int E = sc.nextInt();
            for(int i=0; i<E; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[b][a]++;
                arr[a][0]++; // 진입차수 증가
            }

            ArrayList<Integer> list = new ArrayList<>();
            for(int i=1; i<arr.length; i++){
                if(arr[i][0] == 0){ list.add(i); }
            }
            sb = new StringBuilder();
            for(int i : list){ workorder(arr, i); }
            System.out.printf("#%d %s\n", T, sb);
        }
    }

    static void workorder(int[][] arr, int v){
        for(int i=1; i<arr.length; i++){
            if(arr[v][i] != 0){
                workorder(arr, i);
            }
        }
        if(!visited[v]){
            visited[v] = true;
            sb.append(v + " ");
        }
    }
}


class Solution {
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb;
    // 설명은 쉽지만 구현은 어려운 것  : 진입차수, 진출차수를 체크하고 진입차수가 없는 것 부터 visit에 저장하고 그 진출차수와 함깨 지워나가기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            int v = sc.nextInt() + 1;
            arr = new int[v][v];
            visited = new boolean[v];
            int E = sc.nextInt();
            for(int i=0; i<E; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[a][b]++;
                arr[b][0]++; // 진입차수 증가
            }
            sb = new StringBuilder();
            workorder(arr, visited);

            System.out.printf("#%d %s\n", T, sb);
        }
    }

    static void workorder(int[][] arr, boolean[] visited){
        for(int i=1; i<arr.length; i++){
            if(arr[i][0] == 0 && !visited[i]){
                visited[i] = true;
                sb.append(i + " ");
                for(int j=1; j<arr.length; j++){
                    if(arr[i][j] != 0){
                        arr[i][j] = 0;
                        arr[j][0]--;
                    }
                }
            }
        }
        for(int i=1; i< visited.length; i++){
            if(!visited[i]){ workorder(arr, visited);}
        }
    }

}