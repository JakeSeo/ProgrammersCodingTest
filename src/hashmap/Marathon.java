package hashmap;

import java.util.Arrays;

public class Marathon {
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		for (int i = 0; i < participant.length - 1; i++) {
			if(!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		return participant[participant.length - 1];
	}
	
	public static void main(String[] args) {
		String[] participants = {"leo", "kiki", "eden"};
		String[] completion = {"kiki", "eden"};
		
		System.out.println(solution(participants, completion));
	}

}
