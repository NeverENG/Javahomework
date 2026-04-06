package homework3;

import java.util.*;
public class SameArr {
    
    public static boolean equals(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false; 
        }
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false; 
                }
            }
        }
        return true; // 所有元素都相同，返回 true
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("please enter the row:");
         int row = sc.nextInt();
         int[][] m1 = new int[row][row];
         int[][] m2 = new int[row][row];
            System.out.println("please enter the first array:");
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    m1[i][j] = sc.nextInt();
                }

            }
            System.out.println("please enter the second array:");
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    m2[i][j] = sc.nextInt();
                }
            }

            System.out.println("arr1 和 arr2 是否相同？ " + equals(m1, m2));
            sc.close();
        }
}

