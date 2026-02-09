class Solution {
    public int[] solution(String s) {
        int count = 0;      // 이진 변환 횟수
        int zeroCount = 0;  // 제거한 0 개수
        
        while(!s.equals("1")) {
            int zeros = countZero(s);
            zeroCount += zeros;
            s = s.replace("0", "");
            s = Integer.toBinaryString(s.length());
            count++;
        }
        
        return new int[]{count, zeroCount};
    }
    
    private static int countZero(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') 
                answer++;
        }
        return answer;
    }
}