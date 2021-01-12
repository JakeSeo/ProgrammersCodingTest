package greedy;

import java.util.Arrays;

public class Lifeboat {
	public static int solution(int[] people, int limit) {
		int answer = people.length;
		Arrays.sort(people);
		
		int j = 0; 

		for (int i = people.length - 1; i >= 0; i--) {
			int pOnBoat = people[i];
			int candidate = people[j];
			
			if(j == i) {
				break;
			}
			
			if(pOnBoat + candidate <= limit) {
				j++;
				answer--;
			}
			
			if(j == i) {
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] people = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int limit = 100;

		System.out.println(solution(people, limit));
	}
}
