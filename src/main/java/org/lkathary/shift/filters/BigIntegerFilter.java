package org.lkathary.shift.filters;

import java.math.BigInteger;
import java.util.Optional;

public class BigIntegerFilter implements BaseFilter<BigInteger> {

    @Override
    public Optional<BigInteger> parse(String line) {
        try {
            return Optional.of(new BigInteger(line));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }
}
