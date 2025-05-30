import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();

        Queue<Integer> intQue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            intQue.add(i);
        }
        
        while (intQue.size()>1) {
            intQue.poll();
            intQue.add(intQue.poll());
        }
        System.out.println(intQue.poll());
        
    }
}