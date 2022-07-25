import java.util.Arrays;
import java.util.Collection;

public class UseMatch {
    // anyMatch	- Возвращает true, если условие выполняется хотя бы для одного элемента
    // noneMatch - Возвращает true, если условие не выполняется ни для одного элемента
    // allMatch	- Возвращает true, если условие выполняется для всех элементов
    // anyMatch это short-circuiting методы, то есть обход стримов организуется таким образом
    // чтобы найти подходящий элемент максимально быстро, а не обходить весь изначальный стрим.

    private static void testMatch() {

        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // найти существуют ли хоть одно совпадение с шаблоном в коллекции
        boolean isAnyOneTrue = collection
                .stream()
                .anyMatch("a1"::equals);
        System.out.println("anyOneTrue = " + isAnyOneTrue);

        boolean isAnyOneFalse = collection
                .stream()
                .anyMatch("a13"::equals);
        System.out.println("anyOneFalse = " + isAnyOneFalse);

        // найти существуют ли все совпадения с шаблоном в коллекции
        boolean isAll = collection
                .stream()
                .allMatch(s -> s.contains("1"));
        System.out.println("isAll = " + isAll);

        // сравнение на неравенство
        boolean isNotEquals = collection
                .stream()
                .noneMatch("a7"::equals);
        System.out.println("isNotEquals = " + isNotEquals);
    }

    public static void main(String[] args) {
        testMatch();
    }
}
