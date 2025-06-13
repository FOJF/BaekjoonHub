import java.util.*;

class Solution {
    public TreeSet<Integer> solution(int[] numbers) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        
        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                treeSet.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[treeSet.size()];
        int answerIdx = 0;
        for(int i : treeSet) {
            answer[answerIdx++] = i;
        }
        
        
        return treeSet;
    }
}