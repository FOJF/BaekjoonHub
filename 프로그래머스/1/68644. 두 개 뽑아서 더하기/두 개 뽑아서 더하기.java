import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();
        
        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                hashSet.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[hashSet.size()];
        int answerIdx = 0;
        for(int i : hashSet) {
            answer[answerIdx++] = i;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}