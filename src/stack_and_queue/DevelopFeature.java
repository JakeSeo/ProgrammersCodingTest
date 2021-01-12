package stack_and_queue;

import java.util.ArrayList;

public class DevelopFeature {

	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        int[] answer = {};
	        ArrayList<Integer> list = new java.util.ArrayList<Integer>();
	        int length = progresses.length;
	        int largestRemainingDay = 0;
	        for(int i = 0; i < length; i++) {
	        	int remainingPercentage = 100 - progresses[i];
	            int remainingDay = remainingPercentage / speeds[i] + ((remainingPercentage % speeds[i] != 0) ? 1 : 0);
	            if(remainingDay > largestRemainingDay) {
	            	largestRemainingDay = remainingDay;
	            	list.add(1);
	            } else {
	            	list.set(list.size() - 1, list.get(list.size() - 1) + 1);
	            }
	            System.out.println(list.get(list.size() - 1));
	        }
	        return answer;
	    }
	}
}
