import java.util.*; 
import java.util.stream.Collectors;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 이거 그냥 함수형 프로그래밍으로 띵가면 될듯 
        
        final int extNumber = getIndex(ext); 
        final int sortNumber = getIndex(sort_by); 
        
        
       int[][] dataList = Arrays.stream(data)
           .filter(row -> row[extNumber] < val_ext)
           .sorted(Comparator.comparingInt(row -> row[sortNumber]))
           .toArray(int[][]::new);
        
        
        return dataList; 
        
    
}
private int getIndex(String key) {
        switch(key) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: return 0;
        }
    }


}