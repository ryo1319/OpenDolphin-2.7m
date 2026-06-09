package open.dolphin.common;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrcaAnalyzeTest {

    @Test
    public void testAnalisisSampleXml_validXml_noException() {
        OrcaAnalyze analyzer = new OrcaAnalyze();
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<xmlio2>"
                + "<patientinfores>"
                + "  <Patient_Information>"
                + "    <Patient_ID>12345</Patient_ID>"
                + "    <HealthInsurance_Information>"
                + "      <HealthInsurance_Information_child>"
                + "        <InsuranceProvider_Class>1</InsuranceProvider_Class>"
                + "      </HealthInsurance_Information_child>"
                + "    </HealthInsurance_Information>"
                + "  </Patient_Information>"
                + "</patientinfores>"
                + "</xmlio2>";

        assertDoesNotThrow(() -> analyzer.analisisSampleXml(xml));
    }

    @Test
    public void testAnalisisSampleXml_malformedXml_noException() {
        OrcaAnalyze analyzer = new OrcaAnalyze();
        String badXml = "<xmlio2><patientinfores><Patient_Information><Patient_ID>1"; // truncated
        assertDoesNotThrow(() -> analyzer.analisisSampleXml(badXml));
    }
}
