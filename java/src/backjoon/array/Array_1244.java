package backjoon.array;

import java.util.Scanner;

public class Array_1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        boolean[] arr = new boolean[size+1];
        for(int i=1; i<arr.length; i++){
            int k = sc.nextInt();
            arr[i] = (k == 1) ? true : false;
        }
        int T = sc.nextInt();
        while(T != 0){
            int gender = sc.nextInt();
            int idx = sc.nextInt();
            if(gender == 1){
                for(int i=1; i<arr.length; i++){
                    if(i % idx == 0){
                        if(arr[i]){ arr[i] = false; }
                        else{ arr[i] = true; }
                    }
                }
            }
            else if(gender == 2){
                if(arr[idx]){ arr[idx] = false; }
                else{ arr[idx] = true; }

                int breadth = 0;
                while(true){
                    if(idx-breadth-1 >= 1 && idx+breadth+1 < arr.length && arr[idx-breadth-1] == arr[idx+breadth+1]){
                        if(arr[idx-breadth-1]){
                            arr[idx-breadth-1] = false;
                            arr[idx+breadth+1] = false;
                        }
                        else{
                            arr[idx-breadth-1] = true;
                            arr[idx+breadth+1] = true;
                        }
                        breadth++;
                    }
                    else{ break; }
                }
            }
            T--;
        }
        int cnt = 0;
        for(int i=1; i<arr.length; i++){
            if(cnt == 20){
                System.out.println();
                cnt = 0;
            }
            int k = arr[i] == true ? 1 : 0;
            System.out.printf(k + " ");
            cnt++;
        }

    }
}
