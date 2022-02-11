package beckjoon.imlevel;

import java.util.Scanner;

public class Rectangle_2527 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 4;
        while(T > 0){
            char ans = '0';

            int firX = sc.nextInt();
            int firY = sc.nextInt();
            int firP = sc.nextInt();
            int firQ = sc.nextInt();

            int secX = sc.nextInt();
            int secY = sc.nextInt();
            int secP = sc.nextInt();
            int secQ = sc.nextInt();

            //분리형 일 때
            if(firX > secP || firP < secX || firY > secQ || firQ < secY){ ans = 'd'; }
            // 꼭짓점 맞닿을 때
            else if
            (
                    (firX == secP && firY == secQ) || (firX == secP && firQ == secY) ||
                     (firP == secX && firQ == secY) || (firP == secX && firY == secQ)
            ) ans = 'c';
            // 선분 맞닿을 때
            else if ( firX == secP || firP == secX || firY == secQ || firQ == secY ) ans = 'b';
            else ans = 'a';

            T--;
            System.out.println(ans);
        }
    }

}
