package equipments;

public interface Equip {
    Equip getUpstream();
    Equip getDownstream();
    String getUUID();
}
