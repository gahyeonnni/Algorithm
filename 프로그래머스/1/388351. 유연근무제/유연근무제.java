import java.util.*;

class Solution {
    public int solution(int[] schedule, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedule.length; i++) {
            int a = schedule[i] / 100;
            int b = schedule[i] % 100; 

            b += 10;
            if (b >= 60) {
                a += 1;
                b %= 60;
            }
            schedule[i] = a * 100 + b;
        }

        for (int i = 0; i < timelogs.length; i++) {
            int[] x = timelogs[i]; 
            boolean check = true;

            if (startday == 1) { // 월요일
                for (int j = 0; j < 5; j++) {
                    if (schedule[i] < x[j]) {
                        check = false;
                        break;
                    }
                }
            } else if (startday == 2) { // 화요일
                for (int j = 0; j < 4; j++) {
                    if (schedule[i] < x[j]) {
                        check = false;
                        break;
                    }
                }
                if (check && schedule[i] < x[6]) check = false;
            } else if (startday == 3) { // 수요일
                for (int j = 0; j < 3; j++) {
                    if (schedule[i] < x[j]) {
                        check = false;
                        break;
                    }
                }
                if (check && (schedule[i] < x[5] || schedule[i] < x[6])) check = false;
            } else if (startday == 4) { // 목요일
                for (int j = 4; j < 7; j++) {
                    if (schedule[i] < x[j]) {
                        check = false;
                        break;
                    }
                }
                if (check && (schedule[i] < x[0] || schedule[i] < x[1])) check = false;
            } else if (startday == 5) { // 금요일
                for (int j = 3; j < 7; j++) {
                    if (schedule[i] < x[j]) {
                        check = false;
                        break;
                    }
                }
                if (check && schedule[i] < x[0]) check = false;
            } else if (startday == 6) { // 토요일
                for (int j = 2; j < 7; j++) {
                    if (schedule[i] < x[j]) {
                        check = false;
                        break;
                    }
                }
            } else if (startday == 7) { // 일요일
                for (int j = 1; j < 6; j++) {
                    if (schedule[i] < x[j]) {
                        check = false;
                        break;
                    }
                }
            }

            if (check) answer++;
        }

        return answer;
    }
}
