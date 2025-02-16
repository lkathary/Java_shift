package org.lkathary.shift.filters;

import java.util.Optional;

public class FloatFilter implements BaseFilter<Float> {

    @Override
    public Optional<Float> parse(String line) {
        try {
            return Optional.of(Float.parseFloat(line));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }
}
