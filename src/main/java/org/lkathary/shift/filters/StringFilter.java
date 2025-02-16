package org.lkathary.shift.filters;

import java.util.Optional;

public class StringFilter implements BaseFilter<String> {

    @Override
    public Optional<String> parse(String line) {
        return Optional.of(line);
    }
}

