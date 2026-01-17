class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        
        var stringN = n.toString(); 
        
        for(str in stringN) {
            answer += str.toString().toInt(); 
        }

        return answer
    }
}