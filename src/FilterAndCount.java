import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndCount {
    // filter - возвращает stream, в котором есть только элементы, соответствующие условию фильтра
    // count - возвращает количество элементов в стриме
    // collect - преобразует stream в коллекцию или другую структуру данных
    // mapToInt - преобразовать объект в числовой стрим (стрим, содержащий числа)

    private static void testFilterAndCount() {
        // ************ Работа со строками
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // Вернуть количество вхождений объекта
        long count = collection
                .stream()
                .filter("a1"::equals)
                .count();
        System.out.println("count = " + count);

        // Выбрать все элементы по шаблону
        List<String> select = collection
                .stream()
                .filter((s) -> s.contains("1"))
                .collect(Collectors.toList());
        System.out.println("select = " + select);

        // ************ Работа со сложными объектами

        // Зададим коллекцию людей
        Collection<People> people = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMAN),
                new People("Иван Иванович", 69, Sex.MAN)
        );

        // Выбрать мужчин-военообязанных
        //TODO: to be continue =]===>
    }

    private enum Sex {
        MAN,
        WOMAN
    }

    private static class People {
        private final String name;
        private final Integer age;
        private final Sex sex;

        public People(String name, Integer age, Sex sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Sex getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }
    }

    public static void main(String[] args) {
        testFilterAndCount();
    }
}
