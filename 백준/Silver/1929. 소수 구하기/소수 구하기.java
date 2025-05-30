import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        int first = Integer.parseInt(s.split(" ")[0]);
        int last = Integer.parseInt(s.split(" ")[1]);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = first; i <= last; i++) {
            if(isPrime(i))
                bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static boolean isPrime(int n) {
        if (n < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}