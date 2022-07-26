import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ForEachAndPeek {

    private static void testForEach() {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // Напечатать отладочную информацию по каждому элементу стрима
        System.out.print("forEach = ");
        collection
                .stream()
                .map(String::toUpperCase)
                .forEach(e -> System.out.print(e + ","));
        System.out.println();

        Collection<StringBuilder> list = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));
        list
                .stream()
                .forEachOrdered(p -> p.append("_new"));
        System.out.println("forEachOrdered = " + list);
    }

    // Метод Peek возвращает тот же стрим, но при этом применяет указанный метод к каждому элементу стрима
    private static void testPeek() {
        System.out.println();
        System.out.println("Test peek start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        // Напечатать отладочную информацию по каждому элементу стрима
        System.out.print("peak1 = ");
        List<String> peek = collection
                .stream()
                .map(String::toUpperCase)
                .peek(e -> System.out.print(e + ","))
                .collect(Collectors.toList());
        System.out.println();
        System.out.println("peek2 = " + peek);

        Collection<StringBuilder> list = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));
        List<StringBuilder> newList = list
                .stream()
                .peek(p -> p.append("_new"))
                .collect(Collectors.toList());
        System.out.println("newList = " + newList);
    }

    public static void main(String[] args) {
        testForEach();
        testPeek();
    }
}
