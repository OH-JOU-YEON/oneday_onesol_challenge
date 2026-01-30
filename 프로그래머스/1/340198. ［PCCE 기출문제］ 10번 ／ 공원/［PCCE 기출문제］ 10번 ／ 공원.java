import java.util.*;
import java.util.stream.Collectors; 

class Solution {
    public int solution(int[] mats, String[][] park) {
        int blank = 0; 
        
        // 1. 모든 시작점 탐색
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length; j++) {
                
                // 2. 각 시작점에서 크기를 1부터 늘려가며 확인
                for(int size = 1; i + size <= park.length && j + size <= park[i].length; size++) {
                    if(checkSquare(size, i, j, park)) {
                        blank = Math.max(blank, size);
                    } else {
                        break; // 이 크기가 안 되면 더 큰 것도 불가능
                    }
                }
            }
        }
        
        // 3. 들어갈 수 있는 가장 큰 돗자리 찾기
        final int maxBlank = blank;
        return Arrays.stream(mats)
            .filter(mat -> mat <= maxBlank)
            .max()
            .orElse(-1);  // 못 찾으면 -1
    }
    
    private static boolean checkSquare(int size, int startRow, int startCol, String[][] park) {
        for(int i = startRow; i < startRow + size; i++) {
            for(int j = startCol; j < startCol + size; j++) {
                if(!park[i][j].equals("-1")) {  // "-1" → "-"
                    return false; 
                }
            }
        }
        return true; 
    }
}