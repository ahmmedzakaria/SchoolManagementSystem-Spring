/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;


import com.school.dao.JasperReportDAO;
import com.school.report.ReportInputForm;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author User
 */
@Controller
@RequestMapping("/report")
public class ReportController {

   @RequestMapping(value = "/marksreport/{sessionId}/{classId}/{sectionId}/{groupId}/{subjectId}/{examId}", method = RequestMethod.GET)
    public String marksReoprt(HttpServletRequest request,HttpServletResponse response,@PathVariable("sessionId") Integer sessionId,@PathVariable("classId") Integer classId,@PathVariable("sectionId") Integer sectionId,@PathVariable("groupId") Integer groupId
            ,@PathVariable("subjectId") Integer subjectId,@PathVariable("examId") Integer examId) throws JRException, IOException, SQLException, NamingException {
        
       String reportFileName = "SubjectiveResult";

        JasperReportDAO jrdao = new JasperReportDAO();

        Connection conn = null;

        try {
            conn = jrdao.getConnection();

           // String title = reportInputForm.getTitle();

            HashMap<String, Object> hmParams = new HashMap<String, Object>();

//            hmParams.put("sessionId", 1);
//            hmParams.put("classId", 6);
//            hmParams.put("sectionId", 1);
//            hmParams.put("groupId", 1);
//            hmParams.put("subjectId", 3);
            
            hmParams.put("sessionId", sessionId);
            hmParams.put("classId", classId);
            hmParams.put("sectionId", sectionId);
            hmParams.put("groupId", groupId);
            hmParams.put("subjectId", subjectId); 
            hmParams.put("examId", examId);


            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,
                    request);

                jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 


        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
       @RequestMapping(value = "/attendance/{sessionId}/{classId}/{sectionId}/{groupId}", method = RequestMethod.GET)
    public String attendanceReport(HttpServletRequest request,HttpServletResponse response,@PathVariable("sessionId") Integer sessionId,@PathVariable("classId") Integer classId,@PathVariable("sectionId") Integer sectionId,@PathVariable("groupId") Integer groupId) throws JRException, IOException, SQLException, NamingException {
        
       String reportFileName = "report2";

        JasperReportDAO jrdao = new JasperReportDAO();

        Connection conn = null;

        try {
            conn = jrdao.getConnection();

           // String title = reportInputForm.getTitle();

            HashMap<String, Object> hmParams = new HashMap<String, Object>();

//            hmParams.put("sessionId", 1);
//            hmParams.put("classId", 6);
//            hmParams.put("sectionId", 1);
//            hmParams.put("groupId", 1);
//            hmParams.put("subjectId", 3);
            
            hmParams.put("sessionId", sessionId);
            hmParams.put("classId", classId);
            hmParams.put("sectionId", sectionId);
            hmParams.put("groupId", groupId);

            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,
                    request);

                jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 


        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    @RequestMapping(value = "/reportView", method = RequestMethod.POST)
    public String generateReport(@ModelAttribute("reportInputForm") ReportInputForm reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
       // String reportFileName = "examResult";
       String reportFileName = "SubjectiveResult";

        JasperReportDAO jrdao = new JasperReportDAO();

        Connection conn = null;

        try {
            conn = jrdao.getConnection();

            String title = reportInputForm.getTitle();

            HashMap<String, Object> hmParams = new HashMap<String, Object>();

            hmParams.put("sessionId", 1);
            hmParams.put("classId", 6);
            hmParams.put("sectionId", 1);
            hmParams.put("groupId", 1);
            hmParams.put("subjectId", 3);

            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,
                    request);
            

//            if (rptFormat.equalsIgnoreCase("html")) {
//
//                JasperPrint jasperPrint = JasperFillManager.fillReport(
//                        jasperReport, hmParams, conn);
//                jrdao.generateReportHtml(jasperPrint, request, response); // For
//                // HTML
//                // report
//
//            } else if (rptFormat.equalsIgnoreCase("pdf")) {

                jrdao.generateReportPDF(response, hmParams, jasperReport, conn); // For
                // PDF
                // report

//            }

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
}
