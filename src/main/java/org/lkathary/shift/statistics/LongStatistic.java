package org.lkathary.shift.statistics;

import org.lkathary.shift.models.CommandLine;
import org.lkathary.shift.models.TypeStatistic;

public class LongStatistic extends BaseStatistic<Long> {

    private long sum = 0L;
    private long min;
    private long max;

    @Override
    public void add(Long value) {
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
    public void show(TypeStatistic typeStatistic) {
        if (typeStatistic == TypeStatistic.SHORT_STATISTIC) {
            System.out.println("->\nShort statistic for floats: " + count + " records");
        }
        if (typeStatistic == TypeStatistic.FULL_STATISTIC) {
            System.out.println("->\nFull statistic for floats: " + count + " records");
            if (count > 0) {
                System.out.println("Sum: " + sum + " Min: " + min + " Max: " + max
                        + " Average: " + (double) sum / count);
            } else {
                System.out.println("Statistic is not available");
            }
        }
    }
}
