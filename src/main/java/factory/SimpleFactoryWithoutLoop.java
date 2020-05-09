package factory;

import base.AbstractFactory;
import base.Component;
import base.Factory;
import equipments.Repository;
import exceptions.TooManyConnectorsException;

import java.util.*;

public class SimpleFactoryWithoutLoop extends AbstractFactory implements Factory {

    private List<Component> topoSort(){
        List<Component> order = new ArrayList<>();
        Map<Component, Boolean> visited = new HashMap<>();

        for (Component cmp : this.getAllComponents()) {
            visited.put(cmp, false);
        }

        for (Component cmp : this.getAllComponents()){
            if (!visited.get(cmp)){
                dfs(cmp, visited, order);
            }
        }

        Collections.reverse(order);
        return order;
    }

    private void dfs(Component cmp, Map<Component, Boolean> visited, List<Component> order) {
        visited.put(cmp, true);
        for (Component c : cmp.getNextComponents()) {
            if (!visited.get(c)){
                dfs(c, visited, order);
            }
        }
        order.add(cmp);
    }


    @Override
    public void run() {
        for (Component cmp : topoSort()) {
            cmp.run();
        }
    }
}
