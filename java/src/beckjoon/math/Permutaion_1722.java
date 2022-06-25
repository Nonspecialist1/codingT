package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutaion_1722 {
    static int N, T, I = 0, Cnt = 0;
    static boolean[] Visited;
    static int[] Arr;
    static String STR = "";
    static boolean Flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Visited = new boolean[N+1];
        Arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        if(T == 1){
            I = Integer.parseInt(st.nextToken());
        }
        else if(T == 2)
        {
            for(int i=0; i<N; i++){ STR += st.nextToken(); }
        }
        perm(0);
    }

    static void perm(int r){
        if(Flag) return;

        if(r == N) { // 4개의 수가 모두 만들어 졌을 때
            Cnt++;
            String st = "";
            String str = "";

            for(int i=0; i<N; i++){
                st += Arr[i] + " ";
                str += Arr[i];
            }

            if(I != 0 && Cnt == I) { // 1번 조건일 때
                System.out.println(st);
                Flag = true;
            }
            else if(STR.equals(str)){
                System.out.println(Cnt);
                Flag = true;
            }
            return;
        }

        for(int i=1; i<=N; i++){
            if(Flag) return;
            if(Visited[i]) continue;

            Arr[r] = i;

            Visited[i] = true;
            perm(r+1);
            Visited[i] = false;
        }
    }

}
