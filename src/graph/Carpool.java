package graph;

public class Carpool {
	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 0;
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = 2000001;
			}
		}
		for (int[] node : fares) {
			int place1 = node[0];
			int place2 = node[1];
			int fare = node[2];

			map[place1 - 1][place2 - 1] = fare;
			map[place2 - 1][place1 - 1] = fare;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (map[j][i] + map[i][k] < map[j][k]) {
						map[j][k] = map[j][i] + map[i][k];
					}
				}
			}
		}

		int ab = map[a - 1][b - 1];
		int ba = map[b - 1][a - 1];
		int sa = map[s - 1][a - 1];
		int sb = map[s - 1][b - 1];
		
		int min = Math.min(sa + sb, Math.min(sa + ab, sb + ba));
		
		for(int i = 0; i < n; i++) {
			int posMin = Integer.MAX_VALUE;
			if(i != s-1 && i != a-1 && i != b-1) {
				posMin =map[s - 1] [i] + map[i][a - 1] + map[i][b - 1];
				System.out.println(posMin);
			}
				min = Math.min(min, posMin);
		}
		
		return min;
	}

	public static void main(String args[]) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
				{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };

		Carpool cp = new Carpool();
		System.out.println(cp.solution(n, s, a, b, fares));
	}
}
