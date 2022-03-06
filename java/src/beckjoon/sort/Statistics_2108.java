package beckjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Statistics_2108 {
    static int avg;
    static int mid;
    static int freq;
    static int max;
    static int min;
    static int range;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];

        int total = 0;
        max = -4001;
        min = 4001;
        for(int i=0; i<N; i++){
            int val = Integer.parseInt(br.readLine());
            arr[val + 4000]++;
            total += val;
            if(val < min) min = val;
            if(val > max) max = val;
        }

        mid = N/2 + 1;
        int cnt = 0;
        int maxCnt = 0;
        int val = 0;
        boolean flag = true;
        for(int i= min+4000; i<=max+4000; i++){
            if(arr[i] > 0){
                cnt += arr[i];
                if(cnt >= mid){
                    if(mid == N/2 +1) mid = i - 4000;
                }

                if(maxCnt < arr[i]){
                    maxCnt = arr[i];
                    val = i - 4000;
                    flag = true;
                }
                else if(maxCnt == arr[i] && flag == true){
                    val = i - 4000;
                    flag = false;
                }
            }
        }

        avg = (int)Math.round((double)total / N);
        freq = val;
        range = max - min;

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(freq);
        System.out.println(range);
    }
}
