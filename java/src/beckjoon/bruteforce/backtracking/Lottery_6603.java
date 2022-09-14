package beckjoon.bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lottery_6603 {

    static int K;
    static int[] Nums, Temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K == 0) break;

            Temp = new int[6];
            Nums = new int[K];
            for(int i=0; i<K; i++){
                Nums[i] = Integer.parseInt(st.nextToken());
            }
            // kC6
            comb(0, 0);
            System.out.println();
        }
    }

    static void comb(int n, int r){
        if(r == 6) printLotto();
        else if(r > 6) return;
        else if(n >= K) return;
        else {
            Temp[r] = Nums[n];
            comb(n+1, r+1);
            comb(n+1, r);
        }
    }
    // 로또 번호 출력
    private static void printLotto() {
        StringBuilder sb = new StringBuilder();
        for(int i : Temp){
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
