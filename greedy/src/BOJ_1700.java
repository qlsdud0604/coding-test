import java.io.*;
import java.util.*;

public class BOJ_1700 {
	static int N;
	static int K;

	static int[] arr;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[K];
		used = new boolean[K + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {
		int result = 0;
		int put = 0;

		for (int i = 0; i < K; i++) {

			int temp = arr[i];

			/** 현재 도구가 멀티탭에 꽂혀있지 않은 경우 */
			if (used[temp] == false) {

				/** 멀티탭의 자리가 넉넉한 경우, 그냥 꼽음 */
				if (put < N) {
					used[temp] = true;
					put++;
				}
				/** 멀티탭의 자리가 넉넉하지 않은 경우, 현재 멀티탭의 도구가 나중에 사용되는지 확인 */
				else {
					ArrayList<Integer> list = new ArrayList<>();

					/** 현재 꽂혀있는 도구들이 나중에도 사용되는지 확인 */
					for (int j = i; j < K; j++) {
						if (used[arr[j]] == true && !list.contains(arr[j]))
							list.add(arr[j]);
					}

					/** 현재 사용 중인 도구가 일부만 사용된다면, 사용하지 않는 도구를 제거하고 꼽음 */
					if (list.size() < N) {
						for (int j = 0; j < used.length; j++) {
							if (used[j] == true && !list.contains(j)) {
								used[j] = false;
								break;
							}
						}
					}
					/** 현재 사용 중인 도구가 모두 사용된다면, 가장 나중에 사용되는 도구를 제거하고 꼽음 */
					else {
						used[list.get(list.size() - 1)] = false;
					}

					used[temp] = true;
					result++;
				}
			}
		}

		return result;
	}

}
