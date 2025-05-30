import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        
        int i = 0;
        int answer = 665;

        while (i < n) {
                answer++;
            if ((answer + "").contains("666"))
                i++;
        }

        System.out.println(answer);
    }
}