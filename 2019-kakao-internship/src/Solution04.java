import java.util.*;

class Solution04 {
	static Map<Long, Long> map = new HashMap<Long, Long>(); // <���� �� ��ȣ, ���� �� ��ȣ>�� ���·� ����

	public long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];

		for (int i = 0; i < room_number.length; i++) {
			long roomNumber = room_number[i];

			answer[i] = findRoomNumber(roomNumber);
		}

		return answer;
	}

	static long findRoomNumber(long roomNumber) {

		/** map�� ���� �� ��ȣ�� ������ �� �� ���(���� ���� ���� ���� �� ��ȣ) */
		if (!map.containsKey(roomNumber)) {
			map.put(roomNumber, roomNumber + 1);
			return roomNumber;
		}

		/** map�� ���� �� ��ȣ�� ������ �� ���(�̹� ���������� ������ �� ��ȣ) */
		long nextRoomNumber = map.get(roomNumber);
		long emptyRoomNumber = findRoomNumber(nextRoomNumber);
		map.put(roomNumber, emptyRoomNumber);

		return emptyRoomNumber;
	}
}