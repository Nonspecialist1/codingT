package swexpertacademy.imlevel;

import java.util.Scanner;

public class Danzo_6190 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Tcase = sc.nextInt();
        for(int T=1; T<=Tcase; T++){
            int N = sc.nextInt();
            int[] arr = new int[N];

            for(int i=0; i<N; i++){ arr[i] = sc.nextInt(); }

            int ans = -1;
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    int val = arr[i] * arr[j];
                    if(checkDanzo(val)){ if(val > ans) ans = val; }
                }
            }

            System.out.printf("#%d %d\n", T, ans);
        }
    }

    static boolean checkDanzo(int val){
        String str = String.valueOf(val);
        boolean flag = true;

        if(str.length() == 1){ return flag; }
        else {
            for(int i=0; i<str.length() - 1; i++){
                String s = String.valueOf(str.charAt(i));
                String t = String.valueOf(str.charAt(i+1));
                if(Integer.valueOf(t) < Integer.valueOf(s)){ flag = false; break; }
            }
            return flag;
        }
    }

}
