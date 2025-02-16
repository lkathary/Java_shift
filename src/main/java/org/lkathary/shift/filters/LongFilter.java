package org.lkathary.shift.filters;

import java.util.Optional;

public class LongFilter implements BaseFilter<Long> {

    @Override
    public Optional<Long> parse(String line) {
        try {
            return Optional.of(Long.parseLong(line));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }
}
