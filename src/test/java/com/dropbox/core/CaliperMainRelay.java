package com.dropbox.core;

import com.google.caliper.config.InvalidConfigurationException;
import com.google.caliper.runner.CaliperMain;
import com.google.caliper.runner.InvalidBenchmarkException;
import com.google.caliper.util.InvalidCommandException;

import java.io.PrintWriter;

/**
 * This class can be removed if Google Caliper ever does a Maven release
 * past 1.0-beta-1.
 */
public class CaliperMainRelay
{
    /**
     * This is just a copy of CaliperMain.main method.  In the Caliper source repo, that
     * method is public, but in the version of Caliper on Maven (1.0-beta-1), it's marked
     * package private, so we can't run it directly from the command line.
     */
    public static void main(String[] args)
    {
        PrintWriter stdout = new PrintWriter(System.out, true);
        PrintWriter stderr = new PrintWriter(System.err, true);
        int code = 1; // pessimism!

        try {
            CaliperMain.exitlessMain(args, stdout, stderr);
            code = 0;

        } catch (InvalidCommandException e) {
            e.display(stderr);
            code = e.exitCode();

        } catch (InvalidBenchmarkException e) {
            e.display(stderr);

        } catch (InvalidConfigurationException e) {
            e.display(stderr);

        } catch (Throwable t) {
            t.printStackTrace(stderr);
            stdout.println();
            stdout.println("An unexpected exception has been thrown by the caliper runner.");
            stdout.println("Please see https://sites.google.com/site/caliperusers/issues");
        }

        stdout.flush();
        stderr.flush();
        System.exit(code);
    }
}
