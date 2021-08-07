import java.io.*;
import java.util.*;

public class BOJ_1946 {
	static int T;
	static int N;

	static Person[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());

			arr = new Person[N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				int test01 = Integer.parseInt(st.nextToken());
				int test02 = Integer.parseInt(st.nextToken());

				arr[j] = new Person(test01, test02);
			}

			Arrays.sort(arr);

			bw.write(function() + "\n");
		}
		bw.close();
	}

	static int function() {
		int result = 0;

		int currentTest02 = arr[0].test02;

		for (int i = 1; i < N; i++) {
			if (currentTest02 < arr[i].test02)
				result++;
			else {
				currentTest02 = arr[i].test02;
			}
		}

		return N - result;
	}

	static class Person implements Comparable<Person> {
		int test01;
		int test02;

		Person(int test01, int test02) {
			this.test01 = test01;
			this.test02 = test02;
		}

		@Override
		public int compareTo(Person o) {

			return this.test01 - o.test01;
		}
	}

}
