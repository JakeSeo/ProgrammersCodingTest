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
        while(!(n == 0 && allFinished(immigration))) {
        	for(int i = 0; i < times.length; i++) {
    			if(immigration[i] == 0) {
    				n--;
    			}
        		immigration[i]++;
        		System.out.println(time + " " + (i + 1) + " " + immigration[i]);
        		if(immigration[i] == times[i]) {
        			immigration[i] = 0;
        		}
        		
        	}
        	time++;
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
