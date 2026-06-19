package Module2.FinancialForecastingExample;

public class Forecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(
            double currentValue,
            double growthRate,
            int years) {

        // Base condition
        if (years == 0) {

            return currentValue;

        }

        // Recursive call
        return calculateFutureValue(
                currentValue,
                growthRate,
                years - 1) * (1 + growthRate);

    }

}