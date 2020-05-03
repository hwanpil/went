package base;

import materials.Fluid;

import java.util.List;

public interface Component {
    Component from(Component prev);
    Component to(Component next);
    Fluid getFluid();
    void setFluid(Fluid fluid);
    void run();
    default boolean isChemicalChangeable(){
        return false;
    }
}
