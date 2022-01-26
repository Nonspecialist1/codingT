package swexpertacademy.array;

import java.io.IOException;
import java.util.Scanner;

public class Flatten_1208 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<11; T++){
            int dump = Integer.parseInt(sc.nextLine());
            String[] str = sc.nextLine().split(" ");
            int[] arr = new int[100];
            int max = 0;
            int min = 100;
            int minIdx = 0;
            int maxIdx = 0;
            for(int i=0; i<100; i++){
                arr[i] = Integer.parseInt(str[i]);
                if(arr[i] > max){
                    max = arr[i];
                    maxIdx = i;
                }
                if(arr[i] < min){
                    min = arr[i];
                    minIdx = i;
                }
            }
            for(int i=0; i<dump; i++) {
                arr[maxIdx] -= 1;
                max -= 1;
                arr[minIdx] += 1;
                min += 1;
                for(int k=0; k<100; k++){
                    if(arr[k] > max){
                        max = arr[k];
                        maxIdx = k;
                    }
                    if(arr[k] < min){
                        min = arr[k];
                        minIdx = k;
                    }
                }
            }
            int ans = arr[maxIdx] - arr[minIdx];
            System.out.printf("#%d %d\n", T, ans);
        }
    }
}
