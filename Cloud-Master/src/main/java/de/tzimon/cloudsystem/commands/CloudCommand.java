package de.tzimon.cloudsystem.commands;

public abstract class CloudCommand {

    private String name;
    private String usage;
    private String description;
    private String[] aliases;

    protected CloudCommand(String name, String usage, String description, String... aliases) {
        this.name = name;
        this.usage = usage;
        this.description = description;
        this.aliases = aliases;
    }

    protected abstract void execute(String[] args);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUsage() {
        return usage;
    }

    public String[] getAliases() {
        return aliases;
    }

}
