package mmn11.mmn11q2.Temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TemperatureData {
    private static List<YearTemperatures> temperatures = new ArrayList<>();

    public static void initializeData(List<YearTemperatures> data) {
        if (data == null) {
            throw new IllegalArgumentException("Data list cannot be null");
        }
        temperatures = new ArrayList<>(data);
    }

    public static List<YearTemperatures> getTemperatures() {
        return Collections.unmodifiableList(temperatures);
    }

    public static int getTotalYears() {
        return temperatures.size();
    }

    public static ArrayList<YearTemperatures> getTemps() {
        return new ArrayList<>(temperatures);
    }
}