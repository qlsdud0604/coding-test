import java.io.*;
import java.util.*;

public class BOJ_9489 {
	static int N;
	static int K;

	static int[] nodes;
	static int[] parents;

	static int target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			/* 입력받은 수 모두 0이라면 종료 */
			if (N == 0 && K == 0)
				break;

			nodes = new int[N];
			parents = new int[N];

			int result = 0;

			String[] input = br.readLine().split(" ");

			for (int i = 0; i < input.length; i++) {
				int number = Integer.parseInt(input[i]);

				if (number == K)
					target = i;

				nodes[i] = number;
			}

			getParent();

			/* 타겟 노드와 부모가 다르고 깊이가 같으면 결과를 1씩 증가 */
			for (int i = 1; i < N; i++) {
				if (parents[target] != parents[i] && parents[parents[target]] == parents[parents[i]])
					result++;
			}
			bw.write(result + "\n");
		}
		bw.close();
	}

	/* 각 노드의 부모를 구하는 메서드 */
	static void getParent() {
		parents[0] = -1;

		int currentParent = 0;

		for (int i = 2; i < N; i++) {

			if (nodes[i] - nodes[i - 1] == 1) {
				parents[i - 1] = currentParent;
			} else {
				parents[i - 1] = currentParent;
				currentParent++;
			}
		}
		parents[N - 1] = currentParent;
	}
}