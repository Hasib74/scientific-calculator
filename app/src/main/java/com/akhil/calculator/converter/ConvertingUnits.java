package com.akhil.calculator.converter;

public class ConvertingUnits {

    private static final int MILLION = 1000000;
    private static final int TEN_THOUSAND = 10000;
    private static final double ACRE = 4046.86;
    private static final int THOUSAND = 1000;
    private static final int HUNDRED = 100;

    public static class Area {
        public double squareMillimeterToMeter(double millimeter) {
            return (millimeter / MILLION);
        }

        public double squareMeterToMillimeter(double meter) {
            return (meter * MILLION);
        }

        public double squareCentimeterToMeter(double centimeter) {
            return (centimeter / TEN_THOUSAND);
        }

        public double squareMeterToCentimeter(double meter) {
            return (meter * TEN_THOUSAND);
        }

        public double squareKilometerToMeter(double kilometer) {
            return (kilometer * MILLION);
        }

        public double squareMeterToKilometer(double meter) {
            return (meter / MILLION);
        }

        public double acreToMeter(double acre) {
            return (acre * ACRE);
        }

        public double squareMeterToAcre(double meter) {
            return (meter / ACRE);
        }

        public double hectareToMeter(double hectare) {
            return (hectare * TEN_THOUSAND);
        }

        public double squareMeterToHectare(double meter) {
            return (meter / TEN_THOUSAND);
        }
    }

    static class Length {
        double millimeterToMeter(double millimeter) {
            return (millimeter / THOUSAND);
        }

        double meterToMillimeter(double meter) {
            return (meter * THOUSAND);
        }

        double centimeterToMeter(double centimeter) {
            return (centimeter / HUNDRED);
        }

        double meterToCentimeter(double meter) {
            return (meter * HUNDRED);
        }

        double kilometerToMeter(double kilometer) {
            return (kilometer * THOUSAND);
        }

        double meterToKilometer(double meter) {
            return (meter / THOUSAND);
        }

        double inchToMeter(double inch) {
            return (inch / 39.3701);
        }

        double meterToInch(double meter) {
            return (meter * 39.3701);
        }

        double footToMeter(double foot) {
            return (foot / 3.28084);
        }

        double meterToFoot(double meter) {
            return (meter * 3.28084);
        }

        double yardToMeter(double yard) {
            return (yard / 1.09361);
        }

        double meterToYard(double meter) {
            return (meter * 1.09361);
        }

        double mileToMeter(double mile) {
            return (mile / 0.000621371);
        }

        double meterToMile(double meter) {
            return (meter * 0.000621371);
        }

        double nanometerToMeter(double millimeter) {
            return (millimeter / 1000000000);
        }

        double meterToNanometer(double meter) {
            return (meter * 1000000000);
        }

    }

    static class Temperature {
        double fahrenheitToKelvin(double fahrenheit) {
            return ((fahrenheit + 459.67) * 5 / 9);
        }

        double kelvinToFahrenheit(double kelvin) {
            return ((kelvin * 9 / 5) - 459.67);
        }

        double celsiusToKelvin(double celsius) {
            return (celsius + 273.15);
        }

        double kelvinToCelsius(double kelvin) {
            return (kelvin - 273.15);
        }
    }

    static class Weight {
        double milligramToKilogram(double milligram) {
            return (milligram / MILLION);
        }

        double kilogramToMilligram(double kilogram) {
            return (kilogram * MILLION);
        }

        double gramToKilogram(double gram) {
            return (gram / THOUSAND);
        }

        double kilogramToGram(double kilogram) {
            return (kilogram * THOUSAND);
        }

        double centigramToKilogram(double centigram) {
            return (centigram / 100000);
        }

        double kilogramToCentigram(double kilogram) {
            return (kilogram * 100000);
        }

        double decagramToKilogram(double decagram) {
            return (decagram / TEN_THOUSAND);
        }

        double kilogramToDecagram(double kilo) {
            return (kilo * TEN_THOUSAND);
        }

        double metricTonnesToKilogram(double metricTonnes) {
            return (metricTonnes * THOUSAND);
        }

        double kiloToMetricTonnes(double kilo) {
            return (kilo / THOUSAND);
        }

        double poundsToKilogram(double pounds) {
            return (pounds / 2.20462);
        }

        double kilogramToPounds(double kilo) {
            return (kilo * 2.20462);
        }

        double ouncesToKilogram(double ounces) {
            return (ounces / 35.274);
        }

        double kilogramToOunces(double kilo) {
            return (kilo * 35.274);
        }
    }
}
