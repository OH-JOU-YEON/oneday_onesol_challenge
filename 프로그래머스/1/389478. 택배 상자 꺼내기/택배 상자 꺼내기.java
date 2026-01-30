class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;  // num 포함해서 시작
        
        int[][] boxes = createBox(n, w); 
        
        // num이 있는 위치 찾기
        int col = 0; 
        int row = 0; 
        
        for(int i = 0; i < boxes.length; i++) {
            for(int j = 0; j < boxes[0].length; j++) {
                if(boxes[i][j] == num) {
                    row = i;
                    col = j; 
                }
            }
        }
        
        // num 위부터 세기
        while(true) {
            row++; 
            if(row >= boxes.length || boxes[row][col] == 0) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
    
    private static int[][] createBox(int n, int w) {
        int totalBoxLine = (n + w - 1) / w;  // 올림
        int[][] answer = new int[totalBoxLine][w]; 
        
        int currentNum = 1;
        
        for(int i = 0; i < totalBoxLine; i++) {
            if(i % 2 == 0) {  // 짝수 층: 왼→오
                for(int j = 0; j < w; j++) {
                    if(currentNum <= n) {
                        answer[i][j] = currentNum++;
                    }
                }
            } else {  // 홀수 층: 오→왼
                for(int j = w - 1; j >= 0; j--) {
                    if(currentNum <= n) {
                        answer[i][j] = currentNum++;
                    }
                }
            }
        }
        
        return answer; 
    }
}