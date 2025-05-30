import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = Integer.parseInt(br.readLine());

        for (; i > 0; i--) {
            String oxs = br.readLine();
            int score = 0;
            int point = 1;

            for (int j = 0; j < oxs.length(); j++) {
                if (oxs.charAt(j) == 'O')
                    score += point++;
                else
                    point = 1;
            }
            System.out.println(score);
        }
        br.close();
    }
}