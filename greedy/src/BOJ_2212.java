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

		/** �� ���� ���� �Ÿ� ���� ��� */
		for (int i = 1; i < N; i++)
			diff[i - 1] = arr[i] - arr[i - 1];

		/** �� ������ �Ÿ� ���� ����� �迭�� �������� ���� */
		Arrays.sort(diff, Collections.reverseOrder());

		/** ���� ���� �Ÿ� ���̸� �ǳʶٰ� �� ��� */
		int result = 0;

		for (int i = K - 1; i < diff.length; i++)
			result += diff[i];

		return result;
	}

}
