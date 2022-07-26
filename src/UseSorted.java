import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UseSorted {

    private static void testSorted() {
        Collection<String> collection = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");

        // отсортировать значения по алфавиту
        List<String> sorted = collection
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("sorted = " + sorted);

        // отсортировать значения по алфавиту и убрать дубликаты
        List<String> sortedDistinct = collection
                .stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("sortedDistinct = " + sortedDistinct);

        // отсортировать значения по алфавиту в обратном порядке
        List<String> sortedReverse = collection
                .stream()
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .collect(Collectors.toList());
        System.out.println("sortedReverse = " + sortedReverse);

        // отсортировать значения по алфавиту в обратном порядке  и убрать дубликаты
        List<String> distinctReverse = collection
                .stream()
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinctReverse = " + distinctReverse);

        // ************ Работа с объектами
        // Зададим коллекцию людей
        Collection<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN)
        );

        // Отсортировать по имени в обратном алфавитном порядке
        Collection<People> byName = peoples
                .stream()
                .sorted((o1, o2) -> -o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList());
        System.out.println("byName = " + byName);

        // Отсортировать сначала по полу, а потом по возрасту
        Collection<People> bySexAndAge = peoples
                .stream()
                .sorted((o1, o2) -> o1.getSex() != o2.getSex() ? o1.getSex().compareTo(o2.getSex()) : o1.getAge().compareTo(o2.getAge()))
                .collect(Collectors.toList());
        System.out.println("bySexAndAge = " + bySexAndAge); // bySexAndAge = [{name='Вася', age=16, sex=MAN},
    }

    public static void main(String[] args) {
        testSorted();
    }

    private enum Sex {
        MAN,
        WOMEN;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof People)) return false;
            People people = (People) o;
            return Objects.equals(name, people.name) &&
                    Objects.equals(age, people.age) &&
                    Objects.equals(sex, people.sex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, sex);
        }
    }
}
