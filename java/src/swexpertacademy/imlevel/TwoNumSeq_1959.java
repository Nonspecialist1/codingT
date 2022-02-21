package swexpertacademy.imlevel;

import java.util.Scanner;

public class TwoNumSeq_1959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();

        for(int T=1; T<=10; T++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int inteval = Math.abs(N-M);

            int[] first = new int[N];
            int[] second = new int[M];

            for(int i=0; i<N; i++){ first[i] = sc.nextInt(); }
            for(int j=0; j<M; j++){ second[j] = sc.nextInt(); }

            int ans = 0;
            if(first.length >= second.length)
            {
                for(int k=0; k<=inteval; k++){
                    int val = 0;
                    for(int j=0, i=k; j<M; i++, j++){
                        val += first[i] * second[j];
                    }
                    if(val > ans) ans = val;
                }
            }
            else
            {
                for(int k=0; k<=inteval; k++){
                    int val = 0;
                    for(int j=0, i=k; j<N; i++, j++){
                        val += first[j] * second[i];
                    }
                    if(val > ans) ans = val;
                }
            }
            System.out.printf("#%d %d\n", T, ans);
        }
    }
}
