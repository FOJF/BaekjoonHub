import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs;

        while (true) {
            try {

                strs = sc.nextLine().split(" ");
                if (strs.length != 2) break;
                System.out.println(Integer.parseInt(strs[0]) + Integer.parseInt(strs[1]));
            } catch (NumberFormatException | NoSuchElementException e) {
                break;
            }
        }
    }
}