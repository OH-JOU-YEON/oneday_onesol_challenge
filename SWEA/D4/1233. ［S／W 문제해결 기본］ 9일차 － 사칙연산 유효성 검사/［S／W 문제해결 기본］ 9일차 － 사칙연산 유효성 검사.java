import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int nodeCount = Integer.parseInt(st.nextToken());

            char[] val = new char[nodeCount + 1];
            int[] left = new int[nodeCount + 1];
            int[] right = new int[nodeCount + 1];

            for(int j = 0; j < nodeCount; j++) {
                st = new StringTokenizer(br.readLine()); 
                int number = Integer.parseInt(st.nextToken()); 
                val[number] = st.nextToken().charAt(0);
                left[number] = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
right[number] = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0; 
            }

            int answer = 1; 

            for(int j = 1; j < nodeCount; j++) {

                if(left[j]==0 && right[j] == 0 && 
                !Character.isDigit(val[j]))
                    answer = 0; 
                
                if(left[j]!=0 && right[j]!=0 && Character.isDigit(val[j])) 
                    answer = 0; 
            }

            StringBuilder sb = new StringBuilder("#" + i + " "); 
            sb.append(answer); 

            System.out.println(sb); 
        }

    }
}
