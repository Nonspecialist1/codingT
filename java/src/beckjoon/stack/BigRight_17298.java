package beckjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigRight_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] origin = new int[N];
        int[] stack = new int[N];
        int top = -1;

        for(int i=0; i<N; i++){ origin[i] = Integer.parseInt(st.nextToken()); }

        stack[++top] = 0;
        for(int i=1; i<N; i++){
            while(top != -1 && origin[i] > origin[stack[top]]){
                int idx = stack[top--];
                origin[idx] = origin[i];
            }
            stack[++top] = i;
        }
        while(top != -1){
            int idx = stack[top--];
            origin[idx] = -1;
        }

        for(int i : origin ){ sb.append(i + " "); }
        System.out.print(sb);
    }
}


