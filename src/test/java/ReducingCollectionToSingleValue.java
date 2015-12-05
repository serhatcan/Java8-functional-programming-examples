import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Serhat CAN on 06.12.2015.
 */
public class ReducingCollectionToSingleValue {

    final List<String> names = Arrays.asList("Ferhat", "Zeki", "Omer", "Ogulcan");

    /**
     * Uses MapReduce pattern, with map() method being the spread operation and the sum() method being the
     * special case of the more general reduce operation.
     */
    @Test
    public void totalNumberOfCharactersInNamesCollection() {

        int sum = names.stream()
                .mapToInt((name) -> name.length())
                .sum(); // there are lots of options like average, count, distinct, findFirst etc...

        assertEquals(sum, 21);

    }

}
