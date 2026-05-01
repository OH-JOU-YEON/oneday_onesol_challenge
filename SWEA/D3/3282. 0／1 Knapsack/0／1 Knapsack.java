/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int testCount = Integer.parseInt(st.nextToken()); 

        for(int i = 1; i<= testCount; i++) {

            st = new StringTokenizer(br.readLine()); 

            int N = Integer.parseInt(st.nextToken()); 
            int K = Integer.parseInt(st.nextToken()); 

            int max = 0; 

            int[][] dp = new int[N+1][K+1]; 

            int[][] vc = new int[N+1][2]; 

            for(int t = 0; t < N; t++) {
                st = new StringTokenizer(br.readLine()); 
                int a = Integer.parseInt(st.nextToken()); 
                int b = Integer.parseInt(st.nextToken()); 

                vc[t][0] = a; 
                vc[t][1] = b; 
            }

          for (int w = 0; w <= K; w++) {
    if (w >= vc[0][0]) dp[0][w] = vc[0][1];
    else dp[0][w] = 0;
}

            for(int j = 1; j<=N; j++) {
                for(int w = 0; w<=K; w++) {

                    
                    if (w >= vc[j][0]) {
    dp[j][w] = Math.max(dp[j-1][w], dp[j-1][w - vc[j][0]] + vc[j][1]);
} else {
    dp[j][w] = dp[j-1][w];  // 못 넣으면 이전 값 그대로
}

                    if(max < dp[j][w]) 
                        max = dp[j][w]; 
                }

            }

            StringBuilder sb = new StringBuilder("#" + i + " " );

            sb.append(max); 

            System.out.println(sb); 

            
        }
        
    }
}
