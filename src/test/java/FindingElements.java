import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

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

    /**
     * I will create a private function called checkIfStartsWith and use it in our filter method
     */
    @Test
    public void reusingLamdaExpressionWithFunction() {

        final long countFriendsWithStartsN =
                friends.stream()
                        .filter(checkIfStartsWith("O"))
                        .count();

        assertEquals(countFriendsWithStartsN, 2);

    }

    private Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }

    /**
     * In this example, to narrow down the scope of function (meaning that without create separete function)
     */
    @Test
    public void reusingWithFunctionInterface() {

        final Function<String, Predicate<String>> startWithLetterLongVersion =
                (String letter) -> {
                    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                    return checkStarts;
                };

        final Function<String, Predicate<String>> startWithLetter =
                (String letter) -> (String name) -> name.startsWith(letter);

        final long countFriendsStartO =
                friends
                        .stream()
                        .filter(startWithLetter.apply("O"))
                        .count();

        assertEquals(countFriendsStartO, 2);
    }

}
