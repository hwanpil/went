package materials;

import java.io.IOException;

public class CommonChemicals {
    public static Chemical OCTANE = ChemicalFromChemeo.newInstance().pull("octane", "111-65-9");
}
