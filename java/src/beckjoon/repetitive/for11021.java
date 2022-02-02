
package beckjoon.repetitive;

import java.util.Scanner;

public class for11021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("몇 개를 테스트할까요?");
        int t = sc.nextInt();

        System.out.println("a,b 입력");
        for(int i=1; i<t+1; i++){
            int a = sc.nextInt();
            int b=  sc.nextInt();
            System.out.printf("Case #%d: %d + %d = %d\n", i, a, b, a+b);
        }



    }

}
