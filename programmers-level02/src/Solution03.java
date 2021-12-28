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

			int food01 = queue.poll(); // 가장 맵지 않은 음식의 스코빌 지수
			int food02 = queue.poll(); // 두 번째로 맵지 않은 음식의 스코빌 지수

			int newFood = food01 + 2 * food02;

			queue.add(newFood);

			answer++;
		}

		return answer;
	}

	/** 주어진 모든 음식의 스코빌 지수가 K이상임을 판단하는 메서드 */
	static boolean check(PriorityQueue<Integer> queue, int K) {

		for (int data : queue)
			if (data < K)
				return false;

		return true;
	}
}
