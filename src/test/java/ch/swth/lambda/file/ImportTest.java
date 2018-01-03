package ch.swth.lambda.file;

import ch.swth.lambda.Person;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ImportTest {
    @Test
    public void loadPersons() {
        // given
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.lines()).thenReturn(Stream.of("Max;Mustermann;Musterstadt", "Maddy;Mustermann;Musterlingen", "Tom;Muster;Musterdorf"));
        Import imp = new Import();
        // when
        List<Person> persons = imp.loadPersons(reader);
        // then
        assertThat(persons).contains(new Person("Maddy", "Mustermann", "Musterlingen"),
                new Person("Max", "Mustermann", "Musterstadt"),
                new Person("Tom", "Muster", "Musterdorf"));
    }
}
