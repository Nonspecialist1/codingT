package swexpertacademy.imlevel;

import java.util.Scanner;

public class Multiple_1288 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Tcase = sc.nextInt();
        for(int T=1; T<=Tcase; T++){
            boolean[] visited = new boolean[10];
            boolean flag = false;

            int N = sc.nextInt();

            int i = 1;
            int ans = 0;
            while(!flag){
                flag = true;
                ans = N * i;

                String str = String.valueOf(ans);
                char[] arr = str.toCharArray();

                for(int j=0; j<arr.length; j++){
                    int idx = Integer.parseInt(String.valueOf(arr[j]));
                    visited[idx] = true;
                }

                for(boolean f : visited){ if(!f) { flag = false; break; } }
                i++;
            }

            System.out.printf("#%d %d\n", T, ans);
        }

    }
}
