package connectors;

import base.Component;
import exceptions.TooManyConnectorsException;
import materials.Fluid;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractJunction implements Junction {
    Component[] inlets;
    Component[] outlets;
    private Fluid transitional;
    Fluid fluid;
    int countin = 0;
    int countout = 0;

    public AbstractJunction(){
        this(1, 1);
    }

    public AbstractJunction(int intletsNum, int outletsNum) {
        inlets = new Component[intletsNum];
        outlets = new Component[outletsNum];
    }

    @Override
    public Component from(Component prev) throws TooManyConnectorsException {
        if (countin >= inlets.length) {
            throw new TooManyConnectorsException("Too Many inlets connectors");
        }
        inlets[countin++] = prev;
        return this;
    }

    @Override
    public Component to(Component next) throws TooManyConnectorsException {
        if (countout >= outlets.length) {
            throw new TooManyConnectorsException("Too Many outlets connectors");
        }
        outlets[countout++] = next;
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
    public Component[] getUpStreams() {
        return inlets;
    }

    @Override
    public Component[] getDownStreams() {
        return outlets;
    }

    @Override
    public void fromMany(List<Component> upStreams) throws TooManyConnectorsException {
        if (upStreams.size()+countin >= inlets.length) {
            throw new TooManyConnectorsException("Too Many inlets connectors");
        }
        for (Component i : upStreams) {
            inlets[countin++] = i;
        }
    }

    @Override
    public void toMany(List<Component> downStreams) throws TooManyConnectorsException {
        if (downStreams.size()+countout >= inlets.length) {
            throw new TooManyConnectorsException("Too Many inlets connectors");
        }
        for (Component i : downStreams) {
            inlets[countout++] = i;
        }
    }

    @Override
    public void run() {
        transitional = mergeFluid();
        distributeFluid();
    }

    private Fluid mergeFluid() {
        List<Fluid> inFluids = new LinkedList<>();
        for (Component i : inlets) {
            inFluids.add(i.getFluid());
        }
        return MixingFluidUtils.mixSimple(inFluids);
    }

    private void distributeFluid() {
        fluid = MixingFluidUtils.splitSimple(transitional, outlets.length);
    }
}
