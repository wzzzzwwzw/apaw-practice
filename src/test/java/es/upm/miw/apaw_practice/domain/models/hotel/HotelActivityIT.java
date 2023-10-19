package es.upm.miw.apaw_practice.domain.models.hotel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelActivityIT {
    @Test
    void testHotelActivitiesTreeComposite() {
        HotelActivityComposite activityComposite = new HotelActivityComposite("Water sports");
        Assertions.assertTrue(activityComposite.isComposite());

        HotelActivity activity = new HotelActivity("Water Polo", "L 16:00, X 16:00, V 16:00", "Steve", 10);
        activityComposite.add(activity);
        Assertions.assertEquals(1, activityComposite.getTreeActivities().size());

        activityComposite.remove(activity);
        Assertions.assertEquals(0, activityComposite.getTreeActivities().size());
    }

    @Test
    void testHotelActivitiesTreeLeaf() {
        HotelActivity activity = new HotelActivity("Water Polo", "L 16:00, X 16:00, V 16:00", "Steve", 10);
        Assertions.assertFalse(activity.isComposite());

        Assertions.assertThrows(UnsupportedOperationException.class, () -> activity.add(activity));
    }
}
