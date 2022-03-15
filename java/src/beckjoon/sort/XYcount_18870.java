package beckjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class XYcount_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] arr2 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr2[i] = arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        HashMap<Integer, Integer> map = new HashMap<>();
        int val = 0;
        for(int i : arr){
            if(!map.containsKey(i)) map.put(i, val++);
        }

        StringBuilder sb = new StringBuilder();
        for(int i : arr2){
            sb.append(map.get(i) + " ");
        }
        System.out.print(sb);
    }
}
