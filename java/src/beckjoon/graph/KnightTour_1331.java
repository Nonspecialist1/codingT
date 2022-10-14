package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class KnightTour_1331 {

    static String start;
    static HashMap<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        start = br.readLine();
        map.put(start, true);

        String st = start;
        for(int i=0; i<35; i++){
            String next = br.readLine();

            if(!canMove(st, next)){
                System.out.println("Invalid");
                return;
            }

            if(i == 34 && !canMove(start, next)) { // 마지막 인덱스일 때
                System.out.println("Invalid");
                return;
            }

            map.put(next, true);
            st = next;
        }

        System.out.println("Valid");
    }

    private static boolean canMove(String st, String next){
        if(map.containsKey(next)){
            return false;
        }

        int str = Math.abs(st.charAt(0) - next.charAt(0)); // 알파벳
        int num = Math.abs(st.charAt(1) - next.charAt(1)); // 숫자

        if(str == 1){
            if(num == 2){}
            else return false;
        }
        else if(str == 2){
            if(num == 1){}
            else return false;
        }
        else return false;

        return true;
    }
}
