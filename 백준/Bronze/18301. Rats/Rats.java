import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        
        int a = (Integer.parseInt(st.nextToken()) + 1) * (Integer.parseInt(st.nextToken()) + 1) / (Integer.parseInt(st.nextToken()) + 1) - 1;
        
        System.out.println(a);
    }
}