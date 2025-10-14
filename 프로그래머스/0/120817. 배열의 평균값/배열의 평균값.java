class Solution {
    public double solution(int[] numbers) {
        
        double sum = 0;
        int length = numbers.length;
        for(int i=0; i<numbers.length; i++)
           sum += numbers[i];
        
        
       return sum / length;
       
    }
}