import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] stack;
    static int lastIndex = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] answerStack = new int[n];
        stack = new int[n];

        for (int i = 0; i < n; i++) {
            answerStack[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        StringBuilder sb = new StringBuilder();
        int nextNum = 1;

        for(int answer : answerStack) {
            while(nextNum <= answer) {
                push(nextNum++);
                sb.append("+\n");
            }

            int poppedNum = pop();
            sb.append("-\n");
            if(poppedNum != answer) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb);
    }

    static void push(int number) {
        if (lastIndex > stack.length) return;
        stack[++lastIndex] = number;
    }

    static int pop() {
        int val = stack[lastIndex];
        stack[lastIndex--] = 0;
        return val;
    }
}