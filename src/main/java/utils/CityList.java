package utils;

import java.util.ArrayList;
import java.util.List;

public class CityList {
    public static List<String> getAllCountries() {
        List<String> countries = new ArrayList<String>();
        for (City city : City.values()) {
            countries.add(city.name());
        }
        return countries;
    }
}
