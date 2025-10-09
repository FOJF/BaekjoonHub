import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<int[]> a = new Stack<>();
        
        for(int i = 0; i < numbers.length; i++) {
            while(!a.isEmpty() && a.peek()[1] < numbers[i]) {
                answer[a.pop()[0]] = numbers[i];
            }
            a.push(new int[]{i, numbers[i]});
        }
        
        while(!a.isEmpty()) {
            answer[a.pop()[0]] = -1;
        }
        
        return answer;
    }
}