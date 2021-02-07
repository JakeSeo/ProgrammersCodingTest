package binary_search;

import java.util.Arrays;

public class Immigration2 {
	public boolean isPassed(int[] times, int n, long mid) {
		long amount = 0;
		
		for(int i = 0; i < times.length; i++) {
			amount += mid / times[i];
		}
		
		if(amount >= n) return true;
		else return false;
	}
    
    public long binarySearch(int[] times, int n, long min) {
    	long left = 1;
    	long right = min * n;
    	long mid = 0;
    	long answer = Long.MAX_VALUE;
    	
    	while(left <= right) {
    		mid = (left + right) / 2;
    		
    		if(isPassed(times, n, mid)) {
    			answer = answer > mid ? mid : answer;
    			right = mid - 1;
    		} else {
    			left = mid + 1;
    		}
    	}
    	return answer;
    }
	
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return binarySearch(times, n, times[0]);
    }
    
    public static void main(String[] args) {
    	Immigration2 immigration = new Immigration2();
    	
    	int n = 8;
    	int[] times = {5,4,3,2,1};
    	
    	System.out.println(immigration.solution(n, times));
    }
}
