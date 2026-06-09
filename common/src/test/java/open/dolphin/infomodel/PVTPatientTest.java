package open.dolphin.infomodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PVTPatientTest {

    @Test
    public void testFullNameGeneration() {
        PVTPatient patient = new PVTPatient();
        assertNotNull(patient);

        patient.addRepCode("A");
        patient.addFamilyName("Yamada");
        patient.addGivenName("Taro");

        assertEquals("Yamada Taro", patient.getFullName("A"));
    }

    @Test
    public void testAddressBuilder() {
        PVTPatient patient = new PVTPatient();
        patient.addAddressRepCode("I");
        patient.addAddressClass("home");
        patient.addAddressFull("1234 Main St");
        patient.addAddressPrefecture("Tokyo");
        patient.addAddressCity("Chiyoda");
        patient.addAddressTown("Kanda");
        patient.addAddressHomeNumber("1-1");
        patient.addAddressZipCode("100-0001");
        patient.addAddressCountryCode("JP");

        assertEquals("1234 Main St", patient.getFullAddress());
        assertEquals("100-0001", patient.getZipCode());
    }
}
