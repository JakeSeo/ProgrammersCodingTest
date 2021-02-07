package binary_search;

public class Immigration2 {
	
    public long solution(int n, int[] times) {
        int time = 0;
        int minTime = 9999;
        for(int t : times) {
        	if(minTime > t) {
        		minTime = t;
        	}
        }
        time = minTime * n;
        
        
        
        return time;
    }
    
    public static void main(String[] args) {
    	Immigration2 immigration = new Immigration2();
    	
    	int n = 6;
    	int[] times = {7, 10};
    	
    	System.out.println(immigration.solution(n, times));
    }
}
