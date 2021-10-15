import java.util.*;

class Solution06 {
	static ArrayList<Food> list = new ArrayList<>();
	static int length;

	public int solution(int[] food_times, long k) {

		length = food_times.length;

		for (int i = 0; i < length; i++) {
			list.add(new Food(i + 1, food_times[i]));
		}

		Collections.sort(list, (o1, o2) -> o1.time - o2.time);

		int preTime = 0;
		int index = 0;

		for (Food food : list) {
			long diff = food.time - preTime;

			if (diff != 0) {
				long spendTime = diff * length;

				if (spendTime <= k) {
					k -= spendTime;
					preTime = food.time;
				} else {
					k %= length;
					list.subList(index, food_times.length).sort((o1, o2) -> o1.index - o2.index);
					return list.get(index + (int) k).index;
				}
			}
			length--;
			index++;
		}

		return -1;
	}

	/** 음식에 대한 정보를 정의 */
	static class Food {
		int index;
		int time;

		Food(int index, int time) {
			this.index = index;
			this.time = time;
		}
	}
}