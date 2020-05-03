package equipments;

import base.Component;
import materials.Fluid;

public abstract class AbstractComponent implements Component {
    Component upStream;
    Component downStream;
    Fluid transitional;

    public AbstractComponent(){
        this(null, null, null);
    }

    public AbstractComponent(Component upStream, Component downStream, Fluid transitional) {
        this.upStream = upStream;
        this.downStream = downStream;
        this.transitional = transitional;
    }

    public Component from(Component prev){
        upStream = prev;
        return this;
    }
    public Component to(Component next){
        downStream = next;
        next.from(this);
        return this;
    }
    public Fluid getFluid(){
        return transitional;
    }
    public void setFluid(Fluid fluid){
        this.transitional = fluid;
    }

    public void run(){}
}
