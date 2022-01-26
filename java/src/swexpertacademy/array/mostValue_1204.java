package swexpertacademy.array;

import java.io.IOException;
import java.util.Scanner;

public class mostValue_1204 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int Tcase = sc.nextInt();
        for(int T=1; T<=Tcase; T++){
            int caseNum = sc.nextInt();
            int[] arr = new int[1000];
            for(int i=0; i<1000; i++){
                arr[i] = sc.nextInt();
            }
            int cnt = 0;
            int idx = 0;
            for(int i=0; i<1000; i++){
                int icnt = 0;
                for(int j=i+1; j<1000; j++){
                    if(arr[i] == arr[j]){
                        icnt++;
                    }
                    if(icnt > cnt){
                        cnt = icnt;
                        idx = i;
                    }else if(icnt == cnt){
                        if(arr[i] > arr[idx]){
                            idx = i;
                        }
                    }
                }
            }
            int ans = arr[idx];
            System.out.printf("#%d %d\n", caseNum, ans);
        }
    }


}
