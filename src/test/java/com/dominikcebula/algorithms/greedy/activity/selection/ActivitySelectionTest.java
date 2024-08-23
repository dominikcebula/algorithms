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
                Arguments.of(new Activity[]{}, 0)
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