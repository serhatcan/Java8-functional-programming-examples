import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Iterating through a list
 * Created by Serhat Can on 1.12.2015.
 */
public class IteratingThroughList {

    private final List<String> friends = Arrays.asList("Ferhat", "Zeki", "Omer", "Ogulcan");

    @Test
    public void oldFashion() {

        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

    }

    @Test
    public void anonymousInnerClass() {

        friends.forEach(new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
        });

    }

    /**
     * The forEach() is a higher-order function that accepts a lambda expression or block of code to execute
     * in the context of each element in the list. The variable name is bound to each element of the collection
     * during the call.
     */
    @Test
    public void lambdaExpression() {

        friends.forEach((final String friend) -> System.out.println(friend));

    }

    /**
     * Java lets us simply replace the body of code with the method name of our choice.
     * Wise words of Antoine de Saint-Exupery:
     * "Perfection is achieved not when there is nothing more to add, but when there is nothing to left to take away"
     */
    @Test
    public void methodReference() {

        friends.forEach(System.out::println);

    }


}
