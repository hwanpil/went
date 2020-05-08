package base;

import exceptions.TooManyConnectorsException;
import materials.Fluid;

import java.util.List;

public interface Component {
    Component from(Component prev) throws TooManyConnectorsException;
    Component to(Component next) throws TooManyConnectorsException;
    Fluid getFluid();
    void setFluid(Fluid fluid);
    void run();
    List<Component> getNextComponents();
    String getId();
    default boolean isChemicalChangeable(){
        return false;
    }

}
