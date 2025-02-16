package org.lkathary.shift;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.lkathary.shift.models.CommandLine;
import org.lkathary.shift.models.Params;
import org.lkathary.shift.models.Solution;

public class Application {
    public static void main(String[] args) {

        CommandLine commandLine = new CommandLine();
        JCommander jc = JCommander.newBuilder()
                .addObject(commandLine)
                .build();
        jc.setProgramName("java -jar util.jar");
        try {
            jc.parse(args);
            if(args.length == 0) {
                jc.usage();
                System.exit(2);
            } else if(commandLine.getFullStat() && commandLine.getShortStat()) {
                System.err.println("-s and -f options are mutually exclusive");
                jc.usage();
                System.exit(2);
            }
        } catch (ParameterException ex) {
            System.err.println("Unexpected error occurred: " + ex.getMessage());
            jc.usage();
            System.exit(2);
        }

        Solution solution = new Solution(new Params(commandLine));
        commandLine.getFiles().forEach(solution::fileProcessor);
        solution.showStatistics();
        solution.deleteEmptyFiles();
    }
}
