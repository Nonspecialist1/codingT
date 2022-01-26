package swexpertacademy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class List_numberCard_4834 {
    public static void main(String[] args) throws IOException {
        Long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String N = br.readLine();
            String s = br.readLine();
            char[] chArr = s.toCharArray();
            char maxNum = '0';
            char max = '0';
            int cnt = 1;
            for(int j=0; j<chArr.length; j++){
                int inCnt = 1;
                char overlap = 'o';
                if(chArr[j] == overlap) {
                    continue;
                }
                for(int k=j+1; k< chArr.length; k++){
                    if(chArr[j] == chArr[k]){
                        inCnt++;
                        overlap = chArr[k];
                    }
                }
                if(Integer.parseInt(String.valueOf(max)) < Integer.parseInt(String.valueOf(chArr[j]))){
                    max = chArr[j];
                }
                if(inCnt < cnt){
                    continue;
                }
                else if(inCnt > cnt){
                    maxNum = chArr[j];
                    cnt = inCnt;
                } else if(inCnt == cnt){
                    maxNum = max;
                }
            }
            System.out.printf("#%d %s %d\n", i+1, maxNum, cnt);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
