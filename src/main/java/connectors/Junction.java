package connectors;

import base.Component;
import exceptions.TooManyConnectorsException;

import java.util.List;

public interface Junction extends Component {
    Component[] getUpStreams();

    Component[] getDownStreams();
    void fromMany(List<Component> upStreams) throws TooManyConnectorsException;
    void toMany(List<Component> downStreams) throws TooManyConnectorsException;
    static Junction of(int inlets, int outlets){
        return new ManyToManyJunction(inlets, outlets);
    }
}
