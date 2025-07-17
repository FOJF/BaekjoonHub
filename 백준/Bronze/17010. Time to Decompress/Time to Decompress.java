import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int l = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < l; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            for (int j = 0; j < n; j++) {
                sb.append(input[1]);
            }
            sb.append("\n");
        }
        
        br.close();
        System.out.println(sb);
    }
}