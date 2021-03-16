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

		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if (c >= 'a' && c <= 'z') {
				small.push(c);
			} else {
				capital.push(c);
			}
		}
		int i = sentence.length() - 1;
		char c = '0';
		char s = '0';
		int countS = 0;
		int countB = 0;
		while (!small.isEmpty() && i >= 0) {
			c = sentence.charAt(i);
			if (small.peek() == c) {
				s = small.pop();
				countS++;
				i--;
			} else {
				answer = c + answer;
				countB++;
				i--;
			}
			if (s != '0') {
				char start = s;
				while (!small.isEmpty() && small.peek() == s) {
					c = sentence.charAt(i);
					if (c == s) {
						s = small.pop();
						countS++;
						i--;
					} else {
						answer = c + answer;
						countB++;
						i--;
					}
				}
				if (countS == 1 && small.peek() != s) {
					answer = sentence.charAt(i) + answer;
					i--;
					s = small.pop();
					i--;
					countS = 1;
					countB = 1;
					while (!small.isEmpty() && small.peek() == s) {
						c = sentence.charAt(i);
						if (c == s) {
							s = small.pop();
							countS++;
							i--;
						} else {
							answer = c + answer;
							countB++;
							i--;
						}
					}
					if (small.peek() == start) {
						small.pop();
						answer = sentence.charAt(i) + answer;
						if (i > 0) {
							answer = " " + answer;
						}
						i-=2;
						countS = 0;
						countB = 0;
					}
					System.out.println(countS + " " + countB);
				} else {
					if (countS != 0 && countB == countS) {
						answer = sentence.charAt(i) + answer;
						if (i > 0) {
							answer = " " + answer;
						}
						i--;
						countS = 0;
						countB = 0;
					}

					if (countS == 2) {
						if (i > 0) {
							answer = " " + answer;
						}
						countS = 0;
						countB = 0;
					}
				}
			}
		}
		
		int countLetters = 0;
		for (int j = 0; j < answer.length(); j++) {
			char character = answer.charAt(j);
			if (character >= 'A' && character <= 'Z') {
				countLetters++;
			}
		}
		if (capital.size() == countLetters) {
			return answer;
		} else {
			return "invalid";
		}
	}

	public static void main(String[] args) {
		BriansWorry bw = new BriansWorry();

//		String sentence = "HaEaLaLaOWbObRbLbD";
		String sentence = "SpIpGpOpNpGJqOqA";
//		String sentence = "AxAxAxAoBoBoB";
		// aaaabb

		System.out.println(bw.solution(sentence));
	}
}
