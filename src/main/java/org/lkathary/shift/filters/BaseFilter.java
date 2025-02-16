package org.lkathary.shift.filters;

import java.util.Optional;

public interface BaseFilter<T> {

    Optional<T> parse(String line);
}
