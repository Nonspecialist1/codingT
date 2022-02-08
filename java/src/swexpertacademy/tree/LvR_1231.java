package swexpertacademy.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LvR_1231 {
    static int[][] arr;
    static ArrayList<Integer> list;
    static boolean[] visited;
    static int N;
    static String[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T=1; T<=10; T++){
            N = Integer.parseInt(br.readLine()) + 1;
            arr = new int[N][N];
            visited = new boolean[N];
            list = new ArrayList<>();
            str = new String[N];

            for(int i=1; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                str[a] = st.nextToken();

                while(st.hasMoreTokens()){
                    int b = Integer.parseInt(st.nextToken());
                    arr[a][b]++; // a -> b 간선 증가
                    arr[a][0]++; // a의 진출차수 증가
                }
            }
            LvR(1);
            String ans = "";
            for(int i : list){ ans += str[i]; }
            System.out.printf("#%d %s\n", T, ans);
        }
    }
    static void LvR(int v){
        for(int i=1; i<N; i++){
            if(arr[v][i] > 0 && !visited[i]){
                LvR(i);
                if(!visited[v]){
                    visited[v] = true;
                    list.add(v);
                }
            }
        }
        if(!visited[v]){
            visited[v] = true;
            list.add(v);
        }
    }

}
