package swexpertacademy.stack;

import java.io.IOException;
import java.util.Scanner;

public class selfmultifly_1217 {
    static int ans;
    static int cnt;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            int caseNum = sc.nextInt();
            int var = sc.nextInt();
            cnt = sc.nextInt();
            ans = 1;

            int ans = selfMulti(var, cnt);

            System.out.printf("#%d %d\n", caseNum, ans);
        }
    }

    static int selfMulti(int var, int cnt){
        if(cnt == 0){ return ans; }
        else{
            ans *= var;
            cnt--;
        }
        return selfMulti(var, cnt);
    }

}
