package homework2;

public class mergeArr {
    public static int[] arrmarge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] merged = new int[len1 + len2];
        
        int i = 0, j = 0, k = 0;
        // 合并但是不排序
       for (i = 0; i < len1; i++) {
            merged[k++] = arr1[i];
        }
        for (j = 0; j < len2; j++) {
            merged[k++] = arr2[j];
        }
        return merged;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5 , 4 , 4, 4 , 4 ,4 , 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};
        
        int[] mergedArr = arrmarge(arr1, arr2);
        
        System.out.println("合并后的数组:");
        for (int num : mergedArr) {
            System.out.print(num + " ");
        }
    }
}
