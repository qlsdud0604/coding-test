import java.io.*;
import java.util.*;

public class Solution03 {

	public int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int food : scoville)
			queue.add(food);

		while (!check(queue, K)) {

			if (queue.size() == 1 && queue.poll() < K)
				return -1;

			int food01 = queue.poll(); // ���� ���� ���� ������ ���ں� ����
			int food02 = queue.poll(); // �� ��°�� ���� ���� ������ ���ں� ����

			int newFood = food01 + 2 * food02;

			queue.add(newFood);

			answer++;
		}

		return answer;
	}

	/** �־��� ��� ������ ���ں� ������ K�̻����� �Ǵ��ϴ� �޼��� */
	static boolean check(PriorityQueue<Integer> queue, int K) {

		for (int data : queue)
			if (data < K)
				return false;

		return true;
	}
}
