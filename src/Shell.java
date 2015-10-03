import java.io.*;
import java.util.*;
import java.lang.reflect.*;

/**
 *  Shell is a simulator of Linux's shell.
 *
 *  @author kurokuriboh - 09/29/2015
 */
public class Shell {
    /**
     *  Main method of Shell program.
     */
    public static void main(String[] args) {
        intro();

        Scanner input = new Scanner(System.in);
        boolean shellOn = true;

        while (shellOn) {
            System.out.print("user@home:~$ ");
            String command = input.nextLine();
            String[] commandArgs = command.split(" ");

            if (command.startsWith("exit")) {
                shellOn = false;
            } else {
                executeCommand(commandArgs);
            }
        }
    }

    /**
     *  Introduce the Shell program.
     */
    public static void intro() {
        System.out.println("This is a simulator of Linux's shell.");
    }

    /**
     *  Execute the command with the given command's arguments
     *
     *  @param  commandArgs     command and command's arguments
     */
    public static void executeCommand(String[] commandArgs) {
        try {
            Shell sh = new Shell();
            Method method = Shell.class.getMethod(commandArgs[0], String[].class);

            try {
                method.invoke(sh, (Object) commandArgs);
            } catch (IllegalAccessException e) {
                System.out.println(e);
            } catch (InvocationTargetException e) {
                System.out.println(e);
            }
        } catch (NoSuchMethodException e) {
            System.out.println(commandArgs[0] + ": command not found");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    /**
     *  Concatenate file(s), or standard input, to standard output.
     */
    public static void cat(String[] commandArgs) {
        if (commandArgs.length == 1) {
            Scanner input = new Scanner(System.in);
            boolean catOn = true;
            while (catOn) {
                System.out.println(input.nextLine());
            }
        }
    }
}
