import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = (int)Arrays.stream(br.readLine().split(" ")).filter(s -> s.charAt(0) != '-' && s.charAt(0) != '0').count();
        br.close();
        
        System.out.println(answer);
    }
}