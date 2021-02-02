package dynamic_programming;

public class Robbery {
    public int solution(int[] money) {
        int answer = 0;
        int stolenMoneySum1[] = new int[money.length - 1];
        int stolenMoneySum2[] = new int[money.length];

        stolenMoneySum1[0] = money[0];
        stolenMoneySum1[1] = money[0];
        
        stolenMoneySum2[0] = 0;
        stolenMoneySum2[1] = money[1];
        
        for(int i = 2; i < stolenMoneySum1.length; i++) {
        	stolenMoneySum1[i] = Math.max(stolenMoneySum1[i - 2] + money[i], stolenMoneySum1[i - 1]);
        }
        
        for(int i = 2; i < stolenMoneySum2.length; i++) {
        	stolenMoneySum2[i] = Math.max(stolenMoneySum2[i - 2] + money[i], stolenMoneySum2[i - 1]);
        }
        
        return Math.max(stolenMoneySum1[stolenMoneySum1.length - 1],  stolenMoneySum2[stolenMoneySum2.length - 1]);
    }
    
    public static void main(String[] args) {
    	Robbery r = new Robbery();

//    	int[] money = {1,1,3,1};
//    	int[] money = {1,1,4,1, 4};
    	int[] money = {1000, 0, 0, 0, 0, 1000, 0, 0, 1000, 0, 0, 1000};
//    	int[] money = {1,1,3,1};
//    	int[] money = {1,1,3,1};
    	
    	System.out.println(r.solution(money));
    }

}
