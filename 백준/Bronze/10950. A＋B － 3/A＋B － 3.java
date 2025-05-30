import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = Integer.parseInt(sc.nextLine());
        for (; i > 0; i--) {
            String[] strs = sc.nextLine().split(" ");
            System.out.println(Integer.parseInt(strs[0]) + Integer.parseInt(strs[1]));
        }
    }
}