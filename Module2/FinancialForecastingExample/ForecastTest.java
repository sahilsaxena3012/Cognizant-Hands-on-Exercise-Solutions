package Module2.FinancialForecastingExample;

public class ForecastTest {

    public static void main(String[] args) {

        double currentValue = 10000;

        double growthRate = 0.10;
        // 10% growth

        int years = 5;

        double result = Forecast.calculateFutureValue(
                currentValue,
                growthRate,
                years);

        System.out.println(
                "Future Value after "
                        + years
                        + " years = "
                        + result);

    }

}