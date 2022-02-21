package beckjoon.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class IronBar_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int result = 0;
        int cnt = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == '('){ cnt++; }
            else
            {
                if(arr[i-1] == '('){
                    cnt--;
                    result += cnt;
                }
                else {
                    result++;
                    cnt--;
                }
            }
        }
        System.out.println(result);
    }
}


