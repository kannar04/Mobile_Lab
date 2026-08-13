import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        IStats stats = new Statistics();

        double[] numbers = stats.generateRandomNumbers(100);

        printNumbers(numbers);

        double mean = stats.mean(numbers);
        double variance = stats.variance(numbers);
        double median = stats.median(numbers);

        System.out.println();
        System.out.printf(Locale.US, "Mean: %.6f%n", mean);
        System.out.printf(Locale.US, "Variance: %.6f%n", variance);
        System.out.printf(Locale.US, "Median: %.6f%n", median);

        int[] frequencies = stats.freq();

        printFrequencies(frequencies);

        AGraphics graphic = new Graphic();
        graphic.draw(frequencies);
    }

    private static void printNumbers(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("No numbers to print.");
            return;
        }

        System.out.println("Generated numbers:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf(Locale.US, "%3d: %.6f%n", i + 1, numbers[i]);
        }
    }

    private static void printFrequencies(int[] frequencies) {
        if (frequencies == null || frequencies.length == 0) {
            System.out.println("No frequencies to print.");
            return;
        }

        System.out.println();
        System.out.println("Frequency table:");

        for (int i = 0; i < frequencies.length; i++) {
            double start = i / 10.0;
            double end = (i + 1) / 10.0;

            if (i == frequencies.length - 1) {
                System.out.printf(Locale.US, "[%.1f, %.1f]: %d%n", start, end, frequencies[i]);
            } else {
                System.out.printf(Locale.US, "[%.1f, %.1f): %d%n", start, end, frequencies[i]);
            }
        }
    }
}

// Dùng lệnh javac *.java
// Dùng lệnh java Main
// Chương trình sẽ chạy