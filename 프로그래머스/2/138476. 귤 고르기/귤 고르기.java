import java.util.*;
import java.util.stream.*; 
class Solution {
    public int solution(int k, int[] tangerine) {
        // 풀이: 이것도 그리디
        // 일단 정렬하고 
        // 각 귤 크기별 개수를 세서 저장한 다음에 
        // k개 가 될 때까지 담으면 됨 
        // 짝 별로 저장해야 되니까 맵 쓰면 되겠네 
        int answer = 0;
        Map<Integer,Integer> eachCount = new HashMap<>(); 
        
        // 맵에 빈도수 저장 
        for(int i = 0; i<tangerine.length; i++) {
            eachCount.put(tangerine[i], eachCount.getOrDefault(tangerine[i],0) + 1); 
        }
        
        // 빈도수 내림차순 정렬 
        Map<Integer,Integer> sorted = eachCount.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (e1, e2) -> e1,
            LinkedHashMap::new));
        
        // 맵 키 만큼 순회하면서 정렬된 값을 더해 나가고, 그 값이 
        // 요구되는 귤 값보다 커지면 멈추고 answer 반환 
        int sum = 0; 
        for(int s: sorted.keySet()) {
            
            sum += sorted.get(s); 
            answer++; 
            
            if(sum >= k) {
                return answer; 
            }
            
        }
        
        return answer; 
    }
}