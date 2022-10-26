package beckjoon.bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodNumSeq_2661 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    static void func(int last){
        if(sb.length() == N){
            System.out.println(sb);
            System.exit(0);
        }

        for(int i=1; i<4; i++){
            if(i == last) continue;
            sb.append(i);

            // 좋은 수열인지 검사
            boolean flag = false;
            for(int k=2; k<=sb.length()/2; k++){ // 길이 2 부터 sb/2 까지 검사
                if(sb.substring(sb.length()-k-k , sb.length()-k).equals
                        (sb.substring(sb.length()-k, sb.length()))
                ){
                    sb.deleteCharAt(sb.length()-1);
                    flag = true;
                    break;
                }
            }
            if(flag) continue;

            func(i);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        func(0);
    }
}
