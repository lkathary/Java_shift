package org.lkathary.shift.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Params {

    @Setter
    private boolean append;

    private final String integerFile;

    private final String floatFile;

    private final String stringFile;

    private final TypeStatistic typeStatistic;

    private final List<String> fileList;

    public Params(CommandLine args) {

        append = args.getAppend();
        integerFile = (args.getPath() != null ? args.getPath() + '/' : "") +
                (args.getPrefix() != null ? args.getPrefix() : "") +
                TypeFile.INTEGER_FILE.getTitle();
        floatFile = (args.getPath() != null ? args.getPath() + '/' : "") +
                (args.getPrefix() != null ? args.getPrefix() : "") +
                TypeFile.FLOAT_FILE.getTitle();
        stringFile = (args.getPath() != null ? args.getPath() + '/' : "") +
                (args.getPrefix() != null ? args.getPrefix() : "") +
                TypeFile.STRING_FILE.getTitle();

        typeStatistic = args.getFullStat() ? TypeStatistic.FULL_STATISTIC : TypeStatistic.SHORT_STATISTIC;
        fileList = args.getFiles();
    }

}
