package military_elite.classes;

import military_elite.interfaces.LieutenantGeneral;
import military_elite.interfaces.Private;

import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private TreeSet<PrivateImpl> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>((a, b) -> {
            return Integer.compare(b.getId(), a.getId());
        });
    }


    @Override
    public void addPrivate(PrivateImpl priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append(System.lineSeparator()).append("Privates:");
        for (Private aPrivate : this.privates) {
            result.append(System.lineSeparator()).append("  ").append(aPrivate.toString());
        }
        return result.toString();
    }
}
