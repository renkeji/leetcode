package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 *
 * Each LED represents a zero or one, with the least significant bit on the right.
 *
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 *
 * Example:
 *
 *  Input: n = 1
 *  Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 * Note:
 *  1. The order of output does not matter.
 *  2. The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 *  3. The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 */

public class Q401 extends Solution {

    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        if (num >= 0 && num <= 10) {
            for (int i = 0; i <= Math.min(4, num); ++i) {
                List<String> hours = new ArrayList<>();
                getHours(i, 0, 0, hours);
                List<String> minutes = new ArrayList<>();
                getMinutes(num - i, 0, 0, minutes);
                for (String hour :  hours) {
                    for (String minute : minutes) {
                        ans.add(hour + ":" + minute);
                    }
                }
            }
        }
        return ans;
    }

    private void getHours(int num, int index, int hour, List<String> hours) {
        if (num == 0) {
            hours.add(String.valueOf(hour));
        } else {
            for (int i = index; i < 4; ++i) {
                int h = hour + (1 << i);
                if (h <= 11) {
                    getHours(num - 1, i + 1, h, hours);
                }
            }
        }
    }

    private void getMinutes(int num, int index, int minute, List<String> minutes) {
        if (num == 0) {
            String one = String.valueOf(minute);
            one = one.length() == 2 ? one : "0" + one;
            minutes.add(one);
        } else {
            for (int i = index; i < 6; ++i) {
                int m = minute + (1 << i);
                if (m <= 59) {
                    getMinutes(num - 1, i + 1, m, minutes);
                }
            }
        }
    }

}
