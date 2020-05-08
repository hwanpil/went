package base;

import exceptions.TooManyConnectorsException;

import java.util.Collection;

public interface Factory {
    void run();
    Collection<Component> getAllComponents();
    void addEdge(Component from, Component to) throws TooManyConnectorsException;
}
