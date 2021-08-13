import java.io.*;
import java.util.*;

public class BOJ_13904 {
	static int N;
	static Assignment[] arr;

	static int[] result = new int[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new Assignment[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int leftDay = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());

			arr[i] = new Assignment(leftDay, point);
		}

		Arrays.sort(arr);

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {

		for (int i = 0; i < arr.length; i++) {

			/** 마감일에 과제를 할 수 있는 경우 통과 */
			if (result[arr[i].day] == 0) {
				result[arr[i].day] = arr[i].weight;
			}

			/** 마감일에 과제를 할 수 없는 경우 다른 날로 대체 */
			else {

				/** 마감일과 가장 가까운 날부터 탐색 */
				for (int j = arr[i].day; j >= 1; j--) {
					if (result[j] == 0) {
						result[j] = arr[i].weight;
						break;
					}
				}
			}
		}

		int sum = 0;

		for (int i = 0; i < 1001; i++)
			sum += result[i];

		return sum;
	}

	static class Assignment implements Comparable<Assignment> {
		int day;
		int weight;

		public Assignment(int day, int weight) {
			this.day = day;
			this.weight = weight;
		}

		@Override
		public int compareTo(Assignment o) {

			return o.weight - this.weight;
		}

	}

}
