package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2024-02-02  16:51
 * @Description: TODO
 * @Version: 1.0
 */
public class Question35 {
    public static boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] rc = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c!='.'){
//因为是数字字符，所以转为数字需要-去0的ascll码，再减去1得到对应的数组下标，因为判断不重复，一行一列中不同的值，只会在二维数组中占用不同的索引，值为1，如果大于1，证明重复了
                    int index = c-'0'-1;
                    rows[i][index]++;
                    columns[j][index]++;
                    rc[i/3][j/3][index]++;
                    if(rows[i][index]>1 || columns[j][index]>1 ||rc[i/3][j/3][index]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(Question35.isValidSudoku(board));
    }
}
