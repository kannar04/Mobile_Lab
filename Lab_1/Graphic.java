// Lớp phụ trách hiển thị biểu đồ tần suất dạng dọc trên console.
public class Graphic extends AGraphics {
    @Override
    public void draw(int[] frequencies) {
        if (frequencies == null || frequencies.length == 0) {
            System.out.println("Cannot draw histogram because frequency data is null or empty.");
            return;
        }

        int maxFrequency = findMaxFrequency(frequencies);

        if (maxFrequency == 0) {
            System.out.println("All frequencies are 0. Histogram has no columns to draw.");
            return;
        }

        System.out.println();
        System.out.println("Vertical Histogram:");

        // Vẽ từ hàng cao nhất xuống hàng thấp nhất để tạo biểu đồ dọc.
        for (int row = maxFrequency; row >= 1; row--) {
            System.out.printf("%3d |", row);

            for (int col = 0; col < frequencies.length; col++) {
                if (frequencies[col] >= row) {
                    System.out.print("  *");
                } else {
                    System.out.print("   ");
                }
            }

            System.out.println();
        }

        System.out.print("    +");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.print("---");
        }
        System.out.println();

        System.out.print("     ");
        for (int i = 1; i <= frequencies.length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        System.out.println();
        System.out.println("Actual frequencies:");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.printf("Interval %2d: %d%n", i + 1, frequencies[i]);
        }
    }

    // Tìm tần suất lớn nhất để biết chiều cao của biểu đồ.
    private int findMaxFrequency(int[] frequencies) {
        int max = frequencies[0];

        // Duyệt mảng để tìm cột cao nhất.
        for (int i = 1; i < frequencies.length; i++) {
            if (frequencies[i] > max) {
                max = frequencies[i];
            }
        }

        return max;
    }
}
