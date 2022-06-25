package beckjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakePW_1759 {
    static int N, R;
    static boolean[] Visited;
    static char[] Arr, PW;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Visited = new boolean[N];
        PW = new char[R];

        Arr = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(Arr);

        perm(0, 0);
        System.out.println(sb);
    }

    static void perm(int idx, int r){
        if(r == R) { // 4개의 수가 모두 만들어 졌을 때
            boolean flag = true;
            int cnt = 0;

            for(int i=0; i<R; i++){
                if(PW[i] == 'a' || PW[i] == 'e' || PW[i] == 'i' || PW[i] == 'o' || PW[i] == 'u'){
                    flag = false; // 모음 검사
                } else {
                    cnt++; // 자음 검사
                }
            }
            if(cnt < 2) return;
            if(flag) return;

            for(int i=0; i<R; i++){
                sb.append(PW[i]);
            }
            sb.append("\n");
            return;
        }

        for(int i=idx; i<N; i++){
            if(Visited[i]) continue;

            PW[r] = Arr[i];

            Visited[i] = true;
            perm(i, r+1);
            Visited[i] = false;
        }
    }

}
