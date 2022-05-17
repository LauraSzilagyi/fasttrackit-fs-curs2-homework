package ro.fasttrackit.curs2.ex2.inheritance;

import lombok.RequiredArgsConstructor;
import ro.fasttrackit.curs2.ex2.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RequiredArgsConstructor
public class ReadFromFile extends PersonReportGenerator {
    private final String sourceFile;

    @Override
    List<Person> readPersons() {
        try {
            return Files.lines(Path.of(sourceFile))
                    .map(this::toPerson)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Person toPerson(String line) {
        String[] tokens = line.split(",");
        return new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
    }
}
