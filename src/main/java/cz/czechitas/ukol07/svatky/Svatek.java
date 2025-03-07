package cz.czechitas.ukol07.svatky;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.time.MonthDay;

public class Svatek {
    private final ObjectMapper objectMapper = new ObjectMapper();


    private MonthDay den;
    private String jmeno;

    public MonthDay getDen() {
        return den;
    }

    public void setDen(MonthDay den) {
        this.den = den;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }


}
