package materials;

public class ChemicalImpl implements Chemical {
    String name;
    String cas;

    public ChemicalImpl(String name, String cas) {
        this.name = name;
        this.cas = cas;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCas() {
        return cas;
    }

    @Override
    public void setCas(String cas) {
        this.cas = cas;
    }

    @Override
    public String toString() {
        return name.toUpperCase() + " with the cas of " + cas;
    }
}
