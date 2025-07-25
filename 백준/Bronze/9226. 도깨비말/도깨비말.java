import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String input = null;
        while(!(input = br.readLine()).equals("#")) {
            int vowelIdx = 0;
            for(int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u')
                    {vowelIdx = i; break;}
            }
            
            if (vowelIdx == 0) sb.append(input).append("ay\n");
            else sb.append(input.substring(vowelIdx)).append(input.substring(0,vowelIdx)).append("ay\n");
        }
        
        br.close();
        
        System.out.println(sb);
    }
}