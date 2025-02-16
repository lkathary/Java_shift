package org.lkathary.shift.models;

import com.beust.jcommander.Parameter;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class CommandLine {
    @Parameter(description = "files")
    private List<String> files = new ArrayList<>();

    @Parameter(names = "-o", description = "Path for results", order = 1)
    private String path;

    @Parameter(names = "-p", description = "Output filenames prefix", order = 2)
    private String prefix;

    @Parameter(names = "-a", description = "Append mode for output files", order = 3)
    private Boolean append = false;

    @Parameter(names = "-s", description = "Get short statistics", order = 4)
    private Boolean shortStat = false;

    @Parameter(names = "-f", description = "Get full statistics", order = 5)
    private Boolean fullStat = false;

}
