import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = Integer.parseInt(sc.nextLine().split(" ")[1]);

        String[] strs = sc.nextLine().split(" ");

        for(String str : strs) {
            int y = Integer.parseInt(str);
            if(x > y)
                System.out.print(y + " ");
        }
    }
}