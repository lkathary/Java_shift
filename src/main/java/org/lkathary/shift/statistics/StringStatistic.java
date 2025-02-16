package org.lkathary.shift.statistics;

import org.lkathary.shift.models.TypeStatistic;

public class StringStatistic extends BaseStatistic<String> {

    private int min;
    private int max;

    @Override
    public void add(String value) {
        if (count == 0) {
            min = max = value.length();
        } else {
            min = Math.min(min, value.length());
            max = Math.max(max, value.length());
        }
        count++;
    }

    @Override
    public void show(TypeStatistic typeStatistic) {
        if (typeStatistic == TypeStatistic.SHORT_STATISTICS) {
            System.out.println("->\nShort statistic for strings: " + count + " records");
        }
        if (typeStatistic == TypeStatistic.FULL_STATISTICS) {
            System.out.println("->\nFull statistic for strings: " + count + " records");
            if (count > 0) {
                System.out.println("Size of the longest string: " + max);
                System.out.println("Size of the shortest string: " + min);
            } else {
                System.out.println("Statistic is not available");
            }
        }
    }
}
