package de.tzimon.cloudsystem.commands;

import de.tzimon.cloudsystem.CloudMaster;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommandManager {

    private CloudMaster cloudMaster;
    private Thread thread;

    private Set<CloudCommand> cloudCommands;

    public CommandManager() {
        cloudMaster = CloudMaster.getInstance();

        this.cloudCommands = new HashSet<>();
    }

    public void load() {
        cloudCommands.add(new StopCommand());
        start();
    }

    private void start() {
        thread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);

            while (cloudMaster.isRunning()) {
                String input = scanner.nextLine();

                if (input.isEmpty())
                    continue;

                String[] strings = input.split(" ");
                String inputCommandName = strings[0];

                for (CloudCommand cloudCommand : cloudCommands) {
                    String commandName = cloudCommand.getName();
                    String[] aliases = cloudCommand.getAliases();

                    boolean target = false;

                    if (inputCommandName.equalsIgnoreCase(commandName))
                        target = true;
                    else {
                        for (String alias : aliases) {
                            if (inputCommandName.equalsIgnoreCase(alias)) {
                                target = true;
                                break;
                            }
                        }
                    }

                    if (!target)
                        continue;

                    String[] args = new String[strings.length - 1];
                    System.arraycopy(strings, 1, args, 0, args.length);
                    cloudCommand.execute(args);
                }
            }
        });

        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

}
