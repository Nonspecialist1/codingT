package beckjoon.imlevel;

import java.util.Arrays;
import java.util.Scanner;
public class SevenDwarf_10158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);

        int exIdx1 = 0;
        int exIdx2 = 0;
        top:for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100)
                {
                    exIdx1 = i;
                    exIdx2 = j;
                    break top;
                }
            }
        }
        for(int i=0; i<9; i++){
            if(i == exIdx1 || i == exIdx2){ continue; }
            System.out.println(arr[i]);
        }

    }
}
