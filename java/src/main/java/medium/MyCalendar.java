package medium;

import java.util.*;

// https://leetcode.com/problems/my-calendar-i/description/?envType=daily-question&envId=2024-09-26
public class MyCalendar {
    private List<int[]> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] event : events) {
            if (event[0] < end && start < event[1]) {
                return false;
            }
        }
        events.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20)); // true
        System.out.println(calendar.book(15, 25)); // false
        System.out.println(calendar.book(20, 30)); // true
    }
}
