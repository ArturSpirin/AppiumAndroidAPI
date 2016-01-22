package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Artur Spirin on 1/21/16.
 **/
public class Utils {
    private static final String[] WIN_RUNTIME = { "cmd.exe", "/C" };
    private static final String[] OS_LINUX_RUNTIME = { "/bin/bash", "-l", "-c" };

    private Utils() {
    }

    private static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static List<String> runProcess(boolean isWin, String... command) {
        System.out.print("command to run: ");
        for (String s : command) {
            System.out.print(s);
        }
        System.out.print("\n");
        String[] allCommand = null;
        try {
            if (isWin) {
                allCommand = concat(WIN_RUNTIME, command);
            } else {
                allCommand = concat(OS_LINUX_RUNTIME, command);
            }
            ProcessBuilder pb = new ProcessBuilder(allCommand);
            pb.redirectErrorStream(true);
            Process p = pb.start();
            p.waitFor();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String _temp = null;
            List<String> line = new ArrayList<String>();
            while ((_temp = in.readLine()) != null) {
                System.out.println("temp line: " + _temp);
                line.add(_temp);
            }
            System.out.println("result after command: " + line);
            return line;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
