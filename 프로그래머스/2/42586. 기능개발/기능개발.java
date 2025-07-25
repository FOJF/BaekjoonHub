import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = progresses.length-1; i >= 0; i--) {
            int day = (100-progresses[i])/speeds[i];
            if ((100-progresses[i])%speeds[i] != 0) day++;
            stack.push(day);
        }
        
        System.out.println(stack);
        
        List<Integer> answer = new ArrayList<>();
        
        while(!stack.isEmpty()) {
            int release = 1;
            int firstProgReleaseDay = stack.pop();
            
            while(!stack.isEmpty() && stack.peek() <= firstProgReleaseDay) {
                stack.pop();
                release++;
            }
            
            answer.add(release);
        }
        
        
        
        return answer;
    }
}