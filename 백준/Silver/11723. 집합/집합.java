import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] s = new int[20];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "add" -> add(Integer.parseInt(s[1]));
                case "remove" -> remove(Integer.parseInt(s[1]));
                case "check" -> {
                    int c = check(Integer.parseInt(s[1]));
                    bw.write(c + "\n");
                }
                case "toggle" -> toggle(Integer.parseInt(s[1]));
                case "all" -> all();
                case "empty" -> empty();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
    static void add(int x) {
        s[x - 1] = x;
    }

    // remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
    static void remove(int x) {
        s[x - 1] = 0;
    }

    // check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
//    static void check(int x) {
//        int hasX = s[x - 1] == x ? 1 : 0;
//
//        System.out.println(hasX);
//    }
//    
    static int check(int x) {
        return s[x - 1] == x ? 1 : 0;
    }

    // toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
    static void toggle(int x) {
        s[x - 1] = s[x - 1] == x ? 0 : x;
    }

    // all: S를 {1, 2, ..., 20} 으로 바꾼다.
    static void all() {
        Arrays.setAll(s, (i) -> (i + 1));
    }

    // empty: S를 공집합으로 바꾼다.
    static void empty() {
        Arrays.fill(s, 0);
    }
}