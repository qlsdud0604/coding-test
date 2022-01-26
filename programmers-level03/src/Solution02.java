import java.io.*;
import java.util.*;

public class Solution02 {

	static Node[] nodes;

	public int solution(String begin, String target, String[] words) {
		/** 그래프 생성 */
		nodes = new Node[words.length + 1];

		nodes[0] = new Node(begin);

		for (int i = 1; i < nodes.length; i++) {
			nodes[i] = new Node(words[i - 1]);
		}

		/** 간선 연결 */
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes.length; j++) {
				if (compare(nodes[i].word, nodes[j].word) && !nodes[i].word.equals(nodes[j].word)) {
					nodes[i].adjacents.add(nodes[j]);
					nodes[j].adjacents.add(nodes[i]);
				}
			}
		}

		return bfs(0, target);
	}

	/** 두 개의 단어를 비교하는 메서드 */
	static boolean compare(String current, String word) {
		int count = 0;

		for (int i = 0; i < current.length(); i++) {
			if (current.charAt(i) != word.charAt(i))
				count++;
		}

		if (count == 1)
			return true;
		else
			return false;
	}

	/** bfs 알고리즘을 이용해서 target 단어를 탐색하는 메서드 */
	static int bfs(int start, String target) {
		int count = 0;

		Queue<Node> queue = new LinkedList<>();

		nodes[start].visited = true;

		queue.add(nodes[start]);

		while (!queue.isEmpty()) {

			Node node = queue.poll();

			if (node.word.equals(target))
				return node.depth;

			for (Node next : node.adjacents) {
				if (next.visited == false) {
					next.visited = true;
					next.depth = node.depth + 1;

					queue.add(next);
				}
			}
		}

		return 0;
	}

	/** 그래프를 구성하는 각 노드의 정보를 정의한 클래스 */
	static class Node {
		String word;
		List<Node> adjacents;
		boolean visited;
		int depth;

		Node(String word) {
			this.word = word;
			this.adjacents = new ArrayList<Node>();
			this.visited = false;
			this.depth = 0;
		}
	}

}