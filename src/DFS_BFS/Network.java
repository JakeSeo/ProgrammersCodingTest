package DFS_BFS;

public class Network {
	public static int dfs(int index, int[][] computers, boolean[] visited) {
		if(visited[index]) {
			return 0;
		}
		
		visited[index] =  true;
		for(int j = 0; j < computers[index].length; j++) {
			if(!visited[j] && computers[index][j] == 1) {
				dfs(j, computers, visited);
			}
		}
		
		return 1;
	}
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[computers.length];
		for(int i = 0; i < computers.length; i++) {
			answer += dfs(i, computers, visited);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};
		
		System.out.println(solution(n, computers));
	}

}
