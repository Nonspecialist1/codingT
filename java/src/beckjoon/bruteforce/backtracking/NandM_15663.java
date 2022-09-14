package beckjoon.bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class NandM_15663 {
    static int[] arr, temps;
    //static boolean[] visited;
    static int N, R; // nPr
    static LinkedHashSet<String> set = new LinkedHashSet<>(); // 중복을 피하기위해 Set 활용, TreeSet은 String 기준 다시 오름차순으로 정렬되므로 기피

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N];
        // visited = new boolean[N];
        temps = new int[R];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        perm(0);
        set.forEach(System.out::println);
    }

    static void perm(int r){
        if(r == R){
            StringBuilder tempSB = new StringBuilder();
            for(int i=0; i<R; i++){
                tempSB.append(temps[i] + " ");
            }
            set.add(tempSB.toString());
            return;
        }

        for(int i=0; i<N; i++){
            temps[r] = arr[i];
            perm(r+1);
        }
    }

}
