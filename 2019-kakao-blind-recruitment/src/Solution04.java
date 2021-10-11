import java.util.*;

class Solution04 {
	static Data[] nodeArr;

	static int[][] answer;

	static ArrayList<Integer> preList = new ArrayList<>();
	static ArrayList<Integer> postList = new ArrayList<>();

	public int[][] solution(int[][] nodeinfo) {
		nodeArr = new Data[nodeinfo.length];

		answer = new int[2][nodeArr.length];

		for (int i = 0; i < nodeinfo.length; i++) {
			nodeArr[i] = new Data((i + 1), nodeinfo[i][0], nodeinfo[i][1]);
		}

		Arrays.sort(nodeArr);

		/** 트리의 구성 */
		Node root = new Node(nodeArr[0]);

		for (int i = 1; i < nodeArr.length; i++) {
			Data data = nodeArr[i];

			root.insert(data);
		}

		preOrder(root);
		postOrder(root);

		for (int i = 0; i < nodeArr.length; i++) {
			answer[0][i] = preList.get(i);
			answer[1][i] = postList.get(i);
		}

		return answer;
	}

	/** 트리를 구성하는 노드에 대한 정보를 정의 */
	static class Node {
		Data data;
		Node left;
		Node right;

		Node(Data data) {
			this.data = data;
		}

		void insert(Data another) {
			if (another.x < this.data.x) {
				if (this.left == null)
					this.left = new Node(another);
				else
					this.left.insert(another);
			} else {
				if (this.right == null)
					this.right = new Node(another);
				else
					this.right.insert(another);
			}
		}
	}

	/** 노드가 가지는 정보를 정의 */
	static class Data implements Comparable<Data> {
		int number;
		int x;
		int y;

		Data(int number, int x, int y) {
			this.number = number;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Data o) {
			return o.y - this.y;
		}
	}

	/** 전위 순회 */
	static void preOrder(Node root) {
		if (root == null)
			return;

		preList.add(root.data.number);
		preOrder(root.left);
		preOrder(root.right);
	}

	/** 후위 순회 */
	static void postOrder(Node root) {
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		postList.add(root.data.number);
	}
}