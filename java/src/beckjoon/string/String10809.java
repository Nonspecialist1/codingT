
package beckjoon.string;

import java.util.Scanner;

public class String10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        char[] arr = new char[str.length()];
        for(int i=0; i<arr.length; i++){
            arr[i] = str.charAt(i);
        }
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for(int i=0; i<alphabet.length; i++){
            int cnt = 0;
            for(int j=0; j<arr.length; j++){
                if(alphabet[i] == arr[j]){
                    System.out.print(j+" ");
                    cnt++;
                    break;
                }
            }
            if(cnt == 0){
                System.out.print(-1 + " ");
            }
        }
    }
}


