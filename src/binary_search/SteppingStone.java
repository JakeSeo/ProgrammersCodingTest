package binary_search;

import java.util.Arrays;

public class SteppingStone {
	
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
		int answer = 0;
		int left = 0;
		int right = distance;
		int mid = 0;
		
		while(left <= right) {
			mid = (right + left) / 2;
			int prev = 0;
			int count = 0;
			for(int i = 0; i < rocks.length; i++) {
				if(rocks[i] - prev < mid) {
					count++;
					if(count > n) {
						break;
					}
					
				} else {
					prev = rocks[i];
				}
			}
			if(count > n) {
				right = mid - 1;
			} else {
				answer = answer > mid ? answer : mid;
				left = mid + 1;
			}
		}
		
		
		return answer;
    }
    
	public static void main(String[] args) {
		SteppingStone ss = new SteppingStone();
		
		int distance = 25;
		int[] rocks = {2, 14, 11, 21, 17};
		int n = 2;
		
		System.out.println(ss.solution(distance, rocks, n));
	}

}
