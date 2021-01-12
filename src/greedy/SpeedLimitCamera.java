package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class SpeedLimitCamera {
	static class Route implements Comparable<Route> {
		private int start;
		private int end;
		private int length;
		
		public Route() {}
		public Route(int start, int end, int length)
		{
			setStart(start);
			setEnd(end);
			setLength(length);
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}
		@Override
		public int compareTo(Route r) {
			return this.end - r.getEnd();
		}
	}

	public static int solution(int[][] routes) {
		int answer = 0;
		ArrayList<Route> routesList = new ArrayList<Route>();
		for(int i = 0; i < routes.length; i++) {
			int[] route = routes[i];
			Route r = new Route(route[0], route[1], route[1] - route[0]);
			routesList.add(r);
		}
		
		Collections.sort(routesList);
		
		for(int i = 0; i < routesList.size(); i++) {
			Route r1 = routesList.get(i);
			answer++;
			for(int j = i + 1; j < routesList.size(); j++) {
				Route r2 = routesList.get(j);
				if(r1.getEnd() >= r2.getStart() && r1.getEnd() <= r2.getEnd())
				{
					routesList.remove(j);
					j--;
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[][] routes = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };

		System.out.println(solution(routes));
	}
}
