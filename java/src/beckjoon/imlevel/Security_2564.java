package beckjoon.imlevel;

import java.util.Scanner;
import java.util.Stack;

public class Security_2564 {
    static int X;
    static int Y;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        X = sc.nextInt();
        Y = sc.nextInt();
        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            int dir = sc.nextInt();
            int pos = sc.nextInt();
            st.push(dir); st.push(pos);
        }
        int dongDir = sc.nextInt();
        int dongPos = sc.nextInt();

        while(!st.isEmpty()) {
            int shopPos = st.pop();
            int shopDir = st.pop();
            if(dongDir == 1) // 동근이가 북쪽일 때
            {
                if(shopDir == 1){ ans += Math.abs(dongPos - shopPos); }
                else if(shopDir == 2){
                    int tempShopPos = X - shopPos;
                    int tempDongPos = X - dongPos;
                    ans += Math.min(tempDongPos+tempShopPos, dongPos+shopPos) + Y;
                }
                else if(shopDir == 3){ ans += dongPos + shopPos; }
                else if(shopDir == 4){ ans += (X - dongPos) + shopPos; }
            }
            else if(dongDir == 2)
            {
                if(shopDir == 2){ ans += Math.abs(dongPos - shopPos); }
                else if(shopDir == 1){
                    int tempShopPos = X - shopPos;
                    int tempDongPos = X - dongPos;
                    ans += Math.min(tempDongPos+tempShopPos, dongPos+shopPos) + Y;
                }
                else if(shopDir == 3){ ans += dongPos + (Y-shopPos); }
                else if(shopDir == 4){ ans += (X - dongPos) + (Y-shopPos); }
            }
            else if(dongDir == 3)
            {
                if(shopDir == 1){ ans += dongPos + shopPos; }
                else if(shopDir == 2){ ans += (Y-dongPos) + shopPos; }
                else if(shopDir == 3){ ans += Math.abs(dongPos - shopPos); }
                else if(shopDir == 4){
                    int tempShopPos = Y - shopPos;
                    int tempDongPos = Y - dongPos;
                    ans += Math.min(tempDongPos+tempShopPos, dongPos+shopPos) + X;
                }
            }
            else if(dongDir == 4)
            {
                if(shopDir == 1){ ans += dongPos + (X-shopPos); }
                else if(shopDir == 2){ ans += (Y-dongPos) + (X-shopPos); }
                else if(shopDir == 3){
                    int tempShopPos = Y - shopPos;
                    int tempDongPos = Y - dongPos;
                    ans += Math.min(tempDongPos+tempShopPos, dongPos+shopPos) + X;
                }
                else if(shopDir == 4){ ans += Math.abs(dongPos - shopPos); }
            }
        }

        System.out.println(ans);
    }
}
