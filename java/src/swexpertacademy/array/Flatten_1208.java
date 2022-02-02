package swexpertacademy.array;

import java.util.Scanner;

public class Flatten_1208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            int dump = sc.nextInt();
            int[] arr = new int[100];
            int minIdx = 0;
            int maxIdx = 0;
            for(int i=0; i<100; i++){
                arr[i] = sc.nextInt();
                if(arr[i] > arr[maxIdx]){ maxIdx = i; }
                if(arr[i] < arr[minIdx]){ minIdx = i; }
            }
            while(dump != 0){
                arr[maxIdx]--;
                arr[minIdx]++;
                for(int i=0; i<100; i++){
                    if(arr[i] > arr[maxIdx]){ maxIdx = i; }
                    if(arr[i] < arr[minIdx]){ minIdx = i; }
                }
                dump--;
            }
            System.out.printf("#%d %d\n", T, arr[maxIdx] - arr[minIdx]);
        }
    }
}
