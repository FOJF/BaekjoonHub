import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Map.Entry<Integer, Integer>> entryQueue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int size = Integer.parseInt(s.split(" ")[0]);
            int documentNo = Integer.parseInt(s.split(" ")[1]);

            s = br.readLine();
            String[] priorities = s.split(" ");
            for (int j = 0; j < size; j++) {
                // 큐 초기화 entry[생성시 순서(key), 중요도]
                entryQueue.add(Map.entry(j, Integer.parseInt(priorities[j])));
            }

            int printedDoc = 0;
            while (!entryQueue.isEmpty()) {
                Map.Entry<Integer, Integer> firstEntry = entryQueue.poll(); // 처음 대기 문서

                if(hasHigherPriority(entryQueue, firstEntry)) {// 처음 대기 문서 뒤에 더 큰 중요도를 가진 문서가 있으면 뒤로 옮기기
                    entryQueue.add(firstEntry);
                    continue;
                }
                printedDoc++;
                if(firstEntry.getKey() == documentNo)
                    System.out.println(printedDoc);
            }

        }
        br.close();
    }

    static boolean hasHigherPriority(Queue<Map.Entry<Integer, Integer>> targetQueue, Map.Entry<Integer, Integer> entry) {
        for (Map.Entry<Integer, Integer> e : targetQueue) {
            if (entry.getValue() < e.getValue()) return true;
        }
        return false;
    }
}