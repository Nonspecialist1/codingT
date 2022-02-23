package beckjoon.stack;

import java.util.Scanner;

public class Alphabet_10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ans = new int[26];
        char[] arr = sc.next().toCharArray();

        for(int i=0; i<arr.length; i++){ ans[arr[i] - 97]++; }

        for(int i : ans){ System.out.print(i + " "); }
    }
}
