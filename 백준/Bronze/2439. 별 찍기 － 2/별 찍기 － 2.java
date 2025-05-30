import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = (new Scanner(System.in).nextInt());

        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= n; j++) {
                if(i <= j) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}