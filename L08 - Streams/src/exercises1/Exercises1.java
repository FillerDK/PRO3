package exercises1;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercises1 {

    public static void main(String[] args) {
        // Liste med tal mellem 1 - 50
        List<Integer> list = List.of(1,2,3,2,1,6,3,4,5,2,3,8,8,9,34,32);
        //list.stream().forEach(e-> System.out.println(e+1));

        //  TODO
        //	Udskriver det største element i listen
        int maxValueInList = list.stream().max(Integer::compareTo).get();
        System.out.println("Max value: " + maxValueInList);

        //  TODO
        //	Afgør og udskriver om alle tallene i listen er mindre end 50
        System.out.println("Alle tal < 50: " + list.stream().allMatch(e -> e < 50));

        //  TODO
        // 	Udskriver antallet af lige tal i listen
        System.out.println("Lige tal: " + list.stream().filter(e -> e % 2 == 0).count());

        //  TODO
        //	Udskriver antallet af ulige tal i listen
        System.out.println("Ulige tal: " + list.stream().filter(e -> e % 2 == 1).count());

        //  TODO
        IntSummaryStatistics stats = list.stream().mapToInt(Integer::intValue).summaryStatistics();
        //  Udskriver
        //      Gennemsnittet af tallene i listen
        System.out.println("Gennemsnit: " + stats.getAverage());
        //      Antallet af tallene i listen
        System.out.println("Antal: " + stats.getCount());
        //      Antallet af tallene i listen der er større end gennemsnittet
        System.out.println("Antal større end gennemsnit: " +
                list.stream()
                        .filter(e -> e > stats.getAverage()).count()
        );
        //      Antallet af tallene i listen der er mindre end gennemsnittet
        System.out.println("Antal mindre end gennemsnit: " +
                list.stream()
                        .filter(e -> e < stats.getAverage()).count()
        );

        //  TODO
        //	Udskriver antallet af gange de forskellige tal forekommer i listen
        System.out.println("Antal forekomster: " +
                list.stream()
                        .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
        );

        //  TODO
        //	Udskriver antallet af gange de forskellige tal forekommer i listen i sorteret orden
        System.out.println("Antal forekomster i sorteret orden: " +
                list.stream()
                        .collect(Collectors.groupingBy(
                                e -> e,
                                TreeMap::new,
                                Collectors.counting())
                        )
        );
    }
}
