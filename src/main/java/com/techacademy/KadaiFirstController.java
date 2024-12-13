package com.techacademy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {
    @GetMapping("/dayofweek/{val}")
    public String displayDayOfWeek(@PathVariable String val) {
        try {
            // yyyyMMdd形式確認
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate.parse(val, formatter);

            String[] week_name = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            String year = val.substring(0,4);
            String month = val.substring(4, 6);
            String date = val.substring(6, 8);
            String result = "";

            // カレンダーにセット
            Calendar cl = Calendar.getInstance();
            cl.set(Calendar.YEAR, Integer.parseInt(year));
            cl.set(Calendar.MONTH, Integer.parseInt(month) - 1);
            cl.set(Calendar.DATE, Integer.parseInt(date));

            int week = cl.get(Calendar.DAY_OF_WEEK) - 1;
            result = week_name[week];

            return result;

        } catch (DateTimeParseException e) {
            return "yyyymmddの形式にしてください。";
        }
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        try {
            int res = 0;
            res = val1 + val2;
            return "実行結果 : " + res;
        } catch (Exception e) {
            return "エラーが発生しました: " + e.getMessage();
        }
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        try {
            int res = 0;
            res = val1 - val2;
            return "実行結果 : " + res;
        } catch (Exception e) {
            return "エラーが発生しました: " + e.getMessage();
        }
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        try {
            int res = 0;
            res = val1 * val2;
            return "実行結果 : " + res;
        } catch (Exception e) {
            return "エラーが発生しました: " + e.getMessage();
        }
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        try {
            int res = 0;
            res = val1 / val2;
            return "実行結果 : " + res;
        } catch (Exception e) {
            return "エラーが発生しました: " + e.getMessage();
        }
    }



}
