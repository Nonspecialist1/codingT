package beckjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Treasure_1026 {

    static int N, Min = 0;
    static int[] A;
    static Integer[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        // A 배열과 B배열 곱의 최솟값 찾기
        solve();
        System.out.println(Min);
    }


    private static void solve(){
        Arrays.sort(A); // 오름차순 정렬
        Arrays.sort(B, Collections.reverseOrder()); // 내림차순 정렬

        for(int i=0; i<N; i++){
            Min += A[i] * B[i];
        }
    }


}
