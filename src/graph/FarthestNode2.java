package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FarthestNode2 {
    public int solution(int n, int[][] edge) {
    	int answer = 0;
    	ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    	for(int i = 0; i < n; i++) {
    		list.add(new ArrayList<Integer>());
    	}
    	
    	for(int[] node : edge) {
    		list.get(node[0] - 1).add(node[1]);
    		list.get(node[1] - 1).add(node[0]);
    	}
    	
    	boolean[] visited = new boolean[n];
    	int[] count = new int[n];
    	Queue<Integer> queue = new LinkedList<>();
    	
    	Arrays.fill(visited, false);
    	Arrays.fill(count,  0);
    	queue.add(1);
    	visited[0] = true;
    	while(!queue.isEmpty()) {
    		int currNum = queue.poll();
    		for(int nextNum : list.get(currNum -1)) {
    			if(!visited[nextNum - 1]) {
    				visited[nextNum - 1] = true;
    				queue.add(nextNum);
    				count[nextNum - 1] = count[currNum - 1] + 1;
    			}
    		}
    	}
    	
    	
    	int max = count[0];
    	for(int c : count) {
    		if(max == c) {
    			answer++;
    		} else if(c > max) {
    			answer = 1;
    			max = c;
    		}
    	}
    			
        return answer;
    }
	
	public static void main(String args[]) {
		FarthestNode2 fn = new FarthestNode2();
//		
//		int n = 6;
//		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int n = 2;
		int[][] vertex = {{1, 2}};
		
		System.out.println(fn.solution(n, vertex));
		
	}

}
