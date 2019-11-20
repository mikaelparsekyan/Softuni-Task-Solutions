package barracksWars.core.commands;


import barracksWars.data.UnitRepository;
import barracksWars.interfaces.CommandInterpreter;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unchecked")
public class Interpreter implements CommandInterpreter {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    private static final String PACKAGE_PATH = "barracksWars.core.commands.";

    public Interpreter(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String commandClassName = String.valueOf(data[0].charAt(0)).toUpperCase() +
                data[0].substring(1).toLowerCase();

        Executable executable = null;
        try {
            Class clazz = Class.forName(PACKAGE_PATH + commandClassName);
            Constructor constructor = clazz.getDeclaredConstructor(String[].class,
                    Repository.class, UnitFactory.class);

            executable = (Executable) constructor.newInstance(data, this.repository, this.unitFactory);

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return executable;
    }
}
