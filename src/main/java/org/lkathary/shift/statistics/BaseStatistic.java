package org.lkathary.shift.statistics;

import lombok.Getter;
import org.lkathary.shift.models.CommandLine;
import org.lkathary.shift.models.TypeStatistic;


@Getter
public abstract class BaseStatistic<T>  {

    protected Long count = 0L;

    public abstract void add(T value);

    public abstract void show(TypeStatistic type);
}
