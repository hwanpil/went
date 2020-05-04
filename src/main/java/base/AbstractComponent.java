package base;

import exceptions.TooManyConnectorsException;
import materials.Fluid;

public abstract class AbstractComponent implements Component {
    protected Component upStream;
    protected Component downStream;
    protected Fluid fluid;

    public Component from(Component prev) throws TooManyConnectorsException {
        if (upStream != null) {
            throw new TooManyConnectorsException("Upstream has already been assigned!");
        }
        upStream = prev;
        return this;
    }

    public Component to(Component next) throws TooManyConnectorsException {
        if (downStream != null) {
            throw new TooManyConnectorsException("Downstream has already been assigned!");
        }
        downStream = next;
        next.from(this);
        return this;
    }

    public Fluid getFluid(){
        return fluid;
    }
    public void setFluid(Fluid fluid){
        this.fluid = fluid;
    }

}
