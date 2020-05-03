package base;

import materials.Fluid;

public interface Resource {
    void to(Component next);
    Fluid getFluid();
    void setFluid(Fluid fluid);
    void run();
}
