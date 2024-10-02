package com.devent.cache.devent.cache;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AirportRepository {

    private Map<String, Airport> database = new HashMap<>();

    @PostConstruct
    public void initData() {
        Airport a1 = new Airport("Hanoi", "HAN");
        Airport a2 = new Airport("Danang", "DAD");
        Airport a3 = new Airport("Sai Gon", "HCM");

        database.put("HAN", a1);
        database.put("DAD", a2);
        database.put("HCM", a3);
    }

    public Airport getAirportByCode(String code) {
        System.out.println("Database hit for " + code);
        return database.get(code);
    }

    public void updateAirportByCode(String code, Airport airport) {
        System.out.println("Update airport " + code);
        database.remove(code);
        database.put(code, airport);
    }

}
