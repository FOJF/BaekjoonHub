class Solution {
    public String solution(String my_string, String letter) {

        while(my_string.contains(letter)) {
            String s = "";
            int idx = my_string.indexOf(letter);
            s += my_string.substring(0,idx);
            s += my_string.substring(idx+1,my_string.length());
            my_string = s;
        }
        return my_string;
    }
}