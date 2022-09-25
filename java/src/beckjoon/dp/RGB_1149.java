package beckjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB_1149 {
    static int[][] DP;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        DP = new int[N+1][3];
        Arrays.fill(DP[2], Integer.MAX_VALUE);
        int[][] RGB = new int[N+1][3];

        for(int i=1; i<=N; i++){ // 집이 3개 이상 일 때,
            StringTokenizer st = new StringTokenizer(br.readLine());

            RGB[i][0] = Integer.parseInt(st.nextToken()); // R 비용
            RGB[i][1] = Integer.parseInt(st.nextToken()); // G 비용
            RGB[i][2] = Integer.parseInt(st.nextToken()); // B 비용
        }

        DP[2][0] = Math.min(DP[2][0], RGB[2][0] + RGB[1][1]);
        DP[2][0] = Math.min(DP[2][0], RGB[2][0] + RGB[1][2]);
        DP[2][1] = Math.min(DP[2][1], RGB[2][1] + RGB[1][0]);
        DP[2][1] = Math.min(DP[2][1], RGB[2][1] + RGB[1][2]);
        DP[2][2] = Math.min(DP[2][2], RGB[2][2] + RGB[1][0]);
        DP[2][2] = Math.min(DP[2][2], RGB[2][2] + RGB[1][1]);


        for(int i=3; i<=N; i++){ // 최소 비용 구하기
            // 마지막 집이 빨강색 일 때
            DP[i][0] = Math.min(DP[i-1][1] + RGB[i][0], DP[i-1][2] + RGB[i][0]);
            // 마지막 집이 초록색 일 때
            DP[i][1] = Math.min(DP[i-1][0] + RGB[i][1], DP[i-1][2] + RGB[i][1]);
            // 마지막 집이 파랑색 일 때
            DP[i][2] = Math.min(DP[i-1][0] + RGB[i][2], DP[i-1][1] + RGB[i][2]);
        }

        answer = Math.min(DP[N][0], Math.min(DP[N][1], DP[N][2]));
        System.out.println(answer);
    }



}
