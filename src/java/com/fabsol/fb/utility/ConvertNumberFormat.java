package com.fabsol.fb.utility;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ConvertNumberFormat {

    private static final String[] tensNames = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
    private static final String[] numNames = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};

    private static String convertLessThanOneThousand(int number) {
        String soFar = null;
        if (number % 100 < 20) {
            soFar = numNames[(number % 100)];
            number /= 100;
        } else {
            soFar = numNames[(number % 10)];
            number /= 10;

            soFar = tensNames[(number % 10)] + soFar;
            number /= 10;
        }
        if (number == 0) {
            return soFar;
        }
        return numNames[number] + " Hundred" + soFar;
    }

    public static String convertToWords(long number) {
        if (number == 0L) {
            return "Zero";
        }
        String snumber = Long.toString(number);

        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        int billions = Integer.parseInt(snumber.substring(0, 3));

        int millions = Integer.parseInt(snumber.substring(3, 6));

        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));

        int thousands = Integer.parseInt(snumber.substring(9, 12));

        String tradBillions = null;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertLessThanOneThousand(billions) + " Billion ";

                break;
            default:
                tradBillions = convertLessThanOneThousand(billions) + " Billion ";
        }
        String result = tradBillions;
        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            case 1:
                tradMillions = convertLessThanOneThousand(millions) + " Million ";

                break;
            default:
                tradMillions = convertLessThanOneThousand(millions) + " Million ";
        }
        result = result + tradMillions;

        String tradHundredThousands = null;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "One Thousand ";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(hundredThousands) + " Thousand ";
        }
        result = result + tradHundredThousands;

        String tradThousand = null;
        tradThousand = convertLessThanOneThousand(thousands);
        result = result + tradThousand;

        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    public static String convertToWords(double number) {
        if (number == 0.0D) {
            return "Zero";
        }
        String snumber = String.format("%.2f", new Object[]{Double.valueOf(number)});
        String sdecimal = "0";
        int indexOf = snumber.indexOf(".");
        if (indexOf != -1) {
            sdecimal = snumber.substring(indexOf + 1, snumber.length());
            if (sdecimal.equals("00")) {
                sdecimal = "0";
            }
        }
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(Double.parseDouble(snumber.substring(0, snumber.indexOf("."))));

        int billions = Integer.parseInt(snumber.substring(0, 3));

        int millions = Integer.parseInt(snumber.substring(3, 6));

        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));

        int thousands = Integer.parseInt(snumber.substring(9, 12));

        String tradBillions = null;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertLessThanOneThousand(billions) + " Billion ";

                break;
            default:
                tradBillions = convertLessThanOneThousand(billions) + " Billion ";
        }
        String result = tradBillions;
        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            case 1:
                tradMillions = convertLessThanOneThousand(millions) + " Million ";

                break;
            default:
                tradMillions = convertLessThanOneThousand(millions) + " Million ";
        }
        result = result + tradMillions;

        String tradHundredThousands = null;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "One Thousand ";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(hundredThousands) + " Thousand ";
        }
        result = result + tradHundredThousands;

        String tradThousand = null;
        tradThousand = convertLessThanOneThousand(thousands);
        result = result + tradThousand + " Dollars" + " & " + sdecimal + "/100 Cents";

        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    public static String convertToThousandForamtInDollar(double number) {
        String snumber = String.format("%.2f", new Object[]{Double.valueOf(number)});
        String sdecimal = "0";
        int indexOf = snumber.indexOf(".");
        if (indexOf != -1) {
            sdecimal = snumber.substring(indexOf + 1, snumber.length());
            if (sdecimal.equals("00")) {
                sdecimal = "0";
            }
        }
        String result = String.format("%,.0f", new Object[]{Double.valueOf(Double.parseDouble(snumber.substring(0, snumber.indexOf("."))))}) + " " + sdecimal + "/100";
        return result;
    }

    public static String convertToThousandForamt(long number) {
        NumberFormat numberFormat = new DecimalFormat("#,###,###");
        String result = numberFormat.format(number);
        return result;
    }

    public static String convertToThousandForamt(double number) {
        String result = "";
        if ((String.valueOf(number).startsWith("0.")) || (String.valueOf(number).startsWith("-0."))) {
            result = String.valueOf(number);
        } else {
            NumberFormat numberFormat = new DecimalFormat("#,###,###.00");
            result = numberFormat.format(number);
        }
        return result;
    }
}
