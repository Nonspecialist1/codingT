package beckjoon.math;


import java.io.IOException;
import java.util.Scanner;

public class One_4375 {

    static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            N =  sc.nextInt();
            System.out.println(BruteForce());
        }
    }

    private static int BruteForce(){
        int n = 0;

        for(int i=1; ; i++){
            n = n * 10 + 1;
            n %= N;
            if(n == 0){
                return i;
            }
        }
    }

}
