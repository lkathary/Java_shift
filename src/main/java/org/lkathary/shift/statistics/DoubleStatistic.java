package org.lkathary.shift.statistics;

import org.lkathary.shift.models.TypeStatistic;

public class DoubleStatistic extends BaseStatistic<Double> {

    private double sum = 0.0;
    private double min;
    private double max;

    @Override
    public void add(Double value) {
        if (count == 0) {
            min = max = value;
        } else {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        sum += value;
        count++;
    }

    @Override
    public void show(TypeStatistic  typeStatistic) {
        if (typeStatistic == TypeStatistic.SHORT_STATISTICS) {
            System.out.println("->\nShort statistic for floats: " + count + " records");
        }
        if (typeStatistic == TypeStatistic.FULL_STATISTICS) {
            System.out.println("->\nFull statistic for floats: " + count + " records");
            if (count > 0) {
                System.out.println("Sum: " + sum + " Min: " + min + " Max: " + max
                        + " Average: " + sum / count);
            } else {
                System.out.println("Statistic is not available");
            }
        }
    }
}
