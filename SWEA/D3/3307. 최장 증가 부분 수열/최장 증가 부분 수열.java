import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCount = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= testCount; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            StringBuilder sb = new StringBuilder("#" + i + " "); 

            sb.append(dp(arr));
            
            System.out.println(sb); 
        }
    }

    public static int dp(int[] arr) {

        int[] dpArr = new int[arr.length];

       Arrays.fill(dpArr, 1);

      

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dpArr[i] = Math.max(dpArr[i], dpArr[j] + 1); 
                }
            }
        }

        int max = 0;
for (int val : dpArr) {
    max = Math.max(max, val);
}
return max;

     

    }
}
