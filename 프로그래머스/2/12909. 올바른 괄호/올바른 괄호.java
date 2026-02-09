import java.util.*; 
class Solution {
    boolean solution(String s) {
        // 풀이: 기본적인 스택 이용 문제 
        // 여는 괄호면 닫힌 괄호 넣어주고 
        // 닫힌 괄호면 pop한 게 같은지 확인하고
        // 나중에 그래서 stack 비었니? 반환해주면 됨 
        
    Deque<Character> stack = new ArrayDeque<>(); 
    
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i); 
          if(c == '(') {
              stack.push(')');
          } else {
             if(stack.isEmpty()) {
                 return false; 
             } else {
                 stack.pop();
                 continue; 
             }
          }
        }
        
        return stack.isEmpty(); 
    }
}