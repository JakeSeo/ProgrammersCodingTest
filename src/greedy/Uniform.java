package greedy;

public class Uniform {
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		int[] students = new int[n];

		for (int l : lost)
			students[l - 1]--;
		for (int r : reserve)
			students[r - 1]++;

		for (int i = 0; i < n; i++) {
			if (students[i] == -1) {
				if (i - 1 >= 0 && students[i - 1] == 1) {
					students[i]++;
					students[i - 1]--;
				} else if (i + 1 < n && students[i + 1] == 1) {
					students[i]++;
					students[i + 1]--;
				} else {
					answer--;
				}
			}
		}

		return answer;
//		int answer = n - lost.length;
//		
//		// change the value of people who lost and has reserve to -1
//		for (int i = 0; i < lost.length; i++) {
//			for (int j = 0; j < reserve.length; j++) {
//				if (lost[i] == reserve[j]) {
//					lost[i] = -1;
//					reserve[j] = -1;
//					answer++;
//					break;
//				}
//			}
//		}
//		
//		// sort the array
//		Arrays.sort(lost);
//		Arrays.sort(reserve);
//
//		System.out.println(Arrays.toString(lost));
//		System.out.println(Arrays.toString(reserve));
//		
//
//		for (int i = 0; i < lost.length; i++) {
//			if(lost[i] == -1) {
//				continue;
//			}
//			for (int j = 0; j < reserve.length; j++) {
//				if(reserve[j] == -1) {
//					continue;
//				}
//				if (lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]) {
//					lost[i] = -1;
//					reserve[j] = -1;
//					answer++;
//					break;
//				}
//			}
//		}

//		// check if who can borrow and who cannot
//		int lIndex = 0;
//		int rIndex = 0;
//		System.out.println(answer);
//		while (lIndex < lost.length && rIndex < reserve.length) {
//
//			int borrower = lost[lIndex];
//			int lender = reserve[rIndex];
//
//			if (borrower == -1) {
//				lIndex++;
//				continue;
//			}
//			if (lender == -1) {
//				rIndex++;
//				continue;
//			}
//			
//			System.out.println(lIndex + " b  l " + rIndex);
//
//			if ((borrower == lender + 1) || (borrower == lender - 1)) {
//				answer += 1;
//				rIndex += 1;
//			}
//			lIndex += 1;
//
//		}
//		return answer;
	}

	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 1, 3, 5 };

		System.out.println(solution(n, lost, reserve));
	}
}
