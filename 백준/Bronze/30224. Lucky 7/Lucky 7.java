import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        br.close();
        int inputToInt = Integer.parseInt(input);
        
        if (!input.contains("7")) {
            if (inputToInt % 7 != 0) System.out.println("0");
            else System.out.println("1");
        } else {
            if (inputToInt % 7 != 0) System.out.println("2");
            else System.out.println("3");
        }     
    }
}
/*
Fact or Fiction, some people consider 7 to be a lucky digit/number.

Given a number, determine how lucky the number is by printing one of four values:

Print 0 if the number does not contain 7 and is not divisible by 7.
Print 1 if the number does not contain 7 but is divisible by 7.
Print 2 if the number does contain 7 but is not divisible by 7.
Print 3 if the number does contain 7 and is divisible by 7.
*/