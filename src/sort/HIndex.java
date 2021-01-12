package sort;

import java.util.Arrays;

public class HIndex {
    public static int solution(int[] citations) {
        int length = citations.length;
        
        for(int posH = length; posH > 0; posH--) {
        	int countThesisHigher = 0;
        	int countThesisLower = 0;
        	for(int i = 0; i < length; i++) {
        		if(posH <= citations[i]) {
        			countThesisHigher++;
        		} else {
        			countThesisLower++;
        		}
        	}
        	if(countThesisHigher >= posH && countThesisLower < posH) {
        		return posH;
        	}
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	int[] citations = {3, 0, 6, 1, 5};
    	
    	System.out.println(solution(citations));
    }

}
