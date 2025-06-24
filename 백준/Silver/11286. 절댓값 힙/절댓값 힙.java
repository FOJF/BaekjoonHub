import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) return a-b;
            return Math.abs(a) - Math.abs(b);
        });
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            
            if (input == 0) {
                if (pq.isEmpty()) sb.append("0\n");
                else sb.append(pq.poll()).append("\n");
            } else {
                pq.add(input);
            }
        }
        
        br.close();
        System.out.println(sb);
    }
}