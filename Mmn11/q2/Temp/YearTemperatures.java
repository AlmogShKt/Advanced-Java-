package mmn11.mmn11q2.Temp;

import java.util.Arrays;

public class YearTemperatures {
    private final int[] temperatures;
    private final int year;
    private final int minTempIndex;
    private final int maxTempIndex;

    public YearTemperatures(int[] temperatures, int year) {
        if (temperatures == null || temperatures.length != 12) {
            throw new IllegalArgumentException("Temperatures array must contain 12 elements");
        }
        this.temperatures = Arrays.copyOf(temperatures, temperatures.length);
        this.year = year;
        int[] minMaxIndices = findMinMaxIndices();
        this.minTempIndex = minMaxIndices[0];
        this.maxTempIndex = minMaxIndices[1];
    }

    private int[] findMinMaxIndices() {
        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] < temperatures[minIndex]) {
                minIndex = i;
            }
            if (temperatures[i] > temperatures[maxIndex]) {
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }

    public int[] getTemperatures() {
        return Arrays.copyOf(temperatures, temperatures.length);
    }

    public int getMaxTemp() {
        return temperatures[maxTempIndex];
    }

    public int getMaxTempMonth() {
        return maxTempIndex;
    }

    public int getMinTempMonth() {
        return minTempIndex;
    }

    public int getYear() {
        return year;
    }
}