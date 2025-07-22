import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = (long)Arrays.stream(times).max().getAsInt() * n;

        long min = 1;
        long max = answer;

        while(min <= max) {
            long mid = (max + min) / 2;

            long passed = Arrays.stream(times).mapToLong(t -> mid/t).sum();
            
            System.out.println(passed + " " + mid);
            
            if (passed >= n) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1; 
            }
        }

        return answer;
    }
}