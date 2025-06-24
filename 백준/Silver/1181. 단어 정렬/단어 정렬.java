/*
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Set<String> inputs = new TreeSet<>((s1, s2) -> {
           if (s1.length() == s2.length()) return s1.compareTo(s2);
            
           return s1.length() - s2.length();
        });
        
        for (int i = 0; i < n; i++) {
            inputs.add(br.readLine());
        }
        
        br.close();
        
        StringBuilder sb = new StringBuilder();
        for (String s : inputs) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}