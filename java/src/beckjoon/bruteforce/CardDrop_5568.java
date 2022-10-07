package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CardDrop_5568 {

    static int N, K, Answer = 0;
    static ArrayList<Integer> completedList = new ArrayList<>();
    static boolean[] Visited;
    static int[] Arr, Temp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 카드의 수
        K = Integer.parseInt(br.readLine()); // 뽑는 수

        Visited = new boolean[N];
        Temp = new int[K];
        Arr = new int[N];
        for(int i=0; i<N; i++){
            Arr[i] = Integer.parseInt(br.readLine());
        }

        BruteForce(0);
        System.out.println(Answer);
    }

    private static void BruteForce(int cnt){

        if(cnt == K){ // 배열 조합이 완성된 경우
            String value = "";
            for(int i : Temp){
                value += i + "";
            }

            if(!completedList.contains(Integer.valueOf(value))){
                completedList.add(Integer.valueOf(value));
                Answer++;
            }

            return;
        }

        for(int i=0; i<N; i++){
            if(Visited[i]) continue;
            Visited[i] = true;

            Temp[cnt] = Arr[i];
            BruteForce(cnt + 1);

            Visited[i] = false;
        }

    }


}
