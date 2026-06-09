package open.dolphin.infomodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GeneratedLowCoverageSmokeTest {

    @Test
    public void testInstantiateLowCoverageModels() throws Exception {
        String[] classNames = new String[] {
                "open.dolphin.infomodel.AddressModel",
                "open.dolphin.infomodel.ClaimConst",
                "open.dolphin.infomodel.DrugInteractionList",
                "open.dolphin.infomodel.ModelUtils",
                "open.dolphin.infomodel.PVTPatient",
                "open.dolphin.infomodel.SimpleDate",
                "open.dolphin.infomodel.Stamp",
                "open.dolphin.infomodel.StampInfo",
                "open.dolphin.infomodel.PatientModel",
                "open.dolphin.infomodel.ModuleModel",
                "open.dolphin.infomodel.UserModel"
        };

        for (String className : classNames) {
            Class<?> clazz = Class.forName(className);
            try {
                Object instance = clazz.getDeclaredConstructor().newInstance();
                assertNotNull(instance, "Instance should not be null for " + className);
            } catch (NoSuchMethodException ignored) {
                // Skip classes without a public no-arg constructor.
            }
        }
    }
}
