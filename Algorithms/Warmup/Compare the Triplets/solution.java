import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class solution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        // these variables store the individual scores
        int alice = 0, bob = 0;

        List<Integer> win = new LinkedList<Integer>();

        for (int i = 0; i < a.size(); i++) {

            // if Alice's score is higher, increament her score
            if (a.get(i) > b.get(i))

                ++alice;

            // if Bob's score is higher, increament his score

            else if (a.get(i) < b.get(i))

                ++bob;
            // if their scores are equal do not makje any changes

        }

        win.add(alice);

        win.add(bob);

        return win;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
