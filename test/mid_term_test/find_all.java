// 素数筛问题,输入n，结果同时为n的因数和素数
import java.util.*;

public class find_all {
    static public void main(String[] args){
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for(int i = 2; i <= n; i++){
            if(n % i != 0){continue;}
            if(isPrame(i)){
                System.out.println(i + " ");
            }
        }
    }
    static boolean isPrame(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}