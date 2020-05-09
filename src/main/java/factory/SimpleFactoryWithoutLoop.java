package factory;

import base.AbstractFactory;
import base.Component;
import base.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class SimpleFactoryWithoutLoop extends AbstractFactory implements Factory {
    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleFactoryWithoutLoop.class);
    private boolean loop = false;
    private static final int LOW = 0;
    private static final int MID = 0;
    private static final int HIGH = 0;

    private List<Component> topoSort(){
        List<Component> order = new ArrayList<>();
        Map<Component, Integer> visited = new HashMap<>();

        for (Component cmp : this.getAllComponents()) {
            visited.put(cmp, LOW);
        }

        for (Component cmp : this.getAllComponents()){
            if (visited.get(cmp)==LOW){
                dfs(cmp, visited, order);
            }
        }
        Collections.reverse(order);
        return loop?new LinkedList<>():order;
    }

    private void dfs(Component cmp, Map<Component, Integer> visited, List<Component> order) {
        visited.put(cmp, MID);
        for (Component c : cmp.getNextComponents()) {
            if (visited.get(c)==LOW){
                dfs(c, visited, order);
            }else if(visited.get(c)==MID){
                this.loop = true;
            }
        }
        visited.put(cmp, HIGH);
        order.add(cmp);
    }

    @Override
    public void run() {
        List<Component> sorted = topoSort();
        if (sorted.size()==0){
            LOGGER.warn("There is no components registered in the factory or there is a loop in the flow sheet! Please check again!");
        }
        for (Component cmp : sorted) {
            cmp.run();
        }
    }
}
