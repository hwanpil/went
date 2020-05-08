package base;

import exceptions.TooManyConnectorsException;

import java.util.*;

public abstract class AbstractFactory implements Factory{
    protected Set<Component> components;

    protected AbstractFactory(){
        components = new HashSet<>();
    }

    public void addEdge(Component from, Component to) throws TooManyConnectorsException {
        from.to(to);
        components.add(from);
        components.add(to);
    }

    public Collection<Component> getAllComponents(){
        return this.components;
    }

    public int getSize(){
        return this.components.size();
    }
}
