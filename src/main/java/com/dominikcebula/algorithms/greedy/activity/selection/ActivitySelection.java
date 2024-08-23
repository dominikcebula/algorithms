package com.dominikcebula.algorithms.greedy.activity.selection;

import java.util.Arrays;

public class ActivitySelection {
    public int findMaxNumberOfAttendedActivities(Activity[] activities) {
        Arrays.sort(activities);

        int lastActivityEndTime = -1;
        int numberOfActivitiesTaken = 0;

        for (Activity activity : activities) {
            if (activity.startTime() > lastActivityEndTime) {
                lastActivityEndTime = activity.endTime();
                ++numberOfActivitiesTaken;
            }
        }

        return numberOfActivitiesTaken;
    }

    record Activity(int startTime, int endTime) implements Comparable<Activity> {
        @Override
        public int compareTo(Activity other) {
            return endTime() - other.endTime();
        }
    }
}
