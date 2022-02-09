package beckjoon.imlevel;

import java.util.Scanner;

public class Ant_10158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int t = sc.nextInt();

        int newX = ((X + t) % (W * 2));
        int newY = ((Y + t) % (H * 2));
        int ansX = W - Math.abs(W - newX);
        int ansY = H - Math.abs(H - newY);

        System.out.println(ansX + " " + ansY);
    }
}
