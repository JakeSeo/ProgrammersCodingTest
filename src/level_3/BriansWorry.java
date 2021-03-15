package level_3;

import java.util.ArrayList;
import java.util.Stack;

public class BriansWorry {
	int RULE1 = 0;
	int RULE2 = 1;
	int RULE_BOTH = 2;
	int RULE_NOT_SURE = 3;
	
	public String solution(String sentence) {
		String answer = "";
		Stack<Character> small = new Stack<>();
		Stack<Character> capital = new Stack<>();
		
		for(int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if(c >= 'a' && c <= 'z') {
				small.push(c);
			} else {
				capital.push(c);
			}
		}
		int i = sentence.length() - 1;
		ArrayList<Character> charList = new ArrayList<>();
		int currRule = RULE_NOT_SURE;
		int count = 0;
		boolean lastWasSmall = true;
		while(!small.isEmpty() && !capital.isEmpty()) {
			char c = sentence.charAt(i);
			char s;
			char b;
			if(c >= 'a' && c <= 'z') {
				s = small.pop();
				charList.add(s);
				if(!lastWasSmall) {
					count = 0;
				}
				count++;
				lastWasSmall = true;
				if(currRule == RULE_NOT_SURE && count <= 1) {
					currRule = RULE2;
				}
			} else {
				b = capital.pop();
				answer = b + answer;
				if(lastWasSmall) {
					count = 0;
				}
				count++;
				lastWasSmall = false;
				if(currRule == RULE_NOT_SURE && count <= 1) {
					currRule = RULE1;
				}
			}
			
			i--;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		BriansWorry bw = new BriansWorry();
		
		String sentence = "HaEaLaLaObWORLDb";
		
		System.out.println(bw.solution(sentence));
	}
}
