package swexpertacademy;

public class Practice_selectionArray {
    static int[][] arr = {
            {9, 20, 2, 18, 11},
            {19, 1, 25, 3, 21},
            {8, 24, 10, 17, 7},
            {15, 4, 16, 5, 6},
            {12, 13, 22, 23, 14}
    };

    static boolean isWall(int newRow, int newCol) {
        if(newRow < 0 || newRow >= 5 || newCol < 0 || newCol >= 5) return true;
        return false;
    }

    static int selMin(){
        int minRow = 0, minCol = 0;
        int min = arr[0][0];

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(min > arr[i][j]) {
                    min = arr[i][j];
                    minRow = i; minCol = j;
                }
            }
        }
        arr[minRow][minCol] = 26;
        return min;
    }

    public static void main(String[] args) {
        int[][] sortedArr = new int[5][5];
        int curMin = -1;
        int row, col;
        int newRow = 0, newCol = 0;

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int dirStatus = 0;

        for(int i=0; i<25; i++){
            curMin = selMin();
            row = newRow;
            col = newCol;
            sortedArr[newCol][newRow] = curMin;

            newRow = row + dx[dirStatus];
            newCol = col + dy[dirStatus];
            if(isWall(newRow, newCol) || sortedArr[newCol][newRow] != 0){
                dirStatus = (dirStatus + 1) % 4;
                newRow = row + dx[dirStatus];
                newCol = col + dy[dirStatus];
            }
        }

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
                System.out.printf("%4d", sortedArr[i][j]);
            System.out.println();
        }

    }



}
