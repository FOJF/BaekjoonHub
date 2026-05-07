import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i < completion.length; i++) {
            if (participant[i].compareTo(completion[i]) != 0) {
                return participant[i];
            }
        }
        return participant[participant.length-1];
    }
}