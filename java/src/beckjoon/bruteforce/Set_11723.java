package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Set_11723 {

    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int M, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());

        while (M != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();

            if(!a.equals("all") && !a.equals("empty")) {
                n = Integer.parseInt(st.nextToken());
            }

            switch (a){
                case "add" : if(!list.contains(n)) list.add(n);
                    break;
                case "remove" : if(list.contains(n)) list.removeIf(i -> i == n);
                    break;
                case "check" :
                    if(list.contains(n)){ sb.append(1 + "\n"); }
                    else sb.append(0 + "\n");
                    break;
                case "toggle" :
                    if(list.contains(n)){ list.removeIf(i -> i == n); }
                    else list.add(n);
                    break;
                case "all" : list = new ArrayList<>();
                    for(int i=1; i<=20; i++){
                        list.add(i);
                    }
                    break;
                case "empty" : list = new ArrayList<>();
                    break;
            }

            M--;
        }
        System.out.println(sb);
    }
}
