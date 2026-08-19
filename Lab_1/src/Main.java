import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng xử lý thống kê thông qua interface IStats.
        IStats stats = new Statistics();

        // Sinh 100 số thực ngẫu nhiên trong khoảng [0.0, 1.0).
        double[] numbers = stats.generateRandomNumbers(100);

        printNumbers(numbers);

        // Tính các giá trị thống kê cơ bản từ mảng số vừa sinh.
        double mean = stats.mean(numbers);
        double variance = stats.variance(numbers);
        double median = stats.median(numbers);

        System.out.println();
        System.out.printf(Locale.US, "Mean: %.6f%n", mean);
        System.out.printf(Locale.US, "Variance: %.6f%n", variance);
        System.out.printf(Locale.US, "Median: %.6f%n", median);

        int[] frequencies = stats.freq();

        printFrequencies(frequencies);

        // Vẽ biểu đồ tần suất dựa trên bảng tần suất.
        AGraphics graphic = new Graphic();
        graphic.draw(frequencies);
    }

    // In toàn bộ danh sách số đã sinh ra màn hình.
    private static void printNumbers(double[] numbers) {

        System.out.println("Generated numbers:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf(Locale.US, "%3d: %.6f%n", i + 1, numbers[i]);
        }
    }

    // In bảng tần suất của 10 khoảng: [0.0, 0.1), ..., [0.9, 1.0].
    private static void printFrequencies(int[] frequencies) {

        System.out.println();
        System.out.println("Frequency table:");

        for (int i = 0; i < frequencies.length; i++) {
            double start = i / 10.0;
            double end = (i + 1) / 10.0;

            // Khoảng cuối cùng dùng dấu ] để bao gồm cả giá trị 1.0 nếu có.
            if (i == frequencies.length - 1) {
                System.out.printf(Locale.US, "[%.1f, %.1f]: %d%n", start, end, frequencies[i]);
            } else {
                System.out.printf(Locale.US, "[%.1f, %.1f): %d%n", start, end, frequencies[i]);
            }
        }
    }
}

// Biên dịch: javac *.java
// Chạy chương trình: java Main
