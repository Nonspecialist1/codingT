package swexpertacademy.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class findRoad_1219 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            Stack<Integer> st = new Stack<>();
            int caseNum = sc.nextInt();
            int totalRoad = sc.nextInt();
            int[] firRoad = new int[100];
            int[] secRoad = new int[100];
            int ansIdx = 0;
            int ans = 0;

            for(int i=0; i<totalRoad; i++){
                int idx = sc.nextInt();
                if(firRoad[idx] == 0){ firRoad[idx] = sc.nextInt(); }
                else{ secRoad[idx] = sc.nextInt(); }

                if (firRoad[idx] == 99 || secRoad[idx] == 99){
                    ansIdx = idx;
                    st.push(idx);
                }
            }

            int k = 0;
            while(true){
                if(st.isEmpty()){ break; }
                int pop = st.pop();
                for(int i=0; i<100; i++){
                    if(firRoad[i] == pop || secRoad[i] == pop){
                        st.push(i);
                        if(k == 0){ st.push(ansIdx); }
                        k++;
                    }
                    if(st.isEmpty() == false && st.peek() == 0){ break; }
                }
                if(st.isEmpty() == false && st.peek() == 0){ ans = 1; break; }
            }
            System.out.printf("#%d %d\n", caseNum, ans);
        }
    }

}
