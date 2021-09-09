import java.util.*;

public class Solution12 {
	static Node root = new Node();

	public int solution(String[] words) {
		int answer = 0;

		for (String word : words) {
			insert(word);
		}

		for (String word : words) {
			answer += getCount(word);
		}

		return answer;
	}

	/* 트라이에 단어들을 삽입 */
	static void insert(String word) {
		Node currentNode = root; // 루트 노드부터 시작

		for (int i = 0; i < word.length(); i++) {
			Node childrenNode = currentNode.put(word.charAt(i));
			childrenNode.count++;

			currentNode = childrenNode;
		}
	}

	/* 트라이에서 입력 문자수 계산 */
	static int getCount(String word) {
		Node currentNode = root; // 루트 노드부터 시작

		int count = 0;

		for (int i = 0; i < word.length(); i++) {
			Node childrenNode = currentNode.children.get(word.charAt(i));

			count++;

			if (childrenNode.count == 1)
				return count;

			currentNode = childrenNode;
		}

		return count;
	}

	/* 트라이를 구성하는 노드 정보를 정의 */
	static class Node {
		HashMap<Character, Node> children;
		int count;

		public Node() {
			this.children = new HashMap<>();
			this.count = 0;
		}

		Node put(char c) {
			if (!children.containsKey(c))
				children.put(c, new Node());

			return children.get(c);
		}
	}
}