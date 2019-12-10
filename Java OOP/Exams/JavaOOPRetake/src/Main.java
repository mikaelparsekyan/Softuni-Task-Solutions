import core.EngineImpl;
import core.ManagerControllerImpl;
import core.interfaces.Engine;
import core.interfaces.ManagerController;

public class Main {
    public static void main(String[] args) {
        ManagerController controller = new ManagerControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
