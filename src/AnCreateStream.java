import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AnCreateStream {
    public static void main(String[] args) throws IOException {
        System.out.println("Test build Stream start");

        //Создание стрима из значений
        Stream<String> streamFromValues = Stream.of("a1", "b2", "c3");
        System.out.println("streamFromValues = " + streamFromValues.collect(Collectors.toList()));

        // Создание стрима из массива
        String[] array = {"a1", "b2", "c3"};
        Stream<String> streamFromArrays = Arrays.stream(array);
        System.out.println("streamFromArrays = " + streamFromArrays.collect(Collectors.toList()));

        Stream<String> streamFromArrays2 = Stream.of(array);
        System.out.println("streamFromArrays2 = " + streamFromArrays2.collect(Collectors.toList()));

        // Создание стрима из файла (каждая запись в файле будет отдельной строкой в стриме)
        File file = new File("1.txt");
        PrintWriter out = new PrintWriter(file);
        out.println("a1");
        out.println("b2");
        out.println("c3");
        out.close();
        Stream<String> streamFromFiles = Files.lines(Paths.get(file.getAbsolutePath()));
        System.out.println("streamFromFiles = " + streamFromFiles.collect(Collectors.toList()));

        // Создание стрима из коллекции
        Collection<String> collection = Arrays.asList("a1", "b2", "c3");
        Stream<String> streamFromCollection = collection.stream();
        System.out.println("streamFromCollection = " + streamFromCollection.collect(Collectors.toList()));

        // Создание числового стрима из строки
        IntStream streamFromString = "123".chars();
        System.out.print("streamFromString = ");
        streamFromString.forEach((e) -> System.out.print(e + ", "));
        System.out.println();


    }
}
