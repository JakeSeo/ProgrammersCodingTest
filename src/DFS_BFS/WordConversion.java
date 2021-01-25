package DFS_BFS;

public class WordConversion {
	public static boolean containsWord(String word, String[] words) {
		for(String w : words) {
			if(word.equals(w)) {
				return true;
			}
		}
		return false;
	}
	public static boolean oneLetterDifferent(String s1, String s2) {
		int diff = 0;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				diff++;
			}
			if(diff == 2) {
				return false;
			}
		}
		
		return true;
		
	}
	public static int dfs(int i, String word, String begin, String target, String[] words, boolean[] visited) {
		if(word.equals(target)) {
			System.out.println("hi");
			return 1;
		}
		visited[i] = true;
		for(int j = 0; j < words.length; j++) {
			if(!visited[j] && oneLetterDifferent(word, words[j])) {
				System.out.println(word);
				return 1 + dfs(j, words[j], begin, target, words, visited);
			}
		}
		return 0;
	}
	
	public static int solution(String begin, String target, String[] words) {
		int answer = 99999;
		if(!containsWord(target, words)) {
			return 0;
		}
		boolean[] visited = new boolean[words.length];
		for(int i = 0; i < words.length; i++) {
			if(oneLetterDifferent(begin, words[i])) {
				int num = dfs(0, words[i], begin, target, words, visited);
				
				if(num < answer) {
					answer = num;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		
		System.out.println(solution(begin, target, words));
	}
}
