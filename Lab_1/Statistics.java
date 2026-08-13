import java.util.Random;

public class Statistics implements IStats {
    private double[] numbers;

    @Override
    public double[] generateRandomNumbers(int size) {
        if (size <= 0) {
            System.out.println("Size must be greater than 0. Returning an empty array.");
            numbers = new double[0];
            return numbers;
        }

        numbers = new double[size];
        Random random = new Random();

        // Generate random numbers from 0.0 to less than 1.0
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextDouble();
        }

        return numbers;
    }

    @Override
    public double mean(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("Cannot calculate mean because the array is null or empty.");
            return 0;
        }

        double sum = 0;

        // Calculate the sum of all numbers
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }

        return sum / numbers.length;
    }

    @Override
    public double variance(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("Cannot calculate variance because the array is null or empty.");
            return 0;
        }

        double meanValue = mean(numbers);
        double sumSquaredDifference = 0;

        // Calculate the sum of squared differences from the mean
        for (int i = 0; i < numbers.length; i++) {
            double difference = numbers[i] - meanValue;
            sumSquaredDifference = sumSquaredDifference + difference * difference;
        }

        return sumSquaredDifference / numbers.length;
    }

    @Override
    public double median(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("Cannot calculate median because the array is null or empty.");
            return 0;
        }

        double[] copiedNumbers = new double[numbers.length];

        // Copy data so the original array is not changed
        for (int i = 0; i < numbers.length; i++) {
            copiedNumbers[i] = numbers[i];
        }

        bubbleSort(copiedNumbers);

        int middle = copiedNumbers.length / 2;

        if (copiedNumbers.length % 2 == 1) {
            return copiedNumbers[middle];
        }

        return (copiedNumbers[middle - 1] + copiedNumbers[middle]) / 2;
    }

    @Override
    public int[] freq() {
        int[] frequencies = new int[10];

        if (numbers == null || numbers.length == 0) {
            System.out.println("No data available. Please generate random numbers first.");
            return frequencies;
        }

        // Count numbers in each interval
        for (int i = 0; i < numbers.length; i++) {
            int index = (int) (numbers[i] * 10);

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
        // Sort the copied array using Bubble Sort
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
