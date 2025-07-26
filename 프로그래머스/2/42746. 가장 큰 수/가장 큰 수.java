import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<Integer> nums = new ArrayList<>();
        
        Arrays.stream(numbers).forEach(n -> nums.add(n));
        
        nums.sort((i1, i2) -> {
            Long strcat1 = Long.parseLong(i1+""+i2);
            Long strcat2 = Long.parseLong(i2+""+i1);
            return strcat2.compareTo(strcat1);
        });
        
        StringBuilder sb = new StringBuilder();
        
        if (nums.get(0) == 0) return "0";
        
        nums.stream().forEach(n -> sb.append(n));
        
        return sb.toString();
    }
}