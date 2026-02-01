import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
       
        Map<String, List<Integer>> giveGift = new HashMap<>(); 
        Map<String, List<Integer>> getGift = new HashMap<>(); 
        Map<String, Integer> giftSize = new HashMap<>(); 
        Map<String, Integer> giftFactor = new HashMap<>(); 
        
        // 0. 초기화 - 친구 수만큼 0으로 채우기
        for (String key : friends) {  //  friedns → friends
            List<Integer> giveList = new ArrayList<>();
            List<Integer> getList = new ArrayList<>();
            for(int i = 0; i < friends.length; i++) {
                giveList.add(0);
                getList.add(0);
            }
            giveGift.put(key, giveList);
            getGift.put(key, getList); 
            giftSize.put(key, 0); 
            giftFactor.put(key, 0); 
        }
        
        // 1. 선물 기록 업데이트
        for(String names : gifts) {
            String[] giveAndGet = names.split(" "); 
            int giveIndex = getIndex(giveAndGet[0], friends); 
            int takeIndex = getIndex(giveAndGet[1], friends); 
            
            // 리스트 직접 업데이트
            List<Integer> giveList = giveGift.get(giveAndGet[0]);
            giveList.set(takeIndex, giveList.get(takeIndex) + 1);
            
            List<Integer> getList = getGift.get(giveAndGet[1]);
            getList.set(giveIndex, getList.get(giveIndex) + 1);
        }
        
        // 2. 선물 지수 구하기 
        for(String key : giveGift.keySet()) {
            int giveSum = giveGift.get(key).stream()
                .mapToInt(Integer::intValue).sum();
            int getSum = getGift.get(key).stream()
                .mapToInt(Integer::intValue).sum();
            
            giftFactor.put(key, giveSum - getSum); 
        } 
        
        // 3. 이중 반복문으로 다음 달 선물 개수 구하기
        for(int i = 0; i < friends.length; i++) {
            for(int j = i+1; j < friends.length; j++) { 
                
                int iToJ = giveGift.get(friends[i]).get(j);
                int jToI = getGift.get(friends[i]).get(j);
                
                // i가 j보다 많이 줬으면 i가 받음
                if(iToJ > jToI) {
                    giftSize.merge(friends[i], 1, Integer::sum);  
                } 
                // 같으면 선물 지수 비교
                else if(iToJ == jToI) { 
                    if(giftFactor.get(friends[i]) > giftFactor.get(friends[j])) {
                        giftSize.merge(friends[i], 1, Integer::sum);
                    } else if(giftFactor.get(friends[i]) < giftFactor.get(friends[j])) {
                        giftSize.merge(friends[j], 1, Integer::sum);
                    }
                } 
                // j가 i보다 많이 줬으면 j가 받음
                else {
                    giftSize.merge(friends[j], 1, Integer::sum);  
                }
            }
        }
        
        return giftSize.values().stream()
            .max(Integer::compareTo)
            .orElse(0); 
    }
    
    private static int getIndex(String name, String[] friends) {
        for(int i = 0; i < friends.length; i++) {
            if(friends[i].equals(name)) {  
                return i; 
            }
        }
        return -1; 
    }
}