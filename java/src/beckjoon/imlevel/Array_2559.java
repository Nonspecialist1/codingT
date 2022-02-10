package beckjoon.imlevel;

import java.util.Scanner;

public class Array_2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int day = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<=N-day; i++){
            int temp = 0;
            for(int j=i; j<i+day; j++){
                temp += arr[j];
            }
            if(temp > max){ max = temp; }
        }
        System.out.println(max);
    }
}
