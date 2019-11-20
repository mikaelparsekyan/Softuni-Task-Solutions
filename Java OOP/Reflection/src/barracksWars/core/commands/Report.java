package barracksWars.core.commands;

import barracksWars.core.Inject;
import barracksWars.interfaces.Repository;

public class Report extends Command {
    @Inject
    protected Repository repository;

    protected Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
