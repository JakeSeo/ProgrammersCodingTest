package binary_search;

public class Immigration {
	public boolean allFinished(int[] times) {
		for(int i = 0; i < times.length; i++) {
			if(times[i] == 0) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
    public long solution(int n, int[] times) {
        int time = 0;
        int[] immigration = new int[times.length];
        while(true) {
        	time++;
        	for(int i = 0; i < times.length; i++) {
    			if(immigration[i] == 0) {
    				n--;
            		System.out.println(time + " " + (times[i]) + " " + immigration[i] + " " + n);
    				if(n == 0) {
    					break;
    				}
    			}
        		immigration[i]++;
        		if(immigration[i] == times[i]) {
        			immigration[i] = 0;
        		}
        		
        	}
        	if(time == 30) {
        		break;
        	}
        }
        return time;
    }
    
    public static void main(String[] args) {
    	Immigration immigration = new Immigration();
    	
    	int n = 6;
    	int[] times = {7, 10};
    	
    	System.out.println(immigration.solution(n, times));
    }
}
