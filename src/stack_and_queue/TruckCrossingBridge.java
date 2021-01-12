package stack_and_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingBridge {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0;
		Queue<Integer> bridge = new LinkedList<>();
		int sum = 0;
		for (int truck_weight : truck_weights) {
			while (true) {
				if (bridge.isEmpty()) {
					bridge.add(truck_weight);
					time++;
					sum += truck_weight;
					break;
				} else if (bridge.size() == bridge_length) {
					sum -= bridge.poll();
				} else {
					if (sum + truck_weight > weight) {
						bridge.add(0);
						time++;
					} else {
						bridge.add(truck_weight);
						time++;
						sum += truck_weight;
						break;
					}
				}
			}
		}
		return time + bridge_length;
	}
}
