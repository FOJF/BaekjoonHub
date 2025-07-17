import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            answer += switch(br.readLine().charAt(0)) {
                    case 'P' -> 1500;
                    case 'M' -> 6000;
                    case 'S' -> 15500;
                    case 'C' -> 40000;
                    case 'T' -> 75000;
                    case 'H' -> 125000;
                    default -> 0;
            };
        }
        
        br.close();
        System.out.println(answer);
    }
}

/*
Poblano	1500
Mirasol	6000
Serrano	15500
Cayenne	40000
Thai	75000
Habanero	125000
*/