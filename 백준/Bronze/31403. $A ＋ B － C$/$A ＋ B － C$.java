import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        int result = Integer.parseInt(str);
        
        String tempStr = sc.nextLine();
        result += Integer.parseInt(tempStr);
        str += tempStr;
        
        tempStr = sc.nextLine();
        result -= Integer.parseInt(tempStr);

        System.out.println(result);
        System.out.println(Integer.parseInt(str) - Integer.parseInt(tempStr));
        
    }
}