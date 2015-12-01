import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Transforming a list
 * Created by Serhat Can on 1.12.2015.
 */
public class TransformingList {

    private final List<String> friends = Arrays.asList("Ferhat", "Zeki", "Omer", "Ogulcan");

    @Test
    public void oldFashionWay() {

        final List<String> uppercaseNames = new ArrayList<>();

        for (String name : friends) {
            uppercaseNames.add(name.toUpperCase());
        }

        System.out.println(uppercaseNames);

    }

    /**
     * The map() method is quite useful to map or transform an input collection into a new output collection
     */
    @Test
    public void lambdaExpressionsWithStreamAPI() {

        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.println(name + " "));

        // or

        System.out.println("Name distinct length test:");

        friends.stream()
                .map(name -> name.length())
                .distinct()
                .forEach(name -> System.out.println(name));

    }

    @Test
    public void methodReference() {

        friends.stream()
                .map(String::toUpperCase)
                .forEach((name) -> System.out.println(name));

    }

}
