package sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public static String solution(int[] numbers) {
		String answer = new String();
		String[] strNums = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			strNums[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(strNums, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});
		if(strNums[0].equals("0")) {
			answer = "0";
		} else {
			for(String s : strNums) {
				answer += s;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] numbers = { 3, 30, 34, 5, 9, 100 };

		System.out.println(solution(numbers));
	}

}
