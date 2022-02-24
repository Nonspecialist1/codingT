package swexpertacademy.imlevel;

import java.util.Scanner;

public class FarmYeid_2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T_case = sc.nextInt();
        for(int T=1; T<=T_case; T++){
            int total = 0;

            int N = sc.nextInt();
            if(N == 1){
                total = sc.nextInt();
                System.out.printf("#%d %d\n", T, total); continue;
            }

            int[][] farm = new int[N][N];
            for(int i=0; i<N; i++){
                String[] arr = sc.next().split("");
                for(int j=0; j<N; j++){ farm[i][j] = Integer.parseInt(arr[j]); }
            }

            int mid = N / 2;
            int area = 0;
            for(int i=0; i<N; i++){
                int st = mid - area;
                int end = mid + area;

                for(int j=st; j<=end; j++){ total += farm[i][j]; }

                if(i >= mid) area--;
                else area++;
            }
            System.out.printf("#%d %d\n", T, total);
        }
    }
}
