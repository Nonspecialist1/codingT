package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_2775 {
    public static void main(String[] args) throws IOException {
        int[][] arr = new int[15][14];
        for(int j=0; j<14; j++){ arr[0][j] = j+1; }
        for(int i=0; i<14; i++){
            int total = 0;
            for(int j=0; j<14; j++){
                total += arr[i][j];
                arr[i+1][j] = total;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++){
            int k = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            System.out.println(arr[k][n-1]);
        }
    }
}
