import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        int n = Integer.parseInt(s.split(" ")[0]);
        int k = Integer.parseInt(s.split(" ")[1]);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(i+1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!q.isEmpty()) {
            int curIdx = 1;
            while (curIdx++ < k) {
                q.offer(q.poll());
            }

            sb.append(q.poll()).append(", ");
        }

        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);
    }
}