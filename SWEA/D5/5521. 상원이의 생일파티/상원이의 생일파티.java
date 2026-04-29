import java.io.*;
import java.util.*; 

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{

		// 전체 의사 코드 
		 // 1. n, m 입력
    	 // 2. 그래프 초기화
    	 // 3. m번 관계 입력
    	 // 4. BFS 돌리기 (큐, dist 배열)
    	 // 5. dist 1~2인 것 카운트
    	 // 6. #tc 정답 출력

		// 테스트 케이스의 수를 입력받는다. 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); 

		// 테스트 케이스 수 만큼 반복 
		for (int i = 1; i <= t; i++) { 
		 StringBuilder answer = new StringBuilder("#" + i + " "); 

		 StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()); 
			
			// 관계를 표시할 인접 리스트 선언 
		List<List<Integer>> graph = new ArrayList<>();
		for (int k = 0; k <= n; k++) graph.add(new ArrayList<>());
		
		

		for(int j = 0; j<m; j++) { 
				// 각 테스트 케이스의 첫번째, 두번째 글자를 입력받는다. 
			st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 

			// 그래프에 관계를 집어넣는다. 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int invited = bfs(graph,n); 

		answer.append(invited); 

		System.out.println(answer); 
		 
		}

		
		}

		public static int bfs(List<List<Integer>> graph, int n) { 

			int[] dist = new int[n+1]; 
			Arrays.fill(dist, -1);

			ArrayDeque<Integer> queue = new ArrayDeque<>(); 
			queue.offer(1); 
			dist[1] = 0; 

			while(!queue.isEmpty()) {
				int cur = queue.poll(); 

				for(int next: graph.get(cur)) {
					if(dist[next] != -1) continue; 

					dist[next] = dist[cur] + 1;
					queue.offer(next); 
				}

			}

			int cnt = 0; 

			for(int d: dist) {
				if((d==1)||(d==2)) cnt++; 
			}

			return cnt; 
		}
	}
