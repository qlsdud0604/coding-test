import java.io.*;
import java.util.*;

public class BOJ_11000 {
	static int N;
	static Class[] classes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		classes = new Class[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());

			classes[i] = new Class(start, finish);
		}

		Arrays.sort(classes);

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(classes[0].finish);

		for (int i = 1; i < N; i++) {
			if (queue.peek() <= classes[i].start) {
				queue.poll();
			}
			
			queue.add(classes[i].finish);
		}

		return queue.size();
	}

	static class Class implements Comparable<Class> {
		int start;
		int finish;

		Class(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}

		@Override
		public int compareTo(Class o) {
			if (this.start == o.start)
				return this.finish - o.finish;

			return this.start - o.start;
		}

	}

}
