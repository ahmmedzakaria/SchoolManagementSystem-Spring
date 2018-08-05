/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.support;

import com.school.domain.entity.Marks;

/**
 *
 * @author Zakaria
 */
public class MarksManager {
    public static int getGradeid(Marks m){
        double marks=totalMarks(m);
        int id=0;
    if(marks>=80)
        {
            id=1;//System.out.print("A+");
        }
        else if(marks>=70 && marks<80)
        {
           id=2;//System.out.print("A");
        } 
        else if(marks>=60 && marks<70)
        {
            id=3;//System.out.print("A-");
        }
        else if(marks>=50 && marks<60)
        {
            id=4;//System.out.print("B");
        }
        else if(marks>=40 && marks<50)
        {
            id=5;//System.out.print("C");
        }
        else if(marks>=33 && marks<40)
        {
            id=6;//System.out.print("D");
        }
        else
        {
           id=7; //System.out.print("F");
        }
    return id;
    }
    
    public static double totalMarks(Marks mark){
        double total=mark.getWrittenMarks()+mark.getMcqMarks()+mark.getPracticalMarks();
        return total;
    }
}
