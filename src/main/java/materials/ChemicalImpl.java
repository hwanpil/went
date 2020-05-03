package materials;

public class ChemicalImpl implements Chemical {
    String name;
    String cas;
    double price;

    public ChemicalImpl() {
        this("test", "0-0-0", 100);
    }

    public ChemicalImpl(String name, String cas, double price) {
        this.name = name;
        this.cas = cas;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
