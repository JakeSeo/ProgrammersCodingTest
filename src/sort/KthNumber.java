package sort;

import java.util.Arrays;

public class KthNumber {
    public static int[] solution(int[] array, int[][] commands) {
    	int length = commands.length;
        int[] answer = new int[length];
        for(int i = 0; i < length; i++) {
        	int start = commands[i][0];
        	int end = commands[i][1];
        	int k = commands[i][2];
        	
        	int[] subArray = new int[end - start + 1];
        	
        	subArray = Arrays.copyOfRange(array, start - 1, end);
        	Arrays.sort(subArray);
        	
        	answer[i] = subArray[k - 1];
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] array = {1, 5, 2, 6, 3, 7, 4};
    	int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    	
    	int[] output = solution(array, commands);
    	
    	for(int i : output) {
    		System.out.print(i + " ");
    	}
    }

}
