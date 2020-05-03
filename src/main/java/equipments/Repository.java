package equipments;

import base.Component;
import base.Resource;
import materials.Fluid;

public class Repository implements Component {

    Fluid fluid;
    Component downStream;

    public Repository(Fluid fluid, Component downStream) {
        this.fluid = fluid;
        this.downStream = downStream;
    }

    public Repository(Fluid fluid) {
        this(fluid, null);
    }

    @Override
    public Component from(Component prev) {
        return null;
    }

    @Override
    public Component to(Component next) {
        downStream = next;
        next.from(this);
        return this;
    }

    @Override
    public Fluid getFluid() {
        return fluid;
    }

    @Override
    public void setFluid(Fluid fluid) {
        this.fluid = fluid;
    }

    @Override
    public void run() {
    }
}
