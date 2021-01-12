package hashmap;

import java.util.HashMap;
import java.util.Map.Entry;

public class Camouflage {
    public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> clothesMap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
        	String type = clothes[i][1];
        	
        	clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        for(Entry<String, Integer> e: clothesMap.entrySet()) {
        	answer *= (e.getValue() + 1);
        }
        return answer - 1;
    }
	
    public static void main(String[] args) {
    	String[][] clothes = {{"1", "1"}, {"2", "2"}, {"3", "1"}};
    	System.out.println(solution(clothes));
    }
}
