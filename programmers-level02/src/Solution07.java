import java.io.*;
import java.util.*;

public class Solution07 {

	static Queue<Item> queue = new LinkedList<>(); // 인쇄 대기목록
	static List<Item> list = new ArrayList<>(); // 인쇄 완료목록

	public int solution(int[] priorities, int location) {

		int index = 0;

		for (int priority : priorities) {
			queue.add(new Item(priority, index++));
		}

		print();
		
		int answer = 1;
		
		for (Item item : list) {
			
			if (item.number == location)
				break;

			answer++;
		}

		return answer;
	}

	/** 인쇄물을 인쇄하는 메서드 */
	static void print() {
		while (!queue.isEmpty()) {
			Item item = queue.poll();

			/* 대기목록에서 중요도가 높은 문서가 하나라도 존재하는 경우 */
			if (compare(item))
				queue.add(item);
			/* 그렇지 않은 경우 */
			else
				list.add(item);
		}
	}

	/** 현재 문서의 중요도와 대기목록 문서의 중요도를 비교하는 메서드 */
	static boolean compare(Item item) {

		for (Item another : queue) {
			if (item.priority < another.priority)
				return true;
		}

		return false;
	}

	/** 인쇄물의 정보를 정의한 클래스 */
	static class Item {
		int priority; // 인쇄물의 중요도
		int number; // 인쇄물의 번호

		Item(int priority, int number) {
			this.priority = priority;
			this.number = number;
		}
	}
}
