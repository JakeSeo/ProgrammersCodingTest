package complete_search;

import java.util.ArrayList;

public class FindPrimeNumber {
	static class Permutation {
		private ArrayList<Integer> list;

		public Permutation() {
			list = new ArrayList<Integer>();
		}

		public ArrayList<Integer> getList() {
			return list;
		}

		public void permutation(ArrayList<String> list, ArrayList<String> result, int num, int r) {
			if (r == 0) {
				String s = "";
				for(String resultChar : result) {
					s += resultChar;
				}
				int value = Integer.valueOf(s);
				if(!this.list.contains(value)) {
					this.list.add(Integer.valueOf(s));
				}
				return;
			}

			for (int i = 0; i < num; i++) {
				result.add(list.remove(i));
				permutation(list, result, num - 1, r - 1);
				list.add(i, result.remove(result.size() - 1));

			}
		}

	}

	public static boolean isPrimeNumber(int num) {
		if (num == 1 || num == 0) {
			return false;
		}

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int solution(String numbers) {
		int len = numbers.length();
		ArrayList<String> nums = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			nums.add(String.valueOf(numbers.charAt(i)));
		}
		Permutation ps = new Permutation();
		for(int i = 1; i <= len; i++) {
			ps.permutation(nums, result, len, i);
		}
		ArrayList<Integer> list = ps.getList();
		

		int count = 0;
		for (int i : list) {
			if (isPrimeNumber(i)) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		String numbers = "011";

		System.out.println(solution(numbers));
	}
}
