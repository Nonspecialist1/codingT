package swexpertacademy.imlevel;

import java.util.Arrays;
import java.util.Scanner;

public class BusPath_6485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T_case = sc.nextInt();
        for(int T=1; T<=T_case; T++){
            StringBuilder sb = new StringBuilder();
            int Path = sc.nextInt();
            int[] A = new int[Path];
            int[] B = new int[Path];

            for(int i=0; i<Path; i++){
                A[i] = sc.nextInt();
                B[i] = sc.nextInt();
            }

            int[] P = new int[5001];
            Arrays.fill(P, -1);

            int Point = sc.nextInt();
            int[] idxes = new int[Point];

            for(int i=0; i<Point; i++){
                int idx = sc.nextInt();
                idxes[i] = idx;
                P[idx] = 0;
            }

            for(int i=0; i<Path; i++){
                int st = A[i];
                int end = B[i];
                for(int j=st; j<=end; j++){
                    if(P[j] >= 0) { P[j]++; }
                }
            }

            sb.append("#"+T+" ");
            for(int i=0; i<Point; i++){
                sb.append(P[idxes[i]] + " ");
            }
            System.out.println(sb);
        }
    }
}
