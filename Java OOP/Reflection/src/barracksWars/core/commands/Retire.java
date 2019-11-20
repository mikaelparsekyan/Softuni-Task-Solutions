package barracksWars.core.commands;

import barracksWars.data.UnitRepository;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Field;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Retire extends Command {

    protected Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = "";
        String unitName = data[1];
        Class unitRepositoryClazz = UnitRepository.class;
        try {
            Field amountOfUnitsField = unitRepositoryClazz.getDeclaredField("amountOfUnits");
            amountOfUnitsField.setAccessible(true);
            Map<String, Integer> value = (Map) amountOfUnitsField.get(getRepository());

            boolean isValid = false;
            if (value.containsKey(unitName)) {
                int currentValue = value.get(unitName);
                if (currentValue > 0) {
                    value.put(unitName, currentValue - 1);
                    output = String.format("%s retired!", unitName);
                    isValid = true;
                }
            }
            if (!isValid) {
                output = "No such units in repository.";
            }
        } catch (NoSuchFieldException |
                IllegalAccessException e) {
            e.printStackTrace();
        }
        return output;
    }
}
