// Interface định nghĩa các thao tác thống kê cần có trong chương trình.
public interface IStats {
    // Sinh mảng gồm size số ngẫu nhiên trong khoảng [0.0, 1.0).
    double[] generateRandomNumbers(int size);

    // Tính giá trị trung bình của mảng số.
    double mean(double[] numbers);

    // Tính phương sai của mảng số.
    double variance(double[] numbers);

    // Tính trung vị của mảng số.
    double median(double[] numbers);

    // Tính tần suất của mảng số đã sinh theo 10 khoảng đều nhau.
    int[] freq();
}
