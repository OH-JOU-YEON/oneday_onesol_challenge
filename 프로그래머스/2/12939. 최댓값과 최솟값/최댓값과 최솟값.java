import java.util.*;
class Solution {
    public String solution(String s) {
        
        // 풀이랄 것도 없고 그냥 정렬해서 맨 앞 맨 뒤 반환 
        String[] numbers = s.split(" ");
        
        Arrays.sort(numbers, (a,b) -> Integer.parseInt(a) - Integer.parseInt(b));
        return numbers[0] + " " +  numbers[numbers.length - 1];
    }
}