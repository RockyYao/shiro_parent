package shiro.common.utils;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilTest {


    @Test
    public void getNowStartDate() {
        try {
            Date nowStartDate =DateUtil.getNowStartDate();

            System.out.println(nowStartDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getLastStartDate() {
        try {
            Date lastStartDate = DateUtil.getLastStartDate();
            System.out.println(lastStartDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTimeDifference() {
    }

    @Test
    public void compareTime() {
    }

    @Test
    public void timeToString() {
    }

    @Test
    public void getCurrentDate() {
        System.out.println(DateUtil.getCurrentDate(new Date()));
    }

    @Test
    public void stringToDate() {
    }

    @Test
    public void getDateEndDate() {
    }
}