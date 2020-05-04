package base;

import exceptions.TooManyConnectorsException;
import materials.Fluid;

public interface Component {
    Component from(Component prev) throws TooManyConnectorsException;
    Component to(Component next) throws TooManyConnectorsException;
    Fluid getFluid();
    void setFluid(Fluid fluid);
    void run();
    default boolean isChemicalChangeable(){
        return false;
    }
}
