package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSeq_14225 {

    static int N;
    static int[] Arr;
    static boolean[] Visited;
    static boolean[] CheckNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arr = new int[N];
        Visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=0; i<N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
            sum += Arr[i];
        }

        CheckNum = new boolean[sum+1];

        checkNum(0);

        int len = CheckNum.length;
        for(int i=0; i<len; i++){
            if(!CheckNum[i]){ // 만들 수 없는 가장 작은 수
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(len);
    }

    private static void checkNum(int r){
        if(r == N){ // 부분집합 완성
            int sum = 0;
            for(int i=0; i<N; i++){
                CheckNum[Arr[i]] = true;
                if(Visited[i]){
                    sum += Arr[i];
                }
            }
            CheckNum[sum] = true;
        }
        else {
            Visited[r] = true;
            checkNum(r+1);
            Visited[r] = false;
            checkNum(r+1);
        }
    }

}
