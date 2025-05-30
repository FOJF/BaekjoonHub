import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int indexOfMax = -1;

        for (int i = 0; i < 9; i++) {
            int n = sc.nextInt();
            if (max < n) {
                max = n;
                indexOfMax = i;
            }
        }

        System.out.println(max);
        System.out.println(indexOfMax + 1);
    }
}