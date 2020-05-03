package equipments;

import base.Component;

public interface Equip extends Component {
    Equip previous();
    Equip next();
    String getUUID();
}
