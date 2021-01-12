package greedy;

public class JoyStick {

	public static int move(int index, int size, boolean isRight) {
		if (isRight) {
			if (index == size - 1) {
				return 0;
			}
			return index + 1;
		} else {
			if (index == 0) {
				return size - 1;
			}
			return index - 1;
		}
	}

	public static int getNumA(int index, String name, boolean isRight) {
		int count = 0;
		index = move(index, name.length(), isRight);
		while (name.charAt(index) == 'A') {
			count++;
			index = move(index, name.length(), isRight);
		}
		return count;
	}

	public static String changeToA(String name, int index) {
		StringBuilder sb = new StringBuilder(name);
		sb.setCharAt(index, 'A');
		return sb.toString();
	}

	public static int solution(String name) {
		int[] alphabetValue = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int answer = 0;
		int len = name.length();
		int index = 0;

		boolean currIsRight = true;
		while (true) {
			int leftA = getNumA(index, name, false); // 왼쪽에 있는 A의 개수
			int rightA = getNumA(index, name, true); // 오른쪽에 있는 A의 개수
			if (leftA == len - 1 || rightA == len - 1) {
				answer += alphabetValue[name.charAt(index) - 'A'];
				name = changeToA(name, index);
				break;
			}
			if (rightA > leftA) {
				currIsRight = false;
			} else {
				currIsRight = true;
			}

			answer += alphabetValue[name.charAt(index) - 'A'];
			name = changeToA(name, index);
			index = move(index, len, currIsRight);
			answer++;
			System.out.println(name);

		}
		return answer;

	}

	public static void main(String[] args) {
		String name = "BAAAAABBB";
		System.out.println(solution(name));
	}

}
