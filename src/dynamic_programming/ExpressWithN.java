package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;

public class ExpressWithN {
    public int solution(int N, int number) {
    	if(N == number) {
    		return 1;
    	}
        ArrayList<Integer>[] sets = new ArrayList[8]; 
        for(int i = 0 ; i < 8; i++) {
        	ArrayList<Integer> set = new ArrayList<>();
        	int dec = 1;
        	int num = 0;
        	for(int j = 0; j <= i; j++) {
        		num += dec * N;
        		dec *= 10;
        	}
        	System.out.print(i + ": " + num + " ");
        	set.add(num);
        	sets[i] = set;
        	for(int j = 0; j < i; j++) {
        		ArrayList<Integer> set1 = new ArrayList<>(sets[j]);
        		Collections.copy(set1, sets[j]);
        		ArrayList<Integer> set2 = new ArrayList<>(sets[i - 1 - j]);
        		Collections.copy(set2,  sets[i - 1  - j]);
        		
        		for(int k = 0; k < set1.size(); k++) {
        			for(int l = 0; l < set2.size(); l++) {
        				int num1 = set1.get(k);
        				int num2 = set2.get(l);
        				
        				int addition = num1 + num2;
        				set.add(addition);
        				int subtraction = -1;
        				int multiplication = num1 * num2;
        				set.add(multiplication);
        				int division = -1;
        				if(num1 >= num2) {
        					subtraction = num1 - num2;
        					set.add(subtraction);
        				} else {
        					subtraction = num2 - num1;
        					set.add(subtraction);
        				}
        				if(num2 != 0) {
        					division = num1 / num2;
        					set.add(division);
        				} else if(num1 != 0){
        					division = num2 / num1;
        					set.add(division);
        				}
        				
        				System.out.print(addition + " " + subtraction + " " + multiplication + " " + division + " ");
        				
        				
        				
        				if(
    						addition == number || 
    						subtraction == number || 
    						multiplication == number || 
    						division == number
						) {
        					return i + 1;
        				}
        			}
        		}
        	}
    		System.out.println();
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	int N = 5;
    	int number = 5;
    	
    	ExpressWithN ewn = new ExpressWithN();
    	
    	System.out.println(ewn.solution(N, number));
    }
}
