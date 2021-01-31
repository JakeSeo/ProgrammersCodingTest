package dynamic_programming;

public class IntegerTriangleV2 {
    public int solution(int[][] triangle) {
    	int[][] sumTriangle = new int[triangle.length][triangle.length];
    	for(int i = 0; i < triangle.length; i++) {
    		for(int j = 0; j < i + 1; j++) {
    			if(j == 0) {
    				if(i == 0) {
    					sumTriangle[i][j] = triangle[i][j];
    					continue;
    				}
    				sumTriangle[i][j] = sumTriangle[i - 1][j] + triangle[i][j];
    				continue;
    			}
    			
    			if(j == i) {
    				sumTriangle[i][j] = sumTriangle[i - 1][j - 1] + triangle[i][j];
    				continue;
    			}
    			
    			sumTriangle[i][j] = Math.max(sumTriangle[i - 1][j - 1], sumTriangle[i - 1][j]) + triangle[i][j];
    		}
    	}
    	int answer = 0;
    	for(int num : sumTriangle[triangle.length - 1]) {
    		answer = Math.max(answer, num);
    	}
        return answer;
    }
    
    public static void main(String[] args) {
    	int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
    	
    	IntegerTriangle it = new IntegerTriangle();
    	System.out.println(it.solution(triangle));
    }

}
