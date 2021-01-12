package complete_search;

public class MockExam {
	public static int[] solution(int[] answers) {
		int[] answer = {};
		int len = answers.length;
		int[] person1 = { 1, 2, 3, 4, 5 };
		int[] person2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] person3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int numCorrects[] = new int[3];

		for (int i = 0; i < len; i++) {
			if (answers[i] == person1[i % person1.length]) {
				numCorrects[0]++;
			}
			if (answers[i] == person2[i % person2.length]) {
				numCorrects[1]++;
			}
			if (answers[i] == person3[i % person3.length]) {
				numCorrects[2]++;
			}
		}
		if (numCorrects[0] == numCorrects[1] && numCorrects[1] == numCorrects[2]) {
			answer = new int[3];
			answer[0] = 1;
			answer[1] = 2;
			answer[2] = 3;
		} else if (numCorrects[0] > numCorrects[1] && numCorrects[0] > numCorrects[2]) {
			answer = new int[1];
			answer[0] = 1;

		} else if (numCorrects[1] > numCorrects[0] && numCorrects[1] > numCorrects[2]) {
			answer = new int[1];
			answer[0] = 2;

		} else if (numCorrects[2] > numCorrects[0] && numCorrects[2] > numCorrects[1]) {
			answer = new int[1];
			answer[0] = 3;

		} else if (numCorrects[0] == numCorrects[1] && numCorrects[0] > numCorrects[2]) {
			answer = new int[2];
			answer[0] = 1;
			answer[1] = 2;

		} else if (numCorrects[0] == numCorrects[2] && numCorrects[0] > numCorrects[1]) {
			answer = new int[2];
			answer[0] = 1;
			answer[1] = 3;

		} else if (numCorrects[1] == numCorrects[2] && numCorrects[1] > numCorrects[0]) {
			answer = new int[2];
			answer[0] = 2;
			answer[1] = 3;

		}
		return answer;
	}

	public static void main(String[] args) {
		int[] answers = { 1, 3, 2, 4, 2 };

		int[] output = solution(answers);
		for (int i : output) {
			System.out.print(i + " ");
		}
	}

}
