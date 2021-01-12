package stack_and_queue;

import java.util.Queue;
import java.util.LinkedList;

public class Printer {
	class Request {
		private int priority;
		private int firstLocation;
		private int order;
		
		public Request(int priority, int firstLocation) {
			this.setPriority(priority);
			this.setFirstLocation(firstLocation);
		}
		
		public int getPriority() {
			return priority;
		}
		
		public int getFirstLocation() {
			return firstLocation;
		}
		
		public int getOrder() {
			return order;
		}
		
		public void setPriority(int priority) {
			this.priority = priority;
		}
		
		public void setFirstLocation(int firstLocation) {
			this.firstLocation = firstLocation;
		}
		
		public void setOrder(int order) {
			this.order = order;
		}
	}
	
	public boolean isPriority(Queue<Request> waitingList, Request request) {
		for(Request r: waitingList) {
			if(r.getPriority() > request.getPriority()) {
				return false;
			}
		}
		return true;
	}
	
	public int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Request> waitingList = new LinkedList<Request>();
		for(int i = 0; i < priorities.length; i++) {
			Request r = new Request(priorities[i], i);
			waitingList.add(r);
			System.out.println(i + ": priority=" + r.getPriority() + " location=" + r.getFirstLocation());
		}
		
		while(true) {
			Request r = waitingList.poll();
			if(isPriority(waitingList, r)) {
				answer++;
				r.setOrder(answer);
				if(location == r.getFirstLocation()) {
					return r.getOrder();
				}
			} else {
				waitingList.add(r);
			}
			
		}
	}
	
	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 1;
		
//		System.out.println(solution(priorities, location));
	}

}
