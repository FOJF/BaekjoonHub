class Solution {
    public int solution(int[][] triangle) {
        int[] t = triangle[triangle.length-1];
        
        for(int i = triangle.length-2; i >= 0 ; i--) {
            for(int j = 0; j <= i; j++) {
                t[j] = triangle[i][j] + Math.max(t[j], t[j+1]);
            }
        }
        
        return t[0];
    }
}