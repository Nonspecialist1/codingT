public class Permutation {
    static int[] arr = { 10, 20, 3, 4 };

    static int N = arr.length, R = 4;
    static int[] temp = new int[R];
    static boolean[] visited = new boolean[N];

    static int cnt_r = 1;

    public static void main(String[] args) {
        perm(0);

        // 반복문으로 순열 4P2 인 경우
        // 중복 순열의 경우 j != i 조건문 삭제해주면 됨
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                if(j != i) {
//                    System.out.printf("[%d] : ", cnt_r++);
//                    System.out.println(arr[i] + " " + arr[j]);
//                }
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
    // 중복 순열의 경우 visited 삭제해주면 됨
    static void perm(int idx){
       if(idx == R) print_arr();
       else
           for(int i=0; i<N; i++){
               if(!visited[i]){
                   temp[idx] = arr[i];
                   visited[i] = true;
                   perm(idx+1);
                   visited[i] = false;
               }
           }
    }

}
