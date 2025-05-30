import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int k = Integer.parseInt(s.split(" ")[0]);
        int n = Integer.parseInt(s.split(" ")[1]);

        int[] wires = new int[k];
        long max = 0;

        for (int i = 0; i < k; i++) {
            wires[i] = Integer.parseInt(br.readLine());
            if (wires[i] > max) max = wires[i]; // 최대 길이 갱신
        }

        br.close();

        long left = 1;
        long right = max;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int wire : wires) {
                count += wire / mid;
            }

            if (count >= n) {
                answer = mid; // 가능한 경우, 더 긴 길이도 시도
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}