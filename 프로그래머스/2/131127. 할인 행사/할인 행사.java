import java.util.*; 
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0; 
        
        // 반복문 돌면서 
        // 10일씩 잘라서 검사하고 
        // 맞으면 추가하는 식으로 해야될듯
        // 생각보다 알고리즘이 어렵진 않음 
        
        // 물건 맵 만들기 
        
        Map<String,Integer> wish = new HashMap<>(); 
        
        for(int i = 0; i<want.length; i++) {
            wish.put(want[i],number[i]); 
        }
        
        // 일단 주어진 날 - 10 동안 반복 
        
        for(int i = 0; i<=discount.length - 10; i++) {
            // 검사 메서드가 참을 반환하면 answer++
            int start = i; 
            int end = i + 9; 
            
            if(checkAccess(discount,start,end,wish)) {
                answer++; 
            }
            
        }
        
        return answer; 
        
    }
    
    private static boolean checkAccess(String[] discount, int start, int end,
                                      Map<String,Integer> wish) {
        Map<String,Integer> temp = new HashMap<>(); 
        
        for(int i = start; i<=end; i++) {
            temp.put(discount[i],temp.getOrDefault(discount[i],0) + 1); 
        }
        
        for(String key: temp.keySet()) {
            if(temp.get(key) != wish.get(key)) {
                return false; 
            }
        }
        
        return true; 
    }
    
    
}