import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String[] strs = str.split(" ");
        System.out.println(Integer.parseInt(strs[0])-Integer.parseInt(strs[1]));
    }
}