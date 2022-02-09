package beckjoon.imlevel;

import java.util.Scanner;

public class Sequence_2491 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++) { arr[i] = sc.nextInt(); }

        int inCnt = 1;
        int deCnt = 1;
        int max = 1;
        for(int i=1; i<N; i++){
            if(arr[i] > arr[i-1]){
                deCnt = 1;
                inCnt++;
            }
            else if(arr[i] < arr[i-1]){
                inCnt = 1;
                deCnt++;
            }
            else {
                inCnt++;
                deCnt++;
            }
            if(inCnt > max){ max = inCnt; }
            if(deCnt > max){ max = deCnt; }
        }
        System.out.println(max);
    }
}
