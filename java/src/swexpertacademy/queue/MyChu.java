package swexpertacademy.queue;

import java.io.IOException;

public class MyChu {
    static int q[] = new int[100];
    static int studcan[] = new int[20];
    static int f = -1, r = -1, candies = 20;

    public static void main(String[] args) throws IOException {
        int stNo = 1, incomming_sn = 2;
        for(int i=0; i<20; i++){
            studcan[i] = 1;
        }
        q[++r] = stNo;
        System.out.printf("===>%d번 학생 : 줄을 선다.\n", stNo);

        printQ();
        stNo = q[++f];
        System.out.printf("%d번 학생 : 줄에서 나와....\n", stNo);
        printQ();

        while(candies > 0){
            candies -= studcan[stNo];
            System.out.printf("%d번 학생 : 선생님한테 사탕 %d개를 받는다.\n", stNo, studcan[stNo]);
            System.out.printf("=========== 남은 사탕 개수는 %d개\n\n", candies);
            studcan[stNo]++;

            if(candies <= 0){
                System.out.println(stNo);
                break;
            }
            q[++r] = stNo;
            System.out.printf("%d번 학생 : 다시 줄을 선다.\n", stNo);
            printQ();
            System.out.printf("======>%d번 학생 줄을 선다.\n", incomming_sn);
            q[++r] = incomming_sn++;
            printQ();
            stNo = q[++f];
            System.out.printf("%d번 학생 : 줄에서 나와...\n", stNo);
            printQ();
        }

    }

    static void printQ(){
        System.out.printf("[");
        for(int i=f+1; i<r+1; i++){
            System.out.printf("%d -", q[i]);
        }
        System.out.printf("]\n\n");
    }

}
