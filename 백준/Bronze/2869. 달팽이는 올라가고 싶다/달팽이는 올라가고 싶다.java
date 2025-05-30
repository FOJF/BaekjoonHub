import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int upSpeed = sc.nextInt();
        int downSpeed = sc.nextInt();
        int goal = sc.nextInt();

        System.out.println((int)(Math.ceil((double)(goal - downSpeed)/ (upSpeed-downSpeed))));

    }
}