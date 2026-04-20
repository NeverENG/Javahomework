package homework2;

import java.util.Scanner;

public class search {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 提示输入方阵行数
        System.out.print("Enter the number of rows in the square matrix: ");
        int n = scanner.nextInt();
        
        // 创建矩阵
        int[][] matrix = new int[n][n];
        
        // 逐行输入矩阵（按题目示例格式）
        System.out.println("Enter the matrix row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        // 动态规划求解最大全1子方阵
        int[][] dp = new int[n][n];  // dp[i][j] 表示以(i,j)为右下角的最大正方形边长
        int maxSize = 0;
        int maxRow = 0;
        int maxCol = 0;
        
        // 自上而下、从左到右遍历，逐步记录
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // 边界情况：第一行或第一列
                        dp[i][j] = 1;
                    } else {
                        // 状态转移：取左、上、左上三个方向的最小值 + 1
                        dp[i][j] = Math.min(dp[i-1][j], 
                                   Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                    
                    // 更新全局最大值（记录右下角位置）
                    if (dp[i][j] > maxSize) {
                        maxSize = dp[i][j];
                        maxRow = i;
                        maxCol = j;
                    }
                } else {
                    dp[i][j] = 0;  // matrix[i][j] == 0 时，无法形成以它为右下角的正方形
                }
            }
        }
        
        // 计算左上角位置（第一个元素位置）
        int topLeftRow = maxRow - maxSize + 1;
        int topLeftCol = maxCol - maxSize + 1;
        
        // 按题目要求格式输出
        System.out.println("The maximum square submatrix is at (" + topLeftRow + ", " + topLeftCol + ") with size " + maxSize);
        
        scanner.close();
    }
}

