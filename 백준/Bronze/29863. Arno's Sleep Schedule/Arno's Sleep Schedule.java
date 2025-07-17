import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        
        a = a >= 20 ? a-24 : a;
        
        br.close();
        System.out.println(b-a);
    }
}