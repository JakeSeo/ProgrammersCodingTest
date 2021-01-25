package DFS_BFS;

import java.util.ArrayList;

public class TargetNumber {
	public static int dfs(int prevNum, int index, int[] numbers, int target) {
		if(index == numbers.length) {
			if(prevNum == target) {
				return 1;
			}
			return 0;
		}
		
		int cur1 = prevNum + numbers[index];
		int cur2 = prevNum - numbers[index];
		
		int answer = 0;
		answer += dfs(cur1, index + 1, numbers, target);
		answer += dfs(cur2, index + 1, numbers, target);
		
		return answer;
	}
	public static int solution(int[] numbers, int target) {
		return dfs(0, 0, numbers, target);
	}
	
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
	}
}
