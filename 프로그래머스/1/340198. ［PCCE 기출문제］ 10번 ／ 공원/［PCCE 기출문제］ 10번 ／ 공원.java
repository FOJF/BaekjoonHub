class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        for(int size : mats) {
            if(checkAllIsPossible(park, size))
                answer = Math.max(answer, size);
        }
        
        return answer;
    }
    
    public boolean checkAllIsPossible(String[][] park, int size) {
        for(int i = 0; i <= park.length - size; i++) {
            for(int j = 0; j <= park[i].length - size; j++) {
                boolean isPossible = checkIsPossible(park, size, i, j);
                if(isPossible) return true;
            }
        }
        return false;
    }

    public boolean checkIsPossible(String[][] park, int size, int startI, int startJ) {
        for(int i = startI; i < startI+size; i++) {
            for(int j = startJ; j < startJ+size; j++) {
                if(!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }

        return true;
    }
}