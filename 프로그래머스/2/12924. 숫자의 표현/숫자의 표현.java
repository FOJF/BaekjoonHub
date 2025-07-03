class Solution {
    public int solution(int n) {
        
        int start = 1;
        int end = 2;
        int answer = 0;
        
        int sum = start + end;
        
        while(start < end) {
            if (sum > n) {
                sum -= start;
                start++;
            } else if (sum == n) {
                answer++;
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        
        return answer+1;
    }
}