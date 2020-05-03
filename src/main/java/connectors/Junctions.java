package connectors;

import base.Component;
import exceptions.TooManyConnectorsExceptions;
import materials.Fluid;

import java.util.List;

public interface Junctions extends Component {
    List<Component> getUpStreams();
    List<Component> getDownStreams();
    void fromMany(List<Component> upStreams) throws TooManyConnectorsExceptions;
    void toMany(List<Component> downStreams) throws TooManyConnectorsExceptions;
}
