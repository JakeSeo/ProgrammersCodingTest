package skill_check_test_level3;

import java.util.Arrays;
import java.util.Collections;

public class OvertimeStress {
	
	
    public long solution(int n, int[] works) {
    	int sum = 0; 
    	for(int w: works) {
    		sum += w;
    	}
    	if(sum < n) {
    		return 0;
    	}
    	Arrays.sort(works);
        while(n > 0) {
        	for(int i = works.length - 1; i >= 1; i--) {
        		if(works[i] < works[i - 1]) {
        			int temp = works[i];
        			works[i] = works[i - 1];
					works[i - 1] = temp;
        		} else {
        			break;
        		}
        	}
        	works[works.length - 1]--;
        	n--;
        }
        long answer = 0;
        for(int i = 0; i < works.length; i++) {
        	answer+= works[i] * works[i];
        }
        return answer;
    }
	
	public static void main(String[] args) {
		OvertimeStress os = new OvertimeStress();
		
		int[] works = {4, 3, 3};
		int n = 4;
		
		System.out.println(os.solution(n, works));
	}
}
