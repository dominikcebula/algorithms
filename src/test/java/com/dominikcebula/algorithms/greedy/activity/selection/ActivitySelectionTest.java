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
                Arguments.of(new Activity[]{new Activity(1, 6)}, 1),
                Arguments.of(new Activity[]{new Activity(1, 6), new Activity(3, 7)}, 1),
                Arguments.of(new Activity[]{new Activity(1, 6), new Activity(3, 8)}, 1),
                Arguments.of(new Activity[]{new Activity(1, 3), new Activity(3, 6)}, 1),
                Arguments.of(new Activity[]{new Activity(1, 3), new Activity(4, 6)}, 2),
                Arguments.of(new Activity[]{
                        new Activity(1, 2),
                        new Activity(3, 4),
                        new Activity(5, 6)
                }, 3),
                Arguments.of(new Activity[]{
                        new Activity(2, 4),
                        new Activity(6, 8),
                        new Activity(5, 9)
                }, 2),
                Arguments.of(new Activity[]{
                        new Activity(2, 9),
                        new Activity(12, 13),
                        new Activity(1, 5),
                        new Activity(2, 4),
                        new Activity(6, 7),
                        new Activity(9, 10),
                        new Activity(2, 6),
                        new Activity(8, 9),
                }, 4),
                Arguments.of(new Activity[]{
                        new Activity(1, 2),
                        new Activity(3, 4),
                        new Activity(5, 6),
                        new Activity(7, 8),
                        new Activity(9, 10),
                        new Activity(11, 12),
                        new Activity(13, 14),
                        new Activity(15, 16),
                }, 8),
                Arguments.of(new Activity[]{
                        new Activity(1, 3),
                        new Activity(3, 5),
                        new Activity(5, 7),
                        new Activity(7, 9),
                        new Activity(9, 11),
                        new Activity(11, 13),
                        new Activity(13, 15),
                        new Activity(15, 16),
                }, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("activitySelectionCases")
    void shouldFindMaxNumberOfActivitiesPossibleToAttend(Activity[] activities, int expectedMaxNumberOfAttendedActivities) {
        int maxNumberOfAttendedActivities = activitySelection.findMaxNumberOfActivitiesPossibleToAttend(activities);

        assertThat(maxNumberOfAttendedActivities)
                .isEqualTo(expectedMaxNumberOfAttendedActivities);
    }
}