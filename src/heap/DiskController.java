package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {
	static class HardDisk {
		private int entry;
		private int time;
		private int sum;

		public HardDisk(int entry, int time) {
			this.entry = entry;
			this.time = time;
			this.sum = entry + time;
		}

		public int getEntry() {
			return entry;
		}

		public void setEntry(int entry) {
			this.entry = entry;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public int getSum() {
			return sum;
		}
	}

	public static int solution(int[][] jobs) {
		int answer = 0;
		int numJobs = jobs.length;
		PriorityQueue<HardDisk> jobsQ = new PriorityQueue<>(Comparator.comparing(HardDisk::getEntry));
		PriorityQueue<HardDisk> sumQ = new PriorityQueue<>(Comparator.comparing(HardDisk::getTime));
		for (int[] i : jobs) {
			jobsQ.add(new HardDisk(i[0], i[1]));

		}
		int timeSpent = 0;
		while (!(jobsQ.isEmpty() && sumQ.isEmpty())) {
			while ((!jobsQ.isEmpty()) && jobsQ.peek().getEntry() <= timeSpent) {
				sumQ.add(jobsQ.poll());
			}
			if (!sumQ.isEmpty()) {
				HardDisk hd = sumQ.poll();
				timeSpent += hd.getTime(); 
				System.out.println(hd.getEntry() + " " + hd.getTime());
				int totalTime = timeSpent - hd.getEntry();
				answer += totalTime;

			} else {
				timeSpent++;
			}
		}
		return answer / numJobs;
	}

	public static void main(String[] args) {
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 500, 6 }, { 2, 6 } };

		System.out.println(solution(jobs));
	}

}
