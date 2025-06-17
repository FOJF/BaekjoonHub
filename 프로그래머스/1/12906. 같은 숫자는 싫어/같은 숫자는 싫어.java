import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {     
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        for (int num : arr) {
            if (stack.peek() == num) continue;
            
            stack.push(num);
        }
        
        return stack;
    }
}