package de.tzimon.cloudsystem;

import de.tzimon.cloudsystem.commands.CommandManager;
import de.tzimon.cloudsystem.logging.CloudLogger;

public class CloudMaster {

    private static CloudMaster instance;

    private boolean running;

    private CommandManager commandManager;

    public CloudMaster() {
        instance = this;

        CloudLogger.info("Starting...");

        commandManager = new CommandManager();
        commandManager.load();
    }

    public void shutdown() {
        CloudLogger.info("Shutting down...");

        this.running = false;
        System.exit(0);
    }

    public static CloudMaster getInstance() {
        return instance;
    }

    public boolean isRunning() {
        return running;
    }

}
