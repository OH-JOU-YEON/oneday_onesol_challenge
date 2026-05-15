import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCount = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= testCount; i++) {

            max = 0;

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(st.nextToken());

            int[][] feild = new int[N][N];

            for (int j = 0; j < N; j++) {

                st = new StringTokenizer(br.readLine());
                for (int w = 0; w < N; w++) {
                    feild[j][w] = Integer.parseInt(st.nextToken());
                }
            }

            // 각 집들의 좌표만 따로 빼두자

            List<int[]> houses = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                for (int w = 0; w < N; w++) {
                    if (feild[j][w] == 1) {
                        houses.add(new int[] { j, w });
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                for (int w = 0; w < N; w++) {
                    for (int k = 1; k <= 2 * N; k++) {

                        int houseCount = gethouseCount(j, w, houses, k);

                        if (houseCount * M >= getCost(k)) {
                            if (max < houseCount) {
                                max = houseCount;
                            }
                        }

                        // k 일 때 영역 안의 점 수 세기
                        // 손익계산 > 흑자면 갱신
                    }
                }
            }

            StringBuilder sb = new StringBuilder("#" + i + " " + max);

            System.out.println(sb);

        }
    }

    // 맨해튼 거리를 이용해서 해당 영역에 있는 집의 개수를 세주는 함수를 만들어놓자

    static int gethouseCount(int r, int c, List<int[]> houses, int k) {

        int count = 0;

        for (int[] house : houses) {
            if (Math.abs(house[0] - r) + Math.abs(house[1] - c) < k)
                count++;
        }

        return count;

    }

    // k일때 비용 계산하는 함수도 만들어놓자

    static int getCost(int k) {
        return k * k + (k - 1) * (k - 1);
    }
}
