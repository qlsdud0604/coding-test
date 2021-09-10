import java.util.*;

public class Solution01 {
	static int[] notClear; // ���������� ���������� ���� Ŭ�������� ���� �÷��̾� ��
	static int[] players; // �� ���������� ������ �÷��̾� ��
	static double[] failRate; // �� ���������� ������

	static ArrayList<stageInfo> list = new ArrayList<>();

	public int[] solution(int N, int[] stages) {
		notClear = new int[N + 2];
		players = new int[N + 2];
		failRate = new double[N + 1];

		/* ���������� ���������� ���� Ŭ�������� ���� �÷��̾� �� ��� */
		for (int i = 0; i < stages.length; i++) {
			notClear[stages[i]]++;
			players[stages[i]]++;
		}

		/* �� ���������� ������ �÷��̾� �� */
		for (int i = players.length - 2; i >= 1; i--) {
			players[i] += players[i + 1];
		}

		/* �� ���������� ������ ��� */
		for (int i = 1; i < failRate.length; i++) {
			failRate[i] = (double) notClear[i] / (double) players[i];

			list.add(new stageInfo(i, failRate[i]));
		}

		Collections.sort(list);

		int[] answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++)
			answer[i] = list.get(i).stage;

		return answer;
	}

	/* �� ���������� ������ ���� */
	static class stageInfo implements Comparable<stageInfo> {
		int stage;
		double failRate;

		stageInfo(int stage, double failRate) {
			this.stage = stage;
			this.failRate = failRate;
		}

		@Override
		public int compareTo(stageInfo o) {
			if (this.failRate < o.failRate)
				return 1;
			else if (this.failRate > o.failRate)
				return -1;
			else {
				if (this.stage < o.stage)
					return -1;
				else
					return 1;

			}
		}
	}
}
