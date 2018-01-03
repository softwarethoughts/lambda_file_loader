package ch.swth.lambda.file;

import ch.swth.lambda.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class Import {
    private final static String CSV_FILE_PATH = "persons.csv";
    private final static String CSV_SEPARATOR = ";";

    public List<Person> load() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH))) {
            return loadPersons(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Person> loadPersons(BufferedReader reader) {
        return reader.lines().collect(ArrayList::new, tokensToPerson, ArrayList::addAll);
    }

    private BiConsumer<ArrayList<Person>, String> tokensToPerson = (persons, csvLine) -> {
        String[] tokens = csvLine.split(CSV_SEPARATOR);
        Person[] person = {new Person(tokens[0], tokens[1], tokens[2])};
        persons.addAll(Arrays.asList(person));
    };
}
