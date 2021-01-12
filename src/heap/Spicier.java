package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Spicier {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovilleQ = new PriorityQueue<>();
        for(Integer s : scoville) {
        	scovilleQ.add(s);
        }
        while(scovilleQ.size() > 1 && scovilleQ.peek() <= K) {
        	int firstFood = scovilleQ.poll();
        	int secFood = scovilleQ.poll();
        	int result = firstFood + 2 * secFood;
        	
        	scovilleQ.add(result);
        	
        	for(int i: scovilleQ) {
        		System.out.print(i + " ");
        	}
        	System.out.println();
        	
        	answer++;
        }
        if(scovilleQ.peek() < K) {
        	answer = -1;
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] scoville = {1,2,3,9,10,12};
    	int K = 7;
    	
    	System.out.println(solution(scoville, K));
    }

}
