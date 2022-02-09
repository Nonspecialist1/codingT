package beckjoon.imlevel;

import java.util.Scanner;

public class makeLine_2605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0, stu=1; i<N; i++, stu++){
            int plus = sc.nextInt();
            if(plus > 0){
                for(int j=i; j>=i-plus+1; j--){ arr[j] = arr[j-1]; }
                arr[i-plus] = stu;
            }
            else{ arr[i] = stu; }
        }
        for(int i : arr){ System.out.print(i + " "); }
    }
}
