package dynamic_programming;

public class IntegerTriangle {
    public int dfa(int row, int col, int[][] triangle, int answer) {
        if(row == triangle.length - 1) {
            return answer;
        }
        
        int next1 = dfa(row + 1, col, triangle, answer + triangle[row + 1][col]);
        int next2 = dfa(row + 1, col + 1, triangle, answer + triangle[row + 1][col + 1]);
        
        return next1 > next2 ? next1 : next2;
    }
    public int solution(int[][] triangle) {
        return dfa(0, 0, triangle, triangle[0][0]);
    }
    
    public static void main(String[] args) {
    	int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
    	
    	IntegerTriangle it = new IntegerTriangle();
    	System.out.println(it.solution(triangle));
    }

}
