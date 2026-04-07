package homework3;

import java.util.Scanner;
public class StudentMajorAndStatus {
    String major;
    String status;
    Scanner input = new Scanner(System.in);
    public String SwitchMajor(String major){
        switch(major){
            case "CS":
                return "Computer Science";
            case "Math":
                return "Mathematics";
            case "IT":
                return "Information Technology";
            case "O":
                return "Other";
            default:
                return "Unknown Major";
        }
    }
    public String SwitchStatus(String status){
        switch(status){
            case "1":
                return "Freshman";
            case "2":
                return "Sophomore";
            case "3":
                return "Junior";
            case "4":
                return "Senior";
            default:
                return "Unknown Status";
        }
    }    public static void main(String[] args) {
        StudentMajorAndStatus student = new StudentMajorAndStatus();
        System.out.print("Enter your major (CS, Math, IT): ");
        String majorInput = student.input.nextLine().toUpperCase();
        System.out.print("Enter your status (1 for Freshman, 2 for Sophomore, 3 for Junior, 4 for Senior): ");
        String statusInput = student.input.nextLine();
        
        String majorResult = student.SwitchMajor(majorInput);
        String statusResult = student.SwitchStatus(statusInput);
        
        System.out.println("Your major is: " + majorResult);
        System.out.println("Your status is: " + statusResult);
    }
}
