package graph;

import java.util.HashSet;

public class FarthestNode {
	public boolean all0(int[][] edge) {
		for(int a[] : edge) {
			if(a[0] != 0) {
				return false;
			}
			
			if(a[1] != 0) {
				return false;
			}
		}
		return true;
	}
    public int solution(int n, int[][] edge) {
        HashSet<Integer> checkSet = new HashSet<Integer>();
        checkSet.add(1);
        int answer = 0;
        while(!all0(edge)) {
        	for(int i = 0; i < edge.length; i++) {
        		for(int j : checkSet) {
        			if(edge[i][0] == j) {
        				edge[i][0] = 0;
        				continue;
        			}
        			if(edge[i][1] == j) {
        				edge[i][1] = 0;
        			}
        		}
        	}
        	answer = checkSet.size();
        	
        	checkSet.clear();
        	for(int i = 0; i < edge.length; i++) {
        		if(edge[i][0] == 0 && edge[i][1] == 0) {
        			continue;
        		}
        		if(edge[i][0] == 0) {
        			checkSet.add(edge[i][1]);
        		}
        		
        		if(edge[i][1] == 0) {
        			checkSet.add(edge[i][0]);
        		}
        	}
        }
        return answer;
    }
	
	public static void main(String args[]) {
		FarthestNode fn = new FarthestNode();
		
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		System.out.println(fn.solution(n, vertex));
		
	}

}
