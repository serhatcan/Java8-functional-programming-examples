import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by Serhat CAN on 05.12.2015.
 */
public class PickingAnElement {

    final List<String> names = Arrays.asList("Ferhat", "Zeki", "Omer", "Ogulcan");

    final String startingLetter = "O";

    @Test
    public void oldFashionWay() {

        String foundName = null;

        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }

        assertEquals(foundName, "Omer");

    }

    @Test
    public void anElegantWay() {
        Optional<String> foundName =
                names.stream()
                        .filter(name -> name.startsWith(startingLetter))
                        .findFirst();

        assertEquals(foundName.get(), "Omer");
    }

}
