package open.dolphin.infomodel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DrugInteractionListTest {

    @Test
    public void testSetAndGetList() {
        DrugInteractionList list = new DrugInteractionList();
        assertNotNull(list);

        List<DrugInteractionModel> interactions = new ArrayList<>();
        interactions.add(new DrugInteractionModel());
        list.setList(interactions);

        assertEquals(1, list.getList().size());
    }
}
