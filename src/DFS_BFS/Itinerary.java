package DFS_BFS;

import java.util.ArrayList;
import java.util.HashMap;

public class Itinerary {
	public static boolean allVisited(boolean[] visited) {
		for (boolean b : visited) {
			if (!b) {
				return false;
			}
		}
		return true;
	}

	public static void dfs(int i, String[][] tickets, ArrayList<String> output, boolean[] visited) {
		visited[i] = true;
		
		if(allVisited(visited)) {
			return;
		}

		String word = output.get(output.size() - 1);
		int index = tickets.length;
		for (int j = 0; j < tickets.length; j++) {
			if (!visited[j] && tickets[j][0].equals(word) ) {
				if(index == tickets.length) {
					index = j;
				} else {
					if (tickets[index][1].compareTo(tickets[j][1]) > 0) {
						index = j;
					}
					
				}
			}
		}
		output.add(tickets[index][1]);
		dfs(index, tickets, output, visited);
	}

	public static String[] solution(String[][] tickets) {
		String[] answer = {};
		int index = tickets.length;
		ArrayList<String> output = new ArrayList<>();
		output.add("ICN");
		boolean[] visited = new boolean[tickets.length];
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
				if(index == tickets.length) {
					index = i;
				} else {
					if (tickets[index][1].compareTo(tickets[i][1]) > 0) {
						index = i;
					}
				}
			}
		}
		output.add(tickets[index][1]);
		dfs(index, tickets, output, visited);
		answer = new String[output.size()];
		for(int i = 0 ; i < output.size(); i++) {
			answer[i] = output.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, {"ATL", "ICN"}, {"ATL", "SFO"} };

		String[] output = solution(tickets);

		for (String s : output) {
			System.out.println(s);
		}
	}

}
