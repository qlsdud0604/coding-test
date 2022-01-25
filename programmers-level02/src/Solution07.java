import java.io.*;
import java.util.*;

public class Solution07 {

	static Queue<Item> queue = new LinkedList<>(); // �μ� �����
	static List<Item> list = new ArrayList<>(); // �μ� �Ϸ���

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

	/** �μ⹰�� �μ��ϴ� �޼��� */
	static void print() {
		while (!queue.isEmpty()) {
			Item item = queue.poll();

			/* ����Ͽ��� �߿䵵�� ���� ������ �ϳ��� �����ϴ� ��� */
			if (compare(item))
				queue.add(item);
			/* �׷��� ���� ��� */
			else
				list.add(item);
		}
	}

	/** ���� ������ �߿䵵�� ����� ������ �߿䵵�� ���ϴ� �޼��� */
	static boolean compare(Item item) {

		for (Item another : queue) {
			if (item.priority < another.priority)
				return true;
		}

		return false;
	}

	/** �μ⹰�� ������ ������ Ŭ���� */
	static class Item {
		int priority; // �μ⹰�� �߿䵵
		int number; // �μ⹰�� ��ȣ

		Item(int priority, int number) {
			this.priority = priority;
			this.number = number;
		}
	}
}
