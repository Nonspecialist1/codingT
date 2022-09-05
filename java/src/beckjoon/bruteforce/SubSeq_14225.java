package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SubSeq_14225 {

    static int N;
    static int[] Arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
        }
        // 배열 오름차순으로 정렬
        Arrays.sort(Arr);
        checkNum();
    }

    private static void checkNum(){
        int min = 1;
        for(int i=0; i<N; i++){
            if(min < Arr[i]) break;
            min += Arr[i];
        }
        System.out.println(min);
    }

}
