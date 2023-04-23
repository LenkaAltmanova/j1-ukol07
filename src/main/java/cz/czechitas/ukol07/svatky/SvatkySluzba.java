package cz.czechitas.ukol07.svatky;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Array;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SvatkySluzba {

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();
    private final Path cestaKDatum = Path.of("svatky.json");
    private final SeznamSvatku seznamSvatku;

    public SvatkySluzba() throws IOException {
        seznamSvatku = objectMapper.readValue(cestaKDatum.toFile(), SeznamSvatku.class);
    }

    public List<String> vyhledatSvatkyDnes() {
        return vyhledatSvatkyKeDni(MonthDay.now());
    }

    public List<String> vyhledatSvatkyKeDni(MonthDay day) {
        return seznamSvatku
                .getSvatky()
                .stream()
                .filter(s -> day.equals(s.getDen()))
                .map(svatek -> svatek.getJmeno())
                .collect(Collectors.toList());

        // TODO
        // získat seznam svátků
        // převést na Stream
        // pomocí metody filter() vybrat jen ty, které odpovídají zadanému dni (porovnat MonthDay pomocí metodyequals())
        // pomocí metody map() získat z objektu jméno
        // pomocí toList() převést na List

        // Následující řádek po vlastní implementaci smažete.
        //return List.of();
    }
}
