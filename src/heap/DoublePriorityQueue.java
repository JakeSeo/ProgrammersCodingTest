package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
	public static int[] solution(String[] operations) {
		int[] answer = new int[2];

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		int counter = 0;

		for (String op : operations) {
			String[] split = op.split(" ");
			String action = split[0];
			Integer value = Integer.valueOf(split[1]);
			if (action.equals("I")) {
				minHeap.add(value);
				maxHeap.add(value);
				counter++;
			} else if (action.equals("D")) {
				if (value == -1) {
					minHeap.poll();
				} else if (value == 1) {
					maxHeap.poll();
				}
				if(counter > 0) {
					counter--;
				}
			}
			if(counter == 0) {
				minHeap.clear();
				maxHeap.clear();
			}
		}
		if (minHeap.size() > 1 && maxHeap.size() > 1) {
			answer[0] = maxHeap.peek();
			answer[1] = minHeap.peek();
		} else {
			answer[0] = 0;
			answer[1] = 0;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
		int[] output = solution(operations);
		System.out.println(output[0] + " " + output[1]);;
	}

}
