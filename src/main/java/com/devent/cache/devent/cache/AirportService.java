package com.devent.cache.devent.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportService {

    public final AirportRepository airportRepository;
    public final CacheStore<Airport> airportCache;

    public Airport getEmployeeById(String empId) {
        // search airport record in Cache
        Airport cachedAirport = airportCache.get(empId);
        if(cachedAirport != null) {
            System.out.println("Cache hit for : " + cachedAirport.getCode());
            return cachedAirport;
        }

        // fetch airport details from DB
        Airport airport = airportRepository.getAirportByCode(empId);

        // store airport record in Cache
        airportCache.add(empId, airport);

        return airport;
    }
}
