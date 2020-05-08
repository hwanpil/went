package base;

import exceptions.TooManyConnectorsException;
import materials.Fluid;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class AbstractComponent implements Component {
    protected Component upStream;
    protected Component downStream;
    protected Fluid fluid;
    protected String id = UUID.randomUUID().toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractComponent that = (AbstractComponent) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Component from(Component prev) throws TooManyConnectorsException {
        if (upStream != null) {
            throw new TooManyConnectorsException("Upstream has already been assigned!");
        }
        upStream = prev;
        return this;
    }

    @Override
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

    @Override
    public List<Component> getNextComponents(){
        if (this.downStream == null) {
            return new LinkedList<>();
        }
        return List.of(this.downStream);
    }

    public String getId(){
        return this.id;
    }

}
