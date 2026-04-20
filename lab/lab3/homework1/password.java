package homework1;

import java.util.*;
public class password{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();

        String result = password.matches("^(?=.*\\d.*\\d).{8}$")? "Valid Password":"Invalid Password";
        System.out.println(result);
        input.close();
    }
}