package DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Itinerary {
	ArrayList<String> list = new ArrayList<>();
	String posAnswer = "";
	boolean[] visited;
	public void dfs(String[][] tickets, String dest, int count) {
		posAnswer += dest + " ";
		
		if(count == tickets.length) {
			if(posAnswer.split(" ").length == tickets.length + 1)
				list.add(posAnswer);
			System.out.println(posAnswer);
			return;
		}
		
		for(int i = 0 ; i < tickets.length; i++) {
			String from = tickets[i][0];
			String to = tickets[i][1];
			if(dest.equals(from) && !visited[i]) {
				visited[i] = true;
				dfs(tickets, to, count  + 1);
				visited[i] = false;
				posAnswer = posAnswer.substring(0, posAnswer.length() - 4);
				
			}
		}
	}

	public String[] solution(String[][] tickets) {
		for(int i = 0 ; i < tickets.length; i++) {
			visited = new boolean[tickets.length];
			String from = tickets[i][0];
			String to = tickets[i][1];
			if(from.equals("ICN")) {
				visited[i] = true;
				posAnswer = "ICN ";
				dfs(tickets, to, 1);
			}
		}
		Collections.sort(list);
		return list.get(0).split(" ");
	}

	public static void main(String[] args) {
		Itinerary i = new Itinerary();
		
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, {"ATL", "ICN"}, {"ATL", "SFO"} };

		String[] output = i.solution(tickets);

		for (String s : output) {
			System.out.println(s);
		}
	}

}
