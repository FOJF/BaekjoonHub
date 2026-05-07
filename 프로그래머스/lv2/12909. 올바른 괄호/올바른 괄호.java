class Solution {
    boolean solution(String s) {
        int a = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(') a++;
            else a--;
            
            if (a < 0) return false;
        }        

        return a == 0;
    }
}