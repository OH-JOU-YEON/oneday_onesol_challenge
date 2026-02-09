import java.util.*; 
class Solution
{
    public int solution(int []A, int []B)
    {
       // 풀이: 한 배열은 오름차순 정렬, 다른 배열은 내림차순 정렬 하고 
       // 이러면 최댓값 x 최솟값 돼서 합계가 최소 
       
        int sum = 0; 
        Arrays.sort(A); 
        Arrays.sort(B); 
        
        for(int i = 0; i<A.length; i++) {
            sum += A[i] * B[A.length - 1 - i]; 
        }
        
        return sum; 
    }
}