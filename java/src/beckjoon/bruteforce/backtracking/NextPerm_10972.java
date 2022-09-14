package beckjoon.bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NextPerm_10972 {

    static int[] find;
    static int N, Idx = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        find = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            find[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        if(Idx == -1) System.out.println(Idx);
        else {
            for(int i=N-1; i>Idx; i--){
                if(find[Idx] > find[i]){
                    swap(Idx, i);

                    int start = Idx+1;
                    int end = N-1;
                    while(start < end){
                        swap(start, end);
                        start++;
                        end--;
                    }
                    break;
                }
            }
            for(int i : find){
                System.out.print(i + " ");
            }
        }
    }

    static void swap(int a, int b){
        int fir = find[a];
        find[a] = find[b];
        find[b] = fir;
    }

    static void solve(){
        for(int i=N-1; i>0; i--){
            if(find[i] < find[i-1]){
                Idx = i-1;
                return;
            }
        }
    }

}
