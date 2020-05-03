package materials;

public interface Chemical {
    String getName();
    String getCas();
    double getPrice();
    void setName(String name);
    void setCas(String cas);
    void setPrice(double price);
}
