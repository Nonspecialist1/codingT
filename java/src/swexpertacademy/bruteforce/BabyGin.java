package swexpertacademy.bruteforce;

import java.util.Scanner;

public class BabyGin {
    static int[] arr;
    static Scanner sc = new Scanner(System.in);
//    public static void main(String[] args) {
//
//        String[] str = sc.next().split("");
//        int[] arr = new int[6];
//        for(int i=0; i<6; i++) arr[i] = Integer.parseInt(str[i]);
//        // BabyGin 포문으로 구하기
//        a:for(int i=0; i<6; i++) {
//            for (int j = 0; j < 6; j++) {if (j != i) {
//                    for (int k = 0; k < 6; k++) {if (k != i && k != j) {
//                            for (int x = 0; x < 6; x++) {if (x != i && x != j && x != k) {
//                                    for (int y = 0; y < 6; y++) {if (y != i && y != j && y != k && y != x) {
//                                            for (int z = 0; z < 6; z++)
//                                            {
//                                                if (z != i && z != j && z != k && z != x && z != y)
//                                                {
//                                                    int triple = 0;
//                                                    int run = 0;
//                                                    if(arr[i] == arr[j] && arr[j] == arr[k]){ triple++; }
//                                                    if(arr[x] == arr[y] && arr[y] == arr[z]){ triple++; }
//                                                    if(arr[i] + 1 == arr[j] && arr[j] + 1 == arr[k]){ run++; }
//                                                    if(arr[x] + 1 == arr[y] && arr[y] + 1 == arr[z]){ run++; }
//                                                    if(run + triple >= 2){
//                                                        System.out.printf("%d%d%d%d%d%d\n", arr[i], arr[j], arr[k], arr[x], arr[y], arr[z]);
//                                                        System.out.println("baby gin !!!"); break a;
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//    }

    public static void main(String[] args) {
        String[] str = sc.next().split("");
        arr = new int[6];
        for(int i=0; i<6; i++) arr[i] = Integer.parseInt(str[i]);

        perm(6, 0);
    }
    static void perm(int n, int k){
        if(n == k){
            int triple = 0;
            int run = 0;
            if(arr[0] == arr[1] && arr[1] == arr[2]){ triple++; }
            if(arr[3] == arr[4] && arr[4] == arr[5]){ triple++; }
            if(arr[0] + 1 == arr[1] && arr[1] + 1 == arr[2]){ run++; }
            if(arr[3] + 1 == arr[4] && arr[4] + 1 == arr[5]){ run++; }
            if(run + triple >= 2) {
                System.out.printf("%d%d%d%d%d%d\n", arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
                System.out.println("baby gin !!!");
                return;
            }
            return;
        }
        else {
            for(int i=k; i<n; i++){
                swap(k,i);
                perm(n, k+1);
                swap(k,i);
            }
        }
    }
    static void swap(int k, int i){
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }



}
