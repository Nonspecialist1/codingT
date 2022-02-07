package swexpertacademy.queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Password_1225 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<8; i++){
                int k = sc.nextInt(); q.add(k);
            }
            int i = 1;
            while(true){
                int temp = q.poll() - i;
                if(temp < 1){ q.add(0); break; }
                q.add(temp); i++;
                if(i == 6){ i = 1; }
            }
            StringBuilder sb = new StringBuilder();
            for(int j : q){ sb.append(j+" "); }
            System.out.printf("#%d %s\n", T,sb);
        }
    }
}
