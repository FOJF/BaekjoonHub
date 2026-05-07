import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> a = new Stack<>();
        
        for(int i = 0; i < numbers.length; i++) {
            while(!a.isEmpty() && numbers[a.peek()] < numbers[i]) {
                answer[a.pop()] = numbers[i];
            }
            a.push(i);
        }
        
        while(!a.isEmpty()) {
            answer[a.pop()] = -1;
        }
        
        return answer;
    }
}