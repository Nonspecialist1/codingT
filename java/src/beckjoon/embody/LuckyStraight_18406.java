package beckjoon.embody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyStraight_18406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String left = s.substring(0, s.length()/2);
        String right = s.substring(s.length()/2);

        int leftSum = 0;
        int rightSum = 0;

        for(char l : left.toCharArray()){
            leftSum += l - '0';
        }
        for(char r : right.toCharArray()){
            rightSum += r - '0';
        }

        if(leftSum == rightSum){
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }

}
