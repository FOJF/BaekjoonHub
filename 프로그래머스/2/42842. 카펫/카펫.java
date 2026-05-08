class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        
        for (int i = 3; i < sum; i++) {
            int j = sum/i;
        
            if (i*j != sum || j < 3 || (i-2)*(j-2) != yellow) continue;
            
            return new int[]{Math.max(i,j), Math.min(i,j)};
        }
        
        return null;
    }
}