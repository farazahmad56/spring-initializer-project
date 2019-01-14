package com.fabsol.fb.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class Util {

    public static String removeSpecialChar(String st) {
        if (st != null) {
            st = st.replace('\'', '`');
        } else {
            st = "";
        }
        return st;
    }

    public static int numOfdays(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / 86400000L);
    }

    public static int numOfdays(String month) {
        int days = 0;
        try {
            Date date = new SimpleDateFormat("dd-MMM-yyyy").parse("01-" + month.toUpperCase());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            days = cal.getActualMaximum(5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return days;
    }

    public static int numOfWeeks(String month, String year) {
        Calendar weeks = new GregorianCalendar();
        weeks.set(5, 1);
        weeks.set(2, Integer.parseInt(month) - 1);
        weeks.set(1, Integer.parseInt(year));
        return weeks.getActualMaximum(4);
    }

    public static String[] getStartEndDateByGiventMonth(String month) {
        String[] dt = new String[2];
        SimpleDateFormat dateFormat = null;
        try {
            dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            Date date = dateFormat.parse("01-" + month.toUpperCase());
            Calendar cal = Calendar.getInstance();
            dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            cal.setTime(date);
            dt[0] = dateFormat.format(cal.getTime());
            cal.set(5, cal.getActualMaximum(5));
            dt[1] = dateFormat.format(cal.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dt;
    }

    public static String getEndDateByGivenMonth(String month) {
        String dt = "";
        SimpleDateFormat dateFormat = null;
        try {
            dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            Date date = dateFormat.parse("01-" + month.toUpperCase());
            Calendar cal = Calendar.getInstance();
            dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            cal.setTime(date);
            cal.add(2, -1);
            cal.set(5, cal.getActualMaximum(5));
            dt = dateFormat.format(cal.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dt;
    }

    public static String getNextDateByGivenDate(String date, String datePattern) {
        String previousDate = "";
        SimpleDateFormat dateFormat = null;
        try {
            dateFormat = new SimpleDateFormat(datePattern);
            Date dt = dateFormat.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            cal.add(5, 1);
            dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            previousDate = dateFormat.format(cal.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return previousDate;
    }

    public static String getPreviousDateByGivenDate(String date, String datePattern) {
        String previousDate = "";
        SimpleDateFormat dateFormat = null;
        try {
            dateFormat = new SimpleDateFormat(datePattern);
            Date dt = dateFormat.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            cal.add(5, -1);
            dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            previousDate = dateFormat.format(cal.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return previousDate;
    }

    public static String getPreviousMonthByGivenMonth(String month, String datePattern) {
        String previousMonth = "";
        SimpleDateFormat dateFormat = null;
        try {
            dateFormat = new SimpleDateFormat(datePattern);
            Date dt = dateFormat.parse("01-" + month.toUpperCase());
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            cal.add(2, -1);
            dateFormat = new SimpleDateFormat("MMM-yyyy");
            previousMonth = dateFormat.format(cal.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return previousMonth;
    }

    public static String getNextMonthByGivenMonth(String month, String datePattern) {
        String previousMonth = "";
        SimpleDateFormat dateFormat = null;
        try {
            dateFormat = new SimpleDateFormat(datePattern);
            Date dt = dateFormat.parse("01-" + month.toUpperCase());
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            cal.add(2, 1);
            dateFormat = new SimpleDateFormat("MMM-yyyy");
            previousMonth = dateFormat.format(cal.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return previousMonth;
    }

    public static String getDueDate(String date, String datePattern, String CrDays) {
        String previousDate = "";
        SimpleDateFormat dateFormat = null;
        try {
            dateFormat = new SimpleDateFormat(datePattern);
            Date dt = dateFormat.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            cal.add(5, Integer.parseInt(CrDays));
            dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            previousDate = dateFormat.format(cal.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return previousDate;
    }

    public static List<String> convertArrayToList(String[] input) {
        List<String> list = new ArrayList();
        if (input != null) {
            for (int i = 0; i < input.length; i++) {
                list.add(input[i]);
            }
        }
        return list;
    }

    public static String convertArrayToString(String[] input) {
        String output = "";
        if (input != null) {
            for (int i = 0; i < input.length; i++) {
                if (i != input.length - 1) {
                    output = output + "" + input[i].trim() + ", ";
                } else {
                    output = output + "" + input[i].trim() + "";
                }
            }
        }
        return output;
    }

    public static String assignSingleQouteToString(String input) {
        String output = "";
        String[] strArray = input.split(",");
        for (int i = 0; i < strArray.length; i++) {
            if (i != strArray.length - 1) {
                output = output + "'" + strArray[i].trim() + "', ";
            } else {
                output = output + "'" + strArray[i].trim() + "'";
            }
        }
        return output;
    }

    public static String renameFileName(String input) {
        String output = input != null ? input.trim().replace(" ", "_") : "";
        if (output.contains("%")) {
            output = output.replace("%", "_");
        }
        if (output.contains("?")) {
            output = output.replace("?", "_");
        }
        if (output.contains("#")) {
            output = output.replace("#", "_");
        }
        if (output.contains("&")) {
            output = output.replace("&", "_");
        }
        return output;
    }

    public static String generateCode() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString().toUpperCase();

        return saltStr;
    }

    public static boolean generateSms(String mobileNo, String message) {
        boolean flag = false;
        try {
            if ((mobileNo != null) && (!mobileNo.isEmpty()) && (mobileNo.length() == 11)) {
                if (mobileNo.startsWith("0")) {
                    mobileNo = mobileNo.substring(1, mobileNo.length());
                    mobileNo = "92" + mobileNo;
                } else {
                    mobileNo = "92" + mobileNo;
                }
            }
            String data = "id=" + URLEncoder.encode("ezimedic", "UTF-8");
            data = data + "&pass=" + URLEncoder.encode("treat135", "UTF-8");
            data = data + "&msg=" + URLEncoder.encode(message, "UTF-8");
            data = data + "&lang=" + URLEncoder.encode("English", "UTF-8");
            data = data + "&to=" + URLEncoder.encode(mobileNo, "UTF-8");
            data = data + "&mask=" + URLEncoder.encode("EZIMEDIC", "UTF-8");
            data = data + "&type=" + URLEncoder.encode("xml", "UTF-8");

            URL url = new URL("http://www.sms4connect.com/api/sendsms.php/sendsms/url");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String sResult = "";
            String line;
            while ((line = rd.readLine()) != null) {
                sResult = sResult + line + " ";
            }
            System.out.println(sResult);
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
