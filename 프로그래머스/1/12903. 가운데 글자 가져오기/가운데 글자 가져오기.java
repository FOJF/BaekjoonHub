class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        boolean isEvenLength = length%2 == 0;
        int startIdx = isEvenLength ? length/2-1 : length/2;
        int endIdx = isEvenLength ? startIdx+2:startIdx+1;
        answer = s.substring(startIdx, endIdx);
        return answer;
    }
}