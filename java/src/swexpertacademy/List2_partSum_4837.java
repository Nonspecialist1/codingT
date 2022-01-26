package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class List2_partSum_4837 {
    // 전체 집합
    static int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    static boolean[] used;
    static ArrayList<Integer> result;
    static int K;
    static int N;
    static int ans;

    public static void main(String[] args) throws IOException {
        Long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 원소가 N개인 부분집합
            N = Integer.parseInt(st.nextToken());
            // 부분집합 원소들의 합
            K = Integer.parseInt(st.nextToken());
            ans = 0;
            used = new boolean[12];
            result = new ArrayList<>();
            perm(0, 0, 0);
            System.out.printf("#%d %d", i+1, ans);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    static void perm(int cnt, int sum, int k){
        // 조합을 만들어보다가 부분집합의 합이 N이 되면 result 출력하고 끝
        if(sum == K && result.size() == N){
            ans++;
            return;
        }
        // 부분집합의 합이 N이 되지 못하고 조합이 끝나면 리턴
        if(cnt >= 12){
            return;
        }
        for(int j=k; j<12; j++){
            if(!used[j]){
                used[j] = true;
                sum += A[j];
                result.add(A[j]);
                perm(cnt+1, sum, j);
                used[j] = false;
                sum -= A[j];
                result.remove(result.size()-1);
            }
        }
   }



}
