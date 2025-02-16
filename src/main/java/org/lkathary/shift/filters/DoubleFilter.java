package org.lkathary.shift.filters;

import java.util.Optional;

public class DoubleFilter implements BaseFilter<Double> {

    @Override
    public Optional<Double> parse(String line) {
        try {
            return Optional.of(Double.parseDouble(line));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }
}

