package greedy;

import java.util.PriorityQueue;

//크루스칼 알고리즘

public class ConnectingIslands {
	static class Bridge implements Comparable<Bridge> {
		int from;
		int to;
		int cost;

		public Bridge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bridge b) {
			return this.cost - b.cost;
		}

		@Override
		public String toString() {
			return from + " " + to + " " + cost;
		}
	}

	public static int find(int n, int[] parent) {
		if (parent[n] == n)
			return n;
		return parent[n] = find(parent[n], parent);
	}

	public static void union(int a, int b, int[] parent) {
		int rootA = find(a, parent);
		int rootB = find(b, parent);

		if (rootA != rootB)
			parent[rootB] = rootA;
	}

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		PriorityQueue<Bridge> bridgeQ = new PriorityQueue<>();
		int[] parent = new int[n];

		for (int[] b : costs) {
			Bridge bridge = new Bridge(b[0], b[1], b[2]);
			bridgeQ.offer(bridge);
		}

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		while (!bridgeQ.isEmpty()) {
			Bridge b = bridgeQ.poll();

			if (find(b.from, parent) == find(b.to, parent))
				continue;
			else {
				union(b.from, b.to, parent);
				answer += b.cost;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 2, 3, 1 } };

		System.out.println(solution(n, costs));
	}

}
