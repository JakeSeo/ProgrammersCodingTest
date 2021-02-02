package dynamic_programming;

public class RoadToSchoolV2 {
	int div = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
    	int[][] map = new int[n][m];
    	for(int i = 0; i < puddles.length; i++) {
    		map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
    	}
        map[0][0] = 1;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(map[i][j] == -1) {
                    map[i][j] = 0;
    				continue;
    			}
    			if(i != 0) {
    				map[i][j] += map[i - 1][j] % div;
    			}
    			if(j != 0) {
    			    map[i][j] += map[i][j - 1] % div;
    			}
    			
    		}
    	}
        return map[n - 1][m - 1] % div;
    }
	
    public static void main(String args[]) {
    	RoadToSchoolV2 rts = new RoadToSchoolV2();
    	
    	int m = 100;
    	int n = 100;
    	int[][] puddles = {{3, 1}, {2, 2}};
    	
    	System.out.println(rts.solution(m, n, puddles));
    }
}
