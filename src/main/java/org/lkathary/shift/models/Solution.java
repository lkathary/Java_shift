package org.lkathary.shift.models;

import org.lkathary.shift.filters.BaseFilter;
import org.lkathary.shift.filters.BigIntegerFilter;
import org.lkathary.shift.filters.DoubleFilter;
import org.lkathary.shift.filters.StringFilter;
import org.lkathary.shift.statistics.BaseStatistic;
import org.lkathary.shift.statistics.BigIntegerStatistic;
import org.lkathary.shift.statistics.DoubleStatistic;
import org.lkathary.shift.statistics.StringStatistic;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


public class Solution {

    private final Charset CHAR_SET = StandardCharsets.UTF_8;        // UTF-8
//    private final Charset CHAR_SET = StandardCharsets.ISO_8859_1; // ANSI

    private final Params params;

    BaseFilter<BigInteger> bigIntegerFilter = new BigIntegerFilter();
    BaseFilter<Double> doubleFilter = new DoubleFilter();
    BaseFilter<String> stringFilter = new StringFilter();

    BaseStatistic<BigInteger> bigIntegerStatistic = new BigIntegerStatistic();
    BaseStatistic<Double> doubleStatistic = new DoubleStatistic();
    BaseStatistic<String> stringStatistic = new StringStatistic();

    public Solution(Params params) {
        this.params = params;
    }

    public void fileProcessor(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName, CHAR_SET));
             BufferedWriter integerWriter = new BufferedWriter(
                     new FileWriter(params.getIntegerFile(), params.isAppend()));
             BufferedWriter floatWriter = new BufferedWriter(
                     new FileWriter(params.getFloatFile(), params.isAppend()));
             BufferedWriter stringWriter = new BufferedWriter(
                     new FileWriter(params.getStringFile(), CHAR_SET, params.isAppend()))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Optional<?> res;
                if ((res = bigIntegerFilter.parse(line)).isPresent()) {
                    integerWriter.write(res.get() + System.lineSeparator());
                    bigIntegerStatistic.add((BigInteger) res.get());
                } else if ((res = doubleFilter.parse(line)).isPresent()) {
                    floatWriter.write(res.get() + System.lineSeparator());
                    doubleStatistic.add((Double) res.get());
                } else if ((res = stringFilter.parse(line)).isPresent()) {
                    stringWriter.write(res.get() + System.lineSeparator());
                    stringStatistic.add(line);
                }
            }
            params.setAppend(true);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public void deleteEmptyFiles() {
        try {
            Path path = Paths.get(params.getIntegerFile());
            if (Files.exists(path) && Files.size(path) == 0) {
                Files.delete(path);
            }
        } catch (IOException e) {
            System.err.println("Cannot delete file: " + params.getIntegerFile());
        }
        try {
            Path path = Paths.get(params.getFloatFile());
            if (Files.exists(path) && Files.size(path) == 0) {
                Files.delete(path);
            }
        } catch (IOException e) {
            System.err.println("Cannot delete file: " + params.getFloatFile());
        }
        try {
            Path path = Paths.get(params.getStringFile());
            if (Files.exists(path) && Files.size(path) == 0) {
                Files.delete(path);
            }
        } catch (IOException e) {
            System.err.println("Cannot delete file: " + params.getStringFile());
        }
    }

    public void showStatistics() {
        bigIntegerStatistic.show(params.getTypeStatistic());
        doubleStatistic.show(params.getTypeStatistic());
        stringStatistic.show(params.getTypeStatistic());
    }

}
