import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()) - 1;
        String numbers = sc.nextLine();

        int sum = 0;

        for (; n >= 0; n--) {
            sum += Integer.parseInt(String.valueOf(numbers.charAt(n)));
            numbers = numbers.substring(0, n);
        }
        System.out.println(sum);
    }
}