class Solution {
    public int solution(int n) {
       // n보다 작은 모든 숫자에 대해 반복하면서 
        // 그 숫자 + 1 한 숫자 더해 나가면서 n이 되면 answer++
        // 아니면 continue 
        
        int answer = 1; 
        
        
        for(int i = 1; i<=n; i++) {
            int sum = i; 
            for(int j = i + 1; j<=n; j++) {
                sum += j;
                if(sum == n) {
                    answer++;
                    break;
                } else if(sum > n) {
                   break; 
                } 
            }
        }
        
        return answer; 
    }
}