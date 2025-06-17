import java.util.*;

public class Solution {
    public int[] solution(int []arr) {     
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        for (int num : arr) {
            if (stack.peek() == num) continue;
            
            stack.push(num);
        }

        int size = stack.size();
        int[] answer = new int[size];
    
        for (int i = size-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
    
        return answer;
    }
}