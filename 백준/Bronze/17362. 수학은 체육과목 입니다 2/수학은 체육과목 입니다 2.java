import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        br.close();
        
        int answer = n % 8;
        if (answer == 0) answer = 2;
        if (answer == 6) answer = 4;
        if (answer == 7) answer = 3;
        
        System.out.println(answer);
    }
}