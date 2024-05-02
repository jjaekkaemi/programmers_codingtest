import java.util.*;

class Solution {
    // 주차 시간 계산 메서드
    private int calculateParkingTime(String inTime, String outTime) {
        String[] inTimeSplit = inTime.split(":");
        String[] outTimeSplit = outTime.split(":");

        int inHour = Integer.parseInt(inTimeSplit[0]);
        int inMinute = Integer.parseInt(inTimeSplit[1]);
        int outHour = Integer.parseInt(outTimeSplit[0]);
        int outMinute = Integer.parseInt(outTimeSplit[1]);

        if (outMinute < inMinute) {
            outHour--;
            outMinute += 60;
        }
        return (outHour - inHour) * 60 + (outMinute - inMinute);
    }

    public int[] solution(int[] fees, String[] records) {
        // 주차 요금 관련 정보
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        // 주차 기록을 저장할 Map
        Map<String, String> parkingRecords = new HashMap<>();
        // 차량별 주차 요금을 저장할 Map
        Map<String, Integer> parkingFees = new TreeMap<>();

        // 주차 기록 처리
        for (String record : records) {
            String[] parts = record.split(" ");
            String carNumber = parts[1];
            String time = parts[0];
            String status = parts[2];

            if (status.equals("IN")) {
                parkingRecords.put(carNumber, time);
            } else {
                String inTime = parkingRecords.remove(carNumber);
                int parkingTime = calculateParkingTime(inTime, time);
                parkingFees.put(carNumber, parkingFees.getOrDefault(carNumber, 0) + parkingTime);
            }
        }

        // 아직 주차 중인 차량의 주차 요금 계산
        for (String carNumber : parkingRecords.keySet()) {
            String inTime = parkingRecords.get(carNumber);
            int parkingTime = calculateParkingTime(inTime, "23:59");
            parkingFees.put(carNumber, parkingFees.getOrDefault(carNumber, 0) + parkingTime);
        }

        // 각 차량별 주차 요금 계산
        int[] answer = new int[parkingFees.size()];
        int index = 0;
        for (String carNumber : parkingFees.keySet()) {
            int parkingTime = parkingFees.get(carNumber);
            int totalFee = basicFee;
            if (parkingTime > basicTime) {
                totalFee += (int) Math.ceil((parkingTime - basicTime) / (float) unitTime) * unitFee;
            }
            answer[index++] = totalFee;
        }

        return answer;
    }
}
