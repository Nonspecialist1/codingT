
package beckjoon.array;

import java.util.Scanner;

public class Array4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        int[] group;
        float[] rate = new float[arr.length];

        float avg = 0;

        for(int i=0; i<arr.length; i++){
            group = new int[sc.nextInt()];
            int total = 0;
            float cnt = 0;
            for(int j=0; j<group.length; j++){
                group[j] = sc.nextInt();
                total += group[j];
            }
            avg = total / group.length;
            for(int j=0; j<group.length; j++){
                if(group[j] > avg){
                    cnt++;
                }
            }
            rate[i] = (cnt / group.length) * 100;
        }

        for(int i=0; i<rate.length; i++){
            System.out.printf("%.3f%%\n", rate[i]);
        }

    }
}

