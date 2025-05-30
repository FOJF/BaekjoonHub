import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        sc.close();

        int highestScore = Arrays.stream(scores).max().getAsInt();
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += (double)scores[i];
        }

        System.out.println(sum/n/highestScore*100);
    }
}