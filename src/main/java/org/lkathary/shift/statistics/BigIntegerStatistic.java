package org.lkathary.shift.statistics;

import org.lkathary.shift.models.CommandLine;
import org.lkathary.shift.models.TypeStatistic;

import java.math.BigInteger;

public class BigIntegerStatistic extends BaseStatistic<BigInteger> {

    private BigInteger sum = BigInteger.ZERO;
    private BigInteger min;
    private BigInteger max;

    @Override
    public void add(BigInteger value) {
        if (count == 0) {
            min = max = value;
        } else {
            min = min.min(value);
            max = max.max(value);
        }
        sum = sum.add(value);
        count++;
    }

    @Override
    public void show(TypeStatistic typeStatistic) {
        if (typeStatistic == TypeStatistic.SHORT_STATISTIC) {
            System.out.println("->\nShort statistic for integers: " + count + " records");
        }
        if (typeStatistic == TypeStatistic.FULL_STATISTIC) {
            System.out.println("->\nFull statistic for integers: " + count + " records");
            if (count > 0) {
                System.out.println("Sum: " + sum + " Min: " + min + " Max: " + max
                        + " Average: " + sum.doubleValue() / count);
            } else {
                System.out.println("Statistic is not available");
            }
        }
    }
}
