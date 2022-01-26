package swexpertacademy.array;

import java.io.IOException;
import java.util.Scanner;

public class view_1206 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            int[] arr = new int[sc.nextInt()];
            for(int i=0; i<arr.length; i++){
                arr[i] = sc.nextInt();
            }
            int ans = 0;
            for(int i=2; i<arr.length-2; i++){
                if((arr[i] - arr[i-1]) > 0 && (arr[i] - arr[i-2]) > 0 && (arr[i] - arr[i+1]) > 0 && (arr[i] - arr[i+2]) > 0){
                    int firMin = Math.min(arr[i] - arr[i-1], arr[i] - arr[i-2]);
                    int secMin = Math.min(arr[i] - arr[i+1], arr[i] - arr[i+2]);
                    int min = Math.min(firMin, secMin);
                    ans += min;
                }
            }
            System.out.printf("#%d %d\n", T, ans);
        }
    }
}
