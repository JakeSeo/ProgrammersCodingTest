package DFS_BFS;

public class WordConversion {
	public static boolean oneLetterDifferent(String s1, String s2) {
		int diff = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				diff++;
			}
		}
		return diff == 1;
	}

	public static int dfs(int i, int num, String target, String[] words, boolean[] visited) {
		if (words[i].equals(target)) {
			return num;
		}
		if (visited[i]) {
			return num;
		}
		visited[i] = true;
		int answer = 0;
		for (int j = 0; j < words.length; j++) {
			if (!visited[j] && i != j && oneLetterDifferent(words[i], words[j])) {
				answer = dfs(j, num + 1, target, words, visited);
			}
		}
		return answer;
	}

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;

		for (int i = 0; i < words.length; i++) {
			boolean[] visited = new boolean[words.length];
			if (oneLetterDifferent(begin, words[i])) {
				int num = dfs(i, 1, target, words, visited);
				if(answer == 0 && num > 0) {
					answer = num;
				}
				if (num < answer) {
					answer = num;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String begin = "hit";
		String target = "wow";
		String[] words = { "hot", "dot", "dog", "lot", "log", "wow" };

		System.out.println(solution(begin, target, words));
	}
}
