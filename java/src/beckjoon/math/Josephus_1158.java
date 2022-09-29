package beckjoon.math;

import java.util.ArrayList;
import java.util.Scanner;

public class Josephus_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N+1];
        for(int i=1; i<N+1; i++){ arr[i] = i; }

        int cnt = 0;
        while(list.size() != N){
            for(int i=1; i<N+1; i++){
                if(arr[i] != 0) {
                    cnt++;
                    if(cnt % K == 0 && arr[i] != 0){
                        list.add(arr[i]);
                        arr[i] = 0;
                    }
                }
            }
        }

        System.out.printf("<");
        for(int i=0; i<list.size(); i++){
            if(i == list.size()-1){ System.out.printf("%d>", list.get(i)); }
            else{ System.out.printf("%d, ", list.get(i)); }
        }
    }
}

