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

			/** ���� ������ ��Ƽ�ǿ� �������� ���� ��� */
			if (used[temp] == false) {

				/** ��Ƽ���� �ڸ��� �˳��� ���, �׳� ���� */
				if (put < N) {
					used[temp] = true;
					put++;
				}
				/** ��Ƽ���� �ڸ��� �˳����� ���� ���, ���� ��Ƽ���� ������ ���߿� ���Ǵ��� Ȯ�� */
				else {
					ArrayList<Integer> list = new ArrayList<>();

					/** ���� �����ִ� �������� ���߿��� ���Ǵ��� Ȯ�� */
					for (int j = i; j < K; j++) {
						if (used[arr[j]] == true && !list.contains(arr[j]))
							list.add(arr[j]);
					}

					/** ���� ��� ���� ������ �Ϻθ� ���ȴٸ�, ������� �ʴ� ������ �����ϰ� ���� */
					if (list.size() < N) {
						for (int j = 0; j < used.length; j++) {
							if (used[j] == true && !list.contains(j)) {
								used[j] = false;
								break;
							}
						}
					}
					/** ���� ��� ���� ������ ��� ���ȴٸ�, ���� ���߿� ���Ǵ� ������ �����ϰ� ���� */
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
