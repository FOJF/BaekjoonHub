import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        
        List<Integer> list = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            list.add(list.size()-Integer.parseInt(st.nextToken()), i);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int num : list) {
            sb.append(num).append(" ");
        }
        
        System.out.println(sb);
    }
}