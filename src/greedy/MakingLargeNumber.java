package greedy;

import java.util.Stack;

public class MakingLargeNumber {

	public static String solution(String number, int k) {
		StringBuilder sbNum = new StringBuilder("");
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);
		}
		for (char c : stack) {
			sbNum.append(c);
		}
		if (k > 0) {
			sbNum.delete(sbNum.length() - k, sbNum.length());
		}
		return sbNum.toString();
	}

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;

		System.out.println(solution(number, k));
	}

}
