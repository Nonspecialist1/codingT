package swexpertacademy.string;

import java.util.Scanner;

public class string_1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++) {
            int tCase = sc.nextInt();
            String find = sc.next();
            String prob = sc.next();
            int cnt = -1;
            int len = find.length();
            int proLen = prob.length();
            if (prob.substring(proLen - len, proLen).equals(find)) {
                cnt = 0;
            }

            String newProb = prob.replace(find, " /");
            String[] arr = newProb.split(" /");
            int ans = arr.length + cnt;
            System.out.printf("#%d %d\n", tCase, ans);
        }
    }
}
