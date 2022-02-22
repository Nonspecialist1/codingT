package swexpertacademy.imlevel;

import java.util.Scanner;

public class MemoryRestore_1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Tcase = sc.nextInt();
        for(int T=1; T<=Tcase; T++){
            String s = sc.next();
            char[] memory = s.toCharArray();

            int cnt = 0;
            boolean flag = false;

            for(int i=0; i<memory.length; i++){
                if(memory[i] == '1' && !flag){
                    flag = true; cnt++;
                }
                else if(memory[i] == '0' && flag){
                    flag = false; cnt++;
                }
            }

            System.out.printf("#%d %d\n", T, cnt);
        }

    }
}
