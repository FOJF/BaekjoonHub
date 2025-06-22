import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.readLine().charAt(0) == '0' ? "YONSEI" : "Leading the Way to the Future");
        br.close();
    }
}