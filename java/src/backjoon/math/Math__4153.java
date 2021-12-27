
package backjoon.math;

import java.util.Arrays;
import java.util.Scanner;

public class Math__4153 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] n = new int[3];
        while(true){
            n[0]=s.nextInt();
            n[1]=s.nextInt();
            n[2]=s.nextInt();
            if(n[0]+n[1]+n[2]==0) break;
            Arrays.sort(n);
            System.out.println(n[2]*n[2]==n[1]*n[1]+n[0]*n[0]?"right":"wrong");
        }
    }
}
