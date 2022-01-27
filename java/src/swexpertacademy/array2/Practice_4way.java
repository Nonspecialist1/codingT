package swexpertacademy.array2;

public class Practice_4way {
    public static void main(String[] args) {
        int[][]arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] ans = new int[5][5];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                int sum = 0;
                for(int k=0; k<4; k++){
                    int newI = i + dy[k];
                    int newJ = j + dx[k];
                    if(newI >= 0 && newI < 5 && newJ >= 0 && newJ < 5){
                        sum += Math.abs(arr[newI][newJ] - arr[i][j]); }
                    }
                ans[i][j] = sum;
            }
        }

        for(int[] i : ans){
            for(int k : i){
                System.out.println(k);
            }
        }




    }
}
