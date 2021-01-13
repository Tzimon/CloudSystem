package de.tzimon.cloudsystem.commands;

import de.tzimon.cloudsystem.CloudMaster;

public class StopCommand extends CloudCommand {

    public StopCommand() {
        super("stop", "stop", "Stops the server", "exit", "end", "shutdown");
    }

    public void execute(String[] args) {
        CloudMaster.getInstance().shutdown();
    }

}
