import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LimitAndSkip {
    // Метод Limit позволяет ограничить выборку определенным количеством первых элементов
    private static void testLimit() {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // Вернуть первые два элемента
        List<String> limit = collection
                .stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("limit = " + limit);

        // Вернуть два элемента начиная со второго
        List<String> fromTo = collection
                .stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("fromTo = " + fromTo);

        // вернуть последний элемент коллекции
        String last = collection
                .stream()
                .skip(collection.size() - 1)
                .findAny().orElse("1");
        System.out.println("last = " + last );
    }

    public static void main(String[] args) {
        testLimit();
    }
}
