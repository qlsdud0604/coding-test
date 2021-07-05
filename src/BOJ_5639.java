import java.io.*;
import java.util.*;

public class BOJ_5639 {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		void insert(int number) {
			if (number < this.data) {
				if (this.left == null)
					this.left = new Node(number);
				else
					this.left.insert(number);
			} else {
				if (this.right == null)
					this.right = new Node(number);
				else
					this.right.insert(number);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Node root = new Node(Integer.parseInt(br.readLine()));

		while (true) {
			String input = br.readLine();

			if (input == null || input.equals(""))
				break;

			root.insert(Integer.parseInt(input));
		}
		postOrder(root);
	}

	static void postOrder(Node root) {
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}
}
