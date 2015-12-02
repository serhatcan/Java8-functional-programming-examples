import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by serhat on 2.12.2015.
 */
public class FindingElements {

    private final List<String> friends = Arrays.asList("Ferhat", "Zeki", "Omer", "Ogulcan");

    @Test
    public void oldFashionWay() {

        final List<String> startsWithO = new ArrayList<>();

        for (String name : friends) {
            if (name.startsWith("O")) {
                startsWithO.add(name);
            }
        }

        assertEquals(startsWithO.size(), 2);

    }

    @Test
    public void withFilterMethod() {

        final List<String> startsWithO =
                friends.stream()
                        .filter(name -> name.startsWith("O"))
                        .collect(Collectors.toList());

        assertEquals(startsWithO.size(), 2);
    }


    /**
     * Reusing lambda expressions!
     * If we would use startsWithO function in multiple functions, we would better write our code like this.
     * DRY (Don't Repeat Yourself)
     */
    @Test
    public void reusingLambdaExpressions() {

        final Predicate<String> startsWithO = name -> name.startsWith("O");

        final long countFriendsWithStartsN =
                friends.stream()
                        .filter(startsWithO)
                        .count();

        assertEquals(countFriendsWithStartsN, 2);


    }

}
