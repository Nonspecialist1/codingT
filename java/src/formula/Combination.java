package formula;

public class Combination {
    static int[] arr = { 1, 2, 3, 4 };
    // nCr 조합
    static int N = 4, R = 2;
    static int[] temp = new int[R];

    static int cnt_r = 1;

    public static void main(String[] args) {
        comb(N, R);

        String s = "시간";

        // 반복문 조합 4C2인 경우
        // 중복 조합의 경우 j=i 로 두번째 반복문 돌려주면 됨
//        for(int i=0; i<N-1; i++){
//            for(int j=i+1; j<N; j++){
//                System.out.printf("[%d] : ", cnt_r++);
//                System.out.println(arr[i] + " " + arr[j]);
//            }
//        }
    }

    static void print_arr(){
        System.out.printf("[%d] : ", cnt_r++);

        for(int i=0; i<R; i++){
            System.out.print(temp[i] + " ");
        }
        System.out.println();
    }

    // 순열 생성 재귀적 알고리즘
    static void comb(int n, int r){
        if(r == 0) print_arr();
        else if(n < r) return;
        else
        {
            temp[r-1] = arr[n-1];
            comb(n-1, r-1);
            comb(n-1, r);
        }
    }

    // 중복 순열 생성 재귀적 알고리즘
    static void comb2(int n, int r){
        if(r == 0) print_arr();
        else if(n == 0) return;
        else
        {
            temp[r-1] = arr[n-1];
            comb(n, r-1);
            comb(n-1, r);
        }
    }
}
