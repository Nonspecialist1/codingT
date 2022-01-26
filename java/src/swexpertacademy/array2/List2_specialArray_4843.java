package swexpertacademy.array2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class List2_specialArray_4843 {
    public static void main(String[] args) throws IOException {
        Long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arrMin = new int[N];
            int[] arrMax = new int[N];
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arrMin[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrMin);
            int k = N-1;
            for(int j=0; j<N; j++){
                arrMax[j] = arrMin[k--];
            }
            for(int c=0, j=0, q=0; c<N; c++){
                if(c%2 == 0){
                    arr[c] = arrMax[j++];
                }else {
                    arr[c] = arrMin[q++];
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<10; j++){
                sb.append(arr[j]+" ");
            }
            System.out.printf("#%d %s\n", i+1, sb);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
