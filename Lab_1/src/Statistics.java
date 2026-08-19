import java.util.Random;

// Cài đặt các phép toán thống kê được khai báo trong IStats.
public class Statistics implements IStats {
    // Lưu lại mảng số ngẫu nhiên để hàm freq() có thể tính tần suất.
    private double[] numbers;

    @Override
    public double[] generateRandomNumbers(int size) {

        numbers = new double[size];
        Random random = new Random();

        // Sinh các số ngẫu nhiên từ 0.0 đến nhỏ hơn 1.0.
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextDouble();
        }

        return numbers;
    }

    @Override
    public double mean(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        double sum = 0;

        // Cộng tất cả phần tử để tính giá trị trung bình.
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }

        return sum / numbers.length;
    }

    @Override
    public double variance(double[] numbers) {

        double meanValue = mean(numbers);
        double sumSquaredDifference = 0;

        // Tính tổng bình phương độ lệch của từng phần tử so với trung bình.
        for (int i = 0; i < numbers.length; i++) {
            double difference = numbers[i] - meanValue;
            sumSquaredDifference = sumSquaredDifference + difference * difference;
        }

        return sumSquaredDifference / numbers.length;
    }

    @Override
    public double median(double[] numbers) {

        double[] copiedNumbers = new double[numbers.length];

        // Sao chép dữ liệu để không làm thay đổi thứ tự của mảng gốc.
        for (int i = 0; i < numbers.length; i++) {
            copiedNumbers[i] = numbers[i];
        }

        bubbleSort(copiedNumbers);

        int middle = copiedNumbers.length / 2;

        // Nếu số phần tử lẻ, trung vị là phần tử ở giữa sau khi sắp xếp.
        if (copiedNumbers.length % 2 == 1) {
            return copiedNumbers[middle];
        }

        // Nếu số phần tử chẵn, trung vị là trung bình của hai phần tử giữa.
        return (copiedNumbers[middle - 1] + copiedNumbers[middle]) / 2;
    }

    @Override
    public int[] freq() {
        int[] frequencies = new int[10];

        // Đếm số lượng phần tử rơi vào từng khoảng 0.1.
        for (int i = 0; i < numbers.length; i++) {
            int index = (int) (numbers[i] * 10);

            // Trường hợp phòng vệ nếu có giá trị đúng bằng 1.0.
            if (index == 10) {
                index = 9;
            }

            if (index >= 0 && index < 10) {
                frequencies[index] = frequencies[index] + 1;
            }
        }

        return frequencies;
    }

    private void bubbleSort(double[] numbers) {
        // Sắp xếp mảng bằng thuật toán Bubble Sort.
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    double temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}
