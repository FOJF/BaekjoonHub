class Solution {
    public String solution(String s) {
        int length = s.length();
        boolean isLengthEven = length%2 == 0;
        
        int startIdx = length/2;//isLengthEven ? length/2-1 : length/2;
        if(isLengthEven) startIdx--;
        int endIdx = startIdx+1;//isLengthEven ? startIdx+2 : startIdx+1;
        if(isLengthEven) endIdx++;
        
        return s.substring(startIdx, endIdx);
    }
}