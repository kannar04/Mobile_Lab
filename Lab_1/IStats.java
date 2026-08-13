public interface IStats {
    double[] generateRandomNumbers(int size);

    double mean(double[] numbers);

    double variance(double[] numbers);

    double median(double[] numbers);

    int[] freq();
}
