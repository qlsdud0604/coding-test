import java.util.*;

class Solution02 {
	static HashMap<String, String> map = new HashMap<>();
	static ArrayList<String> list = new ArrayList<>();

	public String[] solution(String[] record) {

		for (int i = 0; i < record.length; i++) {
			String[] input = record[i].split(" ");

			switch (input[0]) {

			case "Enter":
				map.put(input[1], input[2]);
				list.add("Enter" + " " + input[1]);
				break;

			case "Leave":
				list.add("Leave" + " " + input[1]);
				break;

			case "Change":
				map.put(input[1], input[2]);
				break;
			}
		}

		String[] answer = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			String[] input = list.get(i).split(" ");

			switch (input[0]) {
			case "Enter":
				answer[i] = map.get(input[1]) + "���� ���Խ��ϴ�.";
				break;

			case "Leave":
				answer[i] = map.get(input[1]) + "���� �������ϴ�.";
				break;
			}
		}

		return answer;
	}

}