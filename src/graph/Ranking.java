package graph;

public class Ranking {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] check = new boolean[n][n];
        
        for(int[] r : results) {
        	int winner = r[0];
        	int loser = r[1];
        	check[winner - 1][loser - 1] = true;
        }
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		for(int k = 0; k < n; k++) {
        			if(check[j][i] && check[i][k]) {
        				check[j][k] = true;
        			}
        		}
        	}
        }
        int[] count = new int[n];
        for(int i = 0; i < n; i++) {
        	for(int j = i; j < n; j++) {
        		if(check[i][j] || check[j][i]) {
        			count[i]++;
        			count[j]++;
        		}
        	}
        }
        for(int c : count) {
        	if(c == n - 1) {
        		answer++;
        	}
        }
        return answer;
    }
    
    public static void main(String args[]) {
    	int n = 5;
    	int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
    	
    	Ranking r = new Ranking();
    	System.out.println(r.solution(n, results));
    }

}
