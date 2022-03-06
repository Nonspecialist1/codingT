package beckjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumSort3_10989 {
    static int[] num = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int idx = Integer.parseInt(br.readLine());
            num[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<10001; i++){
            while(num[i] > 0){
                sb.append(i+"\n");
                num[i]--;
            }
        }
        System.out.print(sb);
    }
}
