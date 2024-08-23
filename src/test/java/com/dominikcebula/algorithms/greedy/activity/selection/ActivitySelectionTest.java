package com.dominikcebula.algorithms.greedy.activity.selection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.dominikcebula.algorithms.greedy.activity.selection.ActivitySelection.Activity;
import static org.assertj.core.api.Assertions.assertThat;

class ActivitySelectionTest {
    private final ActivitySelection activitySelection = new ActivitySelection();

    private static Stream<Arguments> activitySelectionCases() {
        return Stream.of(
                Arguments.of(new Activity[]{}, 0),
                Arguments.of(new Activity[]{new Activity(1, 6)}, 1)
                Arguments.of(new Activity[]{new Activity(1, 6), new Activity(3, 7)}, 1),
                Arguments.of(new Activity[]{new Activity(1, 6), new Activity(3, 8)}, 1),
                Arguments.of(new Activity[]{new Activity(1, 3), new Activity(3, 6)}, 1),
                Arguments.of(new Activity[]{new Activity(1, 3), new Activity(4, 6)}, 2),
                Arguments.of(new Activity[]{new Activity(1, 2), new Activity(3, 4), new Activity(5, 6)}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("activitySelectionCases")
    void shouldFindMaxNumberOfAttendedActivities(Activity[] activities, int expectedMaxNumberOfAttendedActivities) {
        int maxNumberOfAttendedActivities = activitySelection.findMaxNumberOfAttendedActivities(activities);

        assertThat(maxNumberOfAttendedActivities)
                .isEqualTo(expectedMaxNumberOfAttendedActivities);
    }
}