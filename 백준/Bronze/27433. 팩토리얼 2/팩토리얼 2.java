import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long answer = 1;
        
        for (int i = 1; i <= n; i++) {
            answer *= i;
        }
        
        br.close();
        System.out.println(answer);
    }
}