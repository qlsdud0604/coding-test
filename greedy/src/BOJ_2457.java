import java.io.*;
import java.util.*;

public class BOJ_2457 {
	static int N;
	static Flower[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new Flower[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());

			arr[i] = new Flower(start, end);
		}

		Arrays.sort(arr);

		bw.write(function() + "\n");
		bw.close();
	}

	/** 최소 꽃 개수 계산 */
	static int function() {
		int result = 0;
		int max = 0;
		int current = 301;

		int index = 0;

		while (current < 1201) {

			boolean checked = false;

			for (int i = index; i < N; i++) {

				if (current < arr[i].start)
					break;

				if (arr[i].start <= current) {
					if (max < arr[i].end) {
						max = arr[i].end;
						index = i + 1;
						checked = true;
					}
				}
			}

			if (checked) {
				current = max;
				result++;
			} else
				break;
		}

		if (current < 1201)
			return 0;

		return result;
	}

	/** 꽃에 대한 정보 */
	static class Flower implements Comparable<Flower> {
		int start;
		int end;

		public Flower(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Flower o) {
			if (this.start == o.start)
				return this.end - o.end;

			return this.start - o.start;
		}

	}

}
