package materials;

import base.Value;

import java.util.Map;

public class ChemicalImpl implements Chemical {
    private final String name;
    private final String cas;
    private Map<String, Value> properties;

    public ChemicalImpl(String name, String cas, Map<String, Value> properties) {
        this.name = name;
        this.cas = cas;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return name.toUpperCase() + " with the cas of " + cas;
    }

    public Map<String, Value> getProperties(){
        return properties;
    }

    @Override
    public String getCAS() {
        return cas;
    }

    @Override
    public Value getTc() {
        return properties.get("Critical Volume");
    }

    @Override
    public Value getPc() {
        return properties.get("Critical Pressure");
    }

    @Override
    public Value getVc() {
        return properties.get("Critical Temperature");
    }
}
