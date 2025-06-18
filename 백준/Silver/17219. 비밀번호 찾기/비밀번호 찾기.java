import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        HashMap<String, String> passwords = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] sitePW = br.readLine().split(" ");
            passwords.put(sitePW[0], sitePW[1]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(passwords.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}