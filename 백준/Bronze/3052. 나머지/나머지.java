import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] counter = new int[10];
        Arrays.fill(counter, -1);

        for (int i = 0; i < 10; i++) {
            int remainder = sc.nextInt() % 42;
            if (!Arrays.asList(counter).contains(remainder))
                counter[i] = remainder;
        }

        counter = Arrays.stream(counter).distinct().toArray(); // 배열의 중복 값 제거
        System.out.println(counter.length);
    }
}