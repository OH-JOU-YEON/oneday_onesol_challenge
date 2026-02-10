class Solution {
    public int solution(int n) {
        // 풀이: 2진수 변환 했을 때 1 개수 반환하는 메서드 작성
        // 반복문 돌리면서 1개수가 같은데 저거보다 큰 수 찾고, 반환 
        int answer = n + 1; 
        int nCount = getOneCount(n); 
        while(true) {
            if(getOneCount(answer) == nCount) 
                break;
            answer++; 
        }
        
       return answer; 
    }
    
    private static int getOneCount(int i) {
        // 주어진 정수를 이진수 문자열로 전환 
        String temp = Integer.toString(i,2);
        // 1의 개수를 센다 
        int answer = 0; 
        for(int j = 0; j<temp.length(); j++) {
            if(temp.charAt(j)=='1')
                answer++; 
        }
        return answer; 
    }
}