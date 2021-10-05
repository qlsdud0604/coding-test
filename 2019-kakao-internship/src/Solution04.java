import java.util.*;

class Solution04 {
	static Map<Long, Long> map = new HashMap<Long, Long>(); // <현재 방 번호, 다음 방 번호>의 형태로 저장

	public long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];

		for (int i = 0; i < room_number.length; i++) {
			long roomNumber = room_number[i];

			answer[i] = findRoomNumber(roomNumber);
		}

		return answer;
	}

	static long findRoomNumber(long roomNumber) {

		/** map에 현재 방 번호가 포함이 안 된 경우(아직 배정 받지 않은 방 번호) */
		if (!map.containsKey(roomNumber)) {
			map.put(roomNumber, roomNumber + 1);
			return roomNumber;
		}

		/** map에 현재 방 번호가 포함이 된 경우(이미 누군가에게 배정된 방 번호) */
		long nextRoomNumber = map.get(roomNumber);
		long emptyRoomNumber = findRoomNumber(nextRoomNumber);
		map.put(roomNumber, emptyRoomNumber);

		return emptyRoomNumber;
	}
}