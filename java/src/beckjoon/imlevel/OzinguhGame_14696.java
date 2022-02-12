package beckjoon.imlevel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class OzinguhGame_14696 {
    static Integer[] A;
    static Integer[] B;
    static int minLen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        a:for(int i=0; i<N; i++){
            int an = sc.nextInt();
            A = new Integer[an];
            for(int j=0; j<an; j++){ A[j] = sc.nextInt(); }

            int bn = sc.nextInt();
            B = new Integer[bn];
            for(int j=0; j<bn; j++){ B[j] = sc.nextInt(); }

            if(an > bn) minLen = bn;
            else minLen = an;

            Arrays.sort(A, Comparator.reverseOrder());
            Arrays.sort(B, Comparator.reverseOrder());

            for(int j=0; j<minLen; j++){
                if(A[j] > B[j]) { System.out.println('A'); continue a; }
                else if(A[j] == B[j]) { continue; }
                else { System.out.println('B'); continue a; }
            }

            if(an == bn){ System.out.println('D'); }
            else if(an > bn){ System.out.println('A'); }
            else { System.out.println('B'); }
        }
    }

}
