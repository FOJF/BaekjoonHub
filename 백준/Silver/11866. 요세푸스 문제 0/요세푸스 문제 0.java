import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        int n = Integer.parseInt(s.split(" ")[0]);
        int k = Integer.parseInt(s.split(" ")[1]);

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<");

        int size = numbers.length;
        int index = -1;

        while (size > 1) {
            int countNotEmpty = 0;

            while (countNotEmpty < k) {
                index = (index + 1) % numbers.length;

                if (numbers[index] != 0) countNotEmpty++;
            }

            int removedNum = pop(numbers, index);
            bw.write(removedNum + ", ");
            size--;
        }

        for (int number : numbers) {
            if (number != 0) {
                bw.write(number + ">");
                break;
            }
        }

        bw.flush();
        bw.close();
    }

    static int pop(int[] targetArr, int index) {
        int val = targetArr[index];
        targetArr[index] = 0;
        return val;
    }
}