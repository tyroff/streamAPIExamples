import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class UseDistinct {
    private static void testDistinct() {
        // distinct возвращает stream без дубликатов, при этом для упорядоченного стрима
        // (например, коллекция на основе list) порядок стабилен, для неупорядоченного — порядок не гарантируется.

        Collection<String> ordered = Arrays.asList("a3", "a2", "a2", "a3", "a1", "a2", "a2");
        Collection<String> nonOrdered = new HashSet<>(ordered);

        System.out.println("nonOrdered = " + nonOrdered);

        // Получение коллекции без дубликатов
        List<String> distinct = nonOrdered
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinct = " + distinct);

        List<String> distinctOrdered = ordered
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinctOrdered = " + distinctOrdered);
    }

    public static void main(String[] args) {
        testDistinct();
    }
}
