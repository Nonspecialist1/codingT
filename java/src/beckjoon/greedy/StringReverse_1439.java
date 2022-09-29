package beckjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverse_1439 {

    private static String Str;
    private static int Answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Str = br.readLine();

        solve();
        System.out.println(Answer);
    }

    private static void solve(){
        String[] arr = Str.split("");
        String st = arr[0];
        String pre = "";

        for(int i=1; i<Str.length(); i++){
            String next = arr[i];

            if(!st.equals(next)){ // 다른 거 찾았을 때
                if(next.equals(pre)) continue;
                Answer++;
            }
            pre = next;
        }
    }




}
