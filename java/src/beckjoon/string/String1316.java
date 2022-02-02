
package beckjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class String1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int cnt = n;

        for(int i=0; i<n; i++){
            List<Character> list = new LinkedList<>();
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String str  = stk.nextToken();

            for(int j=0; j<str.length(); j++){ list.add(str.charAt(j)); }

            for(int j=0; j<list.size();){
                if(j+1 < list.size()){
                    if(list.get(j) == list.get(j+1)){
                        list.remove(j);
                        j = 0;
                    } else { j++; }
                } else { break; }
            }
            bye:for(int j=0; j<list.size(); j++){
                for(int k=j+1; k<list.size(); k++){
                    if(list.get(j) == list.get(k)){
                        cnt--;
                        break bye;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}

