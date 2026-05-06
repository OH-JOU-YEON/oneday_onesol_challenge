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
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= testCount; i++) {
            int moleCount = Integer.parseInt(br.readLine().trim());
            int[][] moles = new int[moleCount][2];

            for (int j = 0; j < moleCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                moles[j][0] = Integer.parseInt(st.nextToken()); // x
                moles[j][1] = Integer.parseInt(st.nextToken()); // y
            }

            int maxArea2 = 0;

            // 각 점을 직각 꼭짓점으로 시도
            for (int j = 0; j < moleCount; j++) {
                int cx = moles[j][0];
                int cy = moles[j][1];

                int maxHorizontal = 0; // 같은 y, x거리 최대
                int maxVertical = 0;   // 같은 x, y거리 최대

                for (int k = 0; k < moleCount; k++) {
                    if (k == j) continue;
                    if (moles[k][1] == cy) // 같은 y
                        maxHorizontal = Math.max(maxHorizontal, Math.abs(moles[k][0] - cx));
                    if (moles[k][0] == cx) // 같은 x
                        maxVertical = Math.max(maxVertical, Math.abs(moles[k][1] - cy));
                }

                if (maxHorizontal > 0 && maxVertical > 0)
                    maxArea2 = Math.max(maxArea2, maxHorizontal * maxVertical);
            }

            System.out.println(maxArea2);
        }
    }
}