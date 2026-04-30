/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static boolean[] visited = new boolean[100];

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        for(int i = 0; i < 10; i++) { 

            StringTokenizer st = new StringTokenizer(br.readLine()); 

            int testCount = Integer.parseInt(st.nextToken()); 

            int routeCount = Integer.parseInt(st.nextToken()); 

            List<Integer>[] graph = new ArrayList[100]; 

            for (int k = 0; k < 100; k++) {
                graph[k] = new ArrayList<>();
}
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<routeCount; j++) {
                 
                int a = Integer.parseInt(st.nextToken());  
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
        }

        StringBuilder sb = new StringBuilder("#" + testCount + " "); 

        Arrays.fill(visited, false);
        if(dfs(graph,0) ) {
            sb.append(1); 
        }else 
            sb.append(0); 

        System.out.println(sb); 
    }
}

    

    static boolean dfs(List<Integer>[] graph, int cur) {

     
    for (int next : graph[cur]) {   // cur에서 갈 수 있는 노드들 순회
        if (next == 99) return true;
        if (!visited[next]) {
            visited[next] = true;
            if (dfs(graph, next)) return true;
        }
    }
    return false;
}


}
