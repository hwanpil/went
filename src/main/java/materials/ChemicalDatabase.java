package materials;

import java.io.IOException;

public interface ChemicalDatabase {
    Chemical pull(String name, String cas);
}
