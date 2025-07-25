import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chicken = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        
        int coke = Integer.parseInt(st.nextToken());
        int beer = Integer.parseInt(st.nextToken());
        
        int max = Math.min((coke/2 + beer), chicken);
        
        System.out.println(max);
    }
}