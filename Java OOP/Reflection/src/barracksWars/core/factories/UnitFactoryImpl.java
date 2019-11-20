package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.*;

public class UnitFactoryImpl implements UnitFactory {

    @Override
    public Unit createUnit(String unitType)  {
        Unit unit = null;
        switch (unitType) {
            case "Archer":
                unit = new Archer();
                break;
            case "Swordsman":
                unit = new Swordsman();
                break;
            case "Pikeman":
                unit = new Pikeman();
                break;
            case "Gunner":
                unit = new Gunner();
                break;
            case "Horseman":
                unit = new Horseman();
                break;
        }
		return unit;
    }
}
