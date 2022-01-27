package swexpertacademy;

public class bitPractice {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, -1, -2, -3, -4, -5};
        int sum;
        int n = arr.length;
        int count = 0;

        // 공집합은 제외시키기 위해 i=1 부터, 공집합의 합을 물어보는 게 맞냐
        for(int i=1; i<(1<<n)-1; i++){
            sum = 0;
            for(int j=0; j<n-1; j++){
                if((i & (1 << j)) != 0){
                    sum += arr[j];
                }
            }
            if(sum == 0){
                System.out.printf("[%d] ", ++count);
                for(int j=0; j<10; j++){
                    if((i & (1 << j)) != 0){
                        System.out.printf("%d ", arr[j]);
                    }
                }
                System.out.println();
            }
        }



    }
}
