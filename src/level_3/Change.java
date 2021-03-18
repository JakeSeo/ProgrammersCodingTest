package level_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Change {
	ArrayList<int[]> changeList = new ArrayList<>();
	
	public void addChange(int index, int n, int[] change, int[] money) {
		int[] changeCopy = new int[change.length];
		int sum = 0;
		for(int i = 0; i < change.length; i++) {
			changeCopy[i] = change[i];
			sum += change[i];
		}
		
		if(sum == n) {
			changeList.add(changeCopy);
			return;
		} else if(sum > n) {
			return;
		}
		
		for(int i = 0; i < changeCopy.length; i++) {
			changeCopy[i] += money[i];
			addChange(i, n, changeCopy, money);
		}
	}
	
    public int solution(int n, int[] money) {
        int length = money.length;
        int maxNumCoins[] = new int[length];
        for(int i = 0; i < length; i++) {
        	maxNumCoins[i] =  n / money[i];
        }
        
        
        for(int i = 0; i < length; i++) {
        	int[] change = new int[length];
        	change[i] = money[i];
        	addChange(i, n, change, money);
        }
        
        for(int i = 0; i < changeList.size(); i++) {
        	int[] change = changeList.get(i);
        	for(int c : change) {
        		System.out.print( c + " ");
        	}
        	System.out.println();
        }
        
        return changeList.size();
    }
    
    public static void main(String[] args) {
    	int n = 5;
    	int money[] = {1, 3, 4, 5};
    	
    	Change c = new Change();
    	System.out.println(c.solution(n, money)); //must be 4
    }

}
