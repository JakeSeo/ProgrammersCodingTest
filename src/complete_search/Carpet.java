package complete_search;

import java.util.ArrayList;

public class Carpet {
	public static ArrayList<Integer> getLCMList(int num) {
		ArrayList<Integer> lcmList = new ArrayList<>();
		
		for(int i = num/2+1; i >= 3; i--) {
			if(num % i == 0) {
				lcmList.add(i);
			}
		}
		return lcmList;
	}

	public static int[] solution(int brown, int yellow) {
		int sum = brown + yellow;

		ArrayList<Integer> lcmList = getLCMList(sum);

		for (int i = 0; i < lcmList.size() / 2 + 1; i++) {
			int width = lcmList.get(i);
			int height = sum / width;

			if (width * 2 + (height - 2) * 2 == brown) {
				return new int[] { width, height };
			}

		}

		return null;
	}

	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;

		int[] output = solution(brown, yellow);

		for (int i : output) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
