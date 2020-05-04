package equipments;

import base.AbstractComponent;
import base.Component;
import materials.Fluid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Repository extends AbstractComponent implements Component {
    private static Logger LOGGER = LoggerFactory.getLogger(Repository.class);

    public Repository(Fluid fluid) {
        this.fluid = fluid;
    }

    @Override
    public Component from(Component prev) {
        return null;
    }

    public void run() {
        LOGGER.info("Repo is ready to use!");
    }
}
