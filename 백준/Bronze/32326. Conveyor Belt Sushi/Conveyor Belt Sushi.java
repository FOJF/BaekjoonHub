import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        answer += Integer.parseInt(br.readLine())*3;
        answer += Integer.parseInt(br.readLine())*4;
        answer += Integer.parseInt(br.readLine())*5;
        br.close();
        
        System.out.println(answer);
    }
}