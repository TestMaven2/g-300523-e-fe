package lesson8.activities;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Activity> activities = new ArrayList<>();

        activities.add(new Activity("a", 1, 3));
        activities.add(new Activity("b", 1, 7));
        activities.add(new Activity("c", 2, 4));
        activities.add(new Activity("d", 5, 9));
        activities.add(new Activity("e", 4, 6));
        activities.add(new Activity("f", 7, 8));

        printActivities(activities);
    }

    public static void printActivities(List<Activity> activities) {
        System.out.println("Исходный список:        " + activities);
        activities.sort((x, y) -> x.getFinish() - y.getFinish());
        System.out.println("Отсортированный список: " + activities);

        List<Activity> result = new ArrayList<>();
        Activity firstActivity = activities.get(0);
        result.add(firstActivity);
        int finish = firstActivity.getFinish();

        for (int i = 1; i < activities.size(); i++) {
            Activity currentActivity = activities.get(i);
            if (currentActivity.getStart() >= finish) {
                result.add(currentActivity);
                finish = currentActivity.getFinish();
            }
        }

        System.out.println("Результат: " + result);
    }

    // 1 -> 3   4 -> 6   7 -> 8
}