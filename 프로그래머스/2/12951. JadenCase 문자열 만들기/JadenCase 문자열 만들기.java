class Solution {
    public String solution(String s) {
        
        // 주어진 문자열에 대해 반복문 돌면서 
        // 공백이면 공백임을 알리는 값 true로 만들고 continue
        // 공백이 아닌데 공백임을 알리는 값이 true면 값 false 로 만들고 대문자 
        // 공백이 아닌데 값도 false면 소문자 
       StringBuilder answer = new StringBuilder(); 
       boolean beforeBlank = true; 
       for(int i = 0; i<s.length(); i++) {
           if(s.charAt(i) == ' ') {
               beforeBlank = true; 
               answer.append(s.charAt(i)); 
               continue;
           } 
           
           if(beforeBlank == true ) {
               beforeBlank = false; 
               answer.append(Character.toUpperCase(s.charAt(i))); 
           } else {
               answer.append(Character.toLowerCase(s.charAt(i))); 
           }
       }
        
        return answer.toString(); 
    }
}