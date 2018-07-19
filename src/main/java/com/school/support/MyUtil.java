/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Zakaria
 */
public class MyUtil {
      static Calendar cal;
//    int day = cal.get(Calendar.DAY_OF_MONTH);
//    int month = cal.get(Calendar.MONTH);
//    int year = cal.get(Calendar.YEAR);
    
    public static int getCurrentMonth(){
        if(cal==null){
        cal = Calendar.getInstance();
        }
        return cal.get(Calendar.MONTH)+1;
    }
     public static String getDate(){
       SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy");
        Date date=new Date();
        String dateString = formatter.format(date);
        return dateString;
    }
    public static Date getDateFromString(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(date);
    }
    
    public static void print(String name,String data){
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(name+":");
        System.out.println("\t"+data);
        System.out.println("-------------------------------------------------------------------------");

    }
}
