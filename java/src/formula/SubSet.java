package formula;

public class SubSet {
    static int[] arr = { 10, 20, 3, 4 };
    // 부분집합의 길이
    static int N = 4;
    static boolean[] visited = new boolean[N];

    static int cnt_r = 1;

    public static void main(String[] args) {
        // 재귀적 구현
        powerSet(0);
        // 비트 마스크 구현은 못함 ㅜㅜ
    }

    static void powerSet(int idx){
        if(idx == N){
            print_arr();
            return;
        }
        visited[idx] = false;
        powerSet(idx+1);
        visited[idx] = true;
        powerSet(idx+1);
    }

    static void print_arr(){
        System.out.printf("[%d] : ", cnt_r++);

        for(int i=0; i<N; i++){
            if(visited[i]) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
