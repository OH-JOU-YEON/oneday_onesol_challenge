class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
    int answer = 0;
    
    // 1. 모든 직원에 대해 반복 
    for(int i = 0; i < schedules.length; i++) {
        GoToWorkRange goToWorkRange = new GoToWorkRange(schedules[i]); 
        boolean allOnTime = true;  // 플래그 추가
        
        // 일주일동안 반복하며 검증하기 
        for(int w = 0; w < 7; w++) {
            int dayOfWeek = ((startday - 1 + w) % 7) + 1;  // 1-7 범위
            
            if(dayOfWeek == 6 || dayOfWeek == 7) {  // 토(6), 일(7) 건너뛰기
                continue; 
            }
            
            // 평일인데 늦으면 플래그 false
            if(!checkRange(goToWorkRange.goToWorkTime, goToWorkRange.workTimeEnd, timelogs[i][w])) {
                allOnTime = false;
                break;  // 하루라도 늦으면 더 볼 필요 없음
            }
        }
        
        // 평일 5일 모두 정상이면 카운트
        if(allOnTime) {
            answer++;
        }
    }
    
    return answer;
}
    
   private static boolean checkRange(int goToWorkTime, int workTimeEnd, int actualTime) {
    return actualTime <= workTimeEnd;  // 출근 인정 시각 이하면 OK (일찍 와도 됨)
}
    
   
    
    private static class GoToWorkRange {
        private final int goToWorkTime; 
        private final int workTimeEnd; 
        
       private GoToWorkRange(int goToWorkTime) {
            
            this.goToWorkTime = goToWorkTime; 
            this.workTimeEnd = getEndTime(goToWorkTime); 
        } 
    }
    
    private static int getEndTime(int goToWorkTime) {
        int minute = goToWorkTime % 100; 
        int hour = goToWorkTime / 100; 
        
        int endMinute = minute + 10; 
        
        if(endMinute >= 60) {
            endMinute = endMinute - 60; 
            hour = hour + 1; 
        }
        
        return (hour * 100) + endMinute; 
    }
}