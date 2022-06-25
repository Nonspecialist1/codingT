package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inequalty_2529 {

    static int K, N;
    static char[] Order;
    static int[] Arr;
    static boolean[] Visit;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        N = K+1;
        Visit = new boolean[10];
        Arr = new int[N];

        Order = br.readLine().replace(" ", "").toCharArray();

        perm(0);
        // 최댓값 출력
        for(int i=N+1; i>=2; i--){
            System.out.print(sb.charAt(sb.length()-i));
        }
        System.out.println();
        // 최솟값 출력
        for(int i=0; i<N; i++){
            System.out.print(sb.charAt(i));
        }
    }
    // 순열 생성성
    private static void perm(int r) {
        if(r == N){
            String str = "";

            for(int i=0; i<N-1; i++){
                if(Order[i] == '<'){
                    if(Arr[i] > Arr[i+1]) return;
                } else {
                    if(Arr[i] < Arr[i+1]) return;
                }
                str += Arr[i];
            }

            str += Arr[N-1];
            sb.append(str + "\n");
            return;
        }

        for(int i=0; i<10; i++){
            if(Visit[i]) continue;

            Arr[r] = i;

            Visit[i] = true;
            perm(r+1);
            Visit[i] = false;
        }
    }
}
