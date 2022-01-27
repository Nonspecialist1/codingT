package swexpertacademy.array2;

public class Practice_selectionArray {
    static int[][] arr = {
            {9, 20, 2, 18, 11},
            {19, 1, 25, 3, 21},
            {8, 24, 10, 17, 7},
            {15, 4, 16, 5, 6},
            {12, 13, 22, 23, 14}
    };
    static int min = 100;
    static int row = 0;
    static int col = 0;

    public static void main(String[] args) {
        arr = selectionSort(arr, row, col);

        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }


    static boolean[][] check = new boolean[5][5];

    static int[][] selectionSort(int[][] arr, int row, int col){
        while(row < 5 && col < 5){
            min = arr[row][col];
            for(int i=row; i<5; i++) {
                int iCol = 0;
                if(i == row) { iCol = col; }
                for (int j=iCol; j < 5; j++) {
                    if(arr[i][j] < min){
                        min = arr[i][j];
                        arr[i][j] = arr[row][col];
                        arr[row][col] = min;
                    }
                }
            }
            check[row][col] = true;

            // 열이 벽을 만났을 때 밑으로 꺽기
            if((col+1 <5 && check[row][col+1] == true) || col+1 > 5){
                if(row != 4){ row++; }
            }
            // 행이 벽을 만났을 때 좌로 꺽기
            if((row+1 < 5 && check[row+1][col] == true) || row+1 > 5){
                if(col != 0){ col--; }
            }
            // 열이 벽을 만났을 때 위로 꺽기
            if((col-1 > 0 && check[row][col-1] == true) || col-1 < 0) {
                if(row != 0){ row--; }
            }
            // 행열이 벽을 만나지 않았을 때
            else  {
                if(col != 4){ col++; }
            }
            selectionSort(arr, row, col);
        }
        return arr;
    }

}
