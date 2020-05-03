package connectors;

import base.Component;
import exceptions.TooManyConnectorsExceptions;
import materials.Fluid;
import materials.SimpleFluid;

import java.util.LinkedList;
import java.util.List;

public class Tjunction2to1 implements Junctions {
    List<Component> upStreams;
    Component downStream;
    Fluid transitional;

    public Tjunction2to1() {
        upStreams = new LinkedList<>();
    }

    public Tjunction2to1(List<Component> upStreams, Component downStream) {
        this.upStreams = upStreams;
        this.downStream = downStream;
        this.transitional = calculate();
    }

    private Fluid calculate(){
        List<Fluid> input = new LinkedList<>();
        for (Component i : upStreams) {
            input.add(i.getFluid());
        }
        return MixingFluidUtils.mixSimple(input);
    }

    private List<Fluid> calculateDownStreams(List<Fluid> upStreams) {
        List<Fluid> res = new LinkedList<>();
        double total = 0;
        for (Fluid fluid : upStreams) {
            total += fluid.getMassFlowRate();
        }
        res.add(new SimpleFluid(total));
        return res;
    }

    @Override
    public List<Component> getUpStreams() {
        return upStreams;
    }

    @Override
    public List<Component> getDownStreams() {
        return List.of(downStream);
    }

    @Override
    public void fromMany(List<Component> upStreams) {
        this.upStreams = upStreams;
    }

    @Override
    public void toMany(List<Component> downStreams) throws TooManyConnectorsExceptions {
        if (downStreams.size()>1){
            throw new TooManyConnectorsExceptions("cannot connect two or more downstreams");
        }
        this.downStream = downStreams.get(0);
    }

    @Override
    public Component from(Component prev) {
        upStreams.add(prev);
        return this;
    }

    @Override
    public Component to(Component next) {
        downStream = next;
        next.from(this);
        return this;
    }

    @Override
    public Fluid getFluid() {
        return transitional;
    }

    @Override
    public void setFluid(Fluid fluid) {
        //TODO find a better way to handle the external set the fluid.
        throw new RuntimeException("cannot set Fluid externally");
    }

    @Override
    public void run() {
        if (transitional == null) {
            transitional = calculate();
        }
        downStream.setFluid(transitional);
    }
}
