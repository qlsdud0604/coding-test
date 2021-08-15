import java.io.*;
import java.util.*;

public class BOJ_2212 {
	static int N;
	static int K;
	static int[] arr;
	static Integer[] diff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {

		if (N <= K)
			return 0;

		diff = new Integer[N - 1];

		/** 각 센서 간의 거리 차이 계산 */
		for (int i = 1; i < N; i++)
			diff[i - 1] = arr[i] - arr[i - 1];

		/** 각 센서의 거리 차를 계산한 배열을 내림차순 정렬 */
		Arrays.sort(diff, Collections.reverseOrder());

		/** 가장 많은 거리 차이를 건너뛰고 합 계산 */
		int result = 0;

		for (int i = K - 1; i < diff.length; i++)
			result += diff[i];

		return result;
	}

}
