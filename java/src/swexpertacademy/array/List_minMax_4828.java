package swexpertacademy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class List_minMax_4828 {
    public static void main(String[] args) throws IOException {
        Long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            int max = 0;
            int min = 1000000;
            int answer = 0;

            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                if(arr[j] > max){
                    max = arr[j];
                }
                if(arr[j] < min){
                    min = arr[j];
                }
            }
            answer = max - min;
            System.out.printf("#%d %d \n", i+1, answer);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
