import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlat {
    // Метод Map изменяет выборку по определенному правилу, возвращает stream с новой выборкой
    private static void testMap() {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // Изменение всех элементов коллекции
        List<String> transform = collection
                .stream()
                .map(s -> s + "_1")
                .collect(Collectors.toList());
        System.out.println("transform = " + transform);

        // убрать первый символ и вернуть числа
        List<Integer> number = collection
                .stream()
                .map(s -> Integer.parseInt(s.substring(1)))
                .collect(Collectors.toList());
        System.out.println("number = " + number);
    }

    // Метод MapToInt - изменяет выборку по определенному правилу, возвращает stream с новой числовой выборкой
    private static void testMapToInt() {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // убрать первый символ и вернуть числа
        int[] number = collection
                .stream()
                .mapToInt(s -> Integer.parseInt(s.substring(1)))
                .toArray();
        System.out.println("number = " + Arrays.toString(number));
    }

    // Метод FlatMap - похоже на Map - только вместо одного значения, он возвращает целый stream значений
    private static void testFlatMap() {
        Collection<String> collection = Arrays.asList("1,2,0", "4,5");

        // получить все числовые значения, которые хранятся через запятую в collection
        String[] number = collection
                .stream()
                .flatMap(p -> Arrays.asList(p.split(",")).stream())
                .toArray(String[]::new);
        System.out.println("number = " + Arrays.toString(number));
    }

    // Метод FlatMapToInt - похоже на MapToInt - только вместо одного значения, он возвращает целый stream значений
    private static void testFlatMapToInt() {
        Collection<String> collection = Arrays.asList("1,2,0", "4,5");

        // получить сумму всех числовые значения, которые хранятся через запятую в collection
        int sum = collection
                .stream()
                .flatMapToInt(p -> Arrays.asList(p.split(",")).stream()
                        .mapToInt(Integer::parseInt))
                .sum();
        System.out.println("sum = " + sum);
    }

    public static void main(String[] args) {
        testMap();
        testMapToInt();
        testFlatMap();
        testFlatMapToInt();
    }
}
