package com.dominikcebula.algorithms.greedy.activity.selection;

import java.util.Arrays;

public class ActivitySelection {
    public int findMaxNumberOfAttendedActivities(Activity[] activities) {
        Arrays.sort(activities);

        return 0;
    }

    record Activity(int startTime, int endTime) implements Comparable<Activity> {
        @Override
        public int compareTo(Activity other) {
            return startTime() - other.endTime();
        }
    }
}
