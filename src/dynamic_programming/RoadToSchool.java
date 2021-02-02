package dynamic_programming;

public class RoadToSchool {
	boolean foundShortest = false;
	int shortest = 0;
	int answer = 0;
	int div = 1000000007;
	public boolean isOnPuddle(int row, int col, int[][] puddles) {
		for(int[] puddle: puddles) {
			if(row == puddle[1] && col == puddle[0]) {
				return true;
			}
		}
		
		return false;
	}
	public void dfs(int row, int col, int m, int n, int[][] puddles, int num) {
		if(row > n) {
			return;
		}
		if(col > m) {
			return;
		}
		if(isOnPuddle(row, col, puddles)) {
			return;
		}
		
		if(row == n && col == m) {
			if(foundShortest) {
				if(num == shortest) {
					answer++;
				}
			} else {
				foundShortest = true;
				shortest = num;
				answer++;
			}
			return;
		}
		
		if(foundShortest && num > shortest) {
			return;
		}
		
		dfs(row + 1, col, m, n, puddles, num + 1);
		dfs(row, col + 1, m, n, puddles, num + 1);
	}
    public int solution(int m, int n, int[][] puddles) {
    	dfs(1, 1, m, n, puddles, 0);
        return answer % div;
    }
	
    public static void main(String args[]) {
    	RoadToSchool rts = new RoadToSchool();
    	
    	int m = 100;
    	int n = 100;
    	int[][] puddles = {{1, 2}};
    	
    	System.out.println(rts.solution(m, n, puddles));
    }
}
