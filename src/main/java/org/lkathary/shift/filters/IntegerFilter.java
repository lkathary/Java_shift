package org.lkathary.shift.filters;

import java.util.Optional;

public class IntegerFilter implements BaseFilter<Integer> {

    @Override
    public Optional<Integer> parse(String line) {
        try {
            return Optional.of(Integer.parseInt(line));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }
}

