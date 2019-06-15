/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.dao.JasperReportDAO;
import com.school.domain.support.CommonSupport;
import com.school.domain.support.StudentInfo;
import com.school.support.ISupportService;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Faculty
 */
@Controller
@RequestMapping("/marksinfo")
public class MarksController {

    @Qualifier(value = "marksService")
    @Autowired
    private ISupportService<StudentInfo> iMarksService;
   

    @RequestMapping("/home")
    public String home() {
        return "marks";
    }


//    @RequestMapping(value = "/markslist", method = RequestMethod.GET)
//    @JsonIgnore
//    public ResponseEntity<List<Marks>> getAllMarks() {
//        List<Marks> list = iMarksService.getAll();
//        return new ResponseEntity<List<Marks>>(list, HttpStatus.OK);
//    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<CommonSupport> getCommonSupportService() {
        CommonSupport service = iMarksService.getCommonSupportService();
        return new ResponseEntity<CommonSupport>(service, HttpStatus.OK);
    }
//    @RequestMapping(value = "/marks/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Marks> getUser(@PathVariable("id") Integer id) {
//        Marks obj = iMarksService.getById(id);
//        return new ResponseEntity<Marks>(obj, HttpStatus.OK);
//    }

    @RequestMapping(value = "/marks", method = RequestMethod.POST)
    public ResponseEntity<Void> addMarks(@RequestBody StudentInfo obj, UriComponentsBuilder builder) {
        boolean flag = iMarksService.add(obj);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/marks/{id}").buildAndExpand(1).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
@RequestMapping(value = "/marksreport/{sessionId}/{classId}/{sectionId}/{groupId}/{subjectId}", method = RequestMethod.GET)
    public String marksReoprt(HttpServletRequest request,HttpServletResponse response,@PathVariable("sessionId") Integer sessionId,@PathVariable("classId") Integer classId,@PathVariable("sectionId") Integer sectionId,@PathVariable("groupId") Integer groupId,@PathVariable("subjectId") Integer subjectId) throws JRException, IOException, SQLException, NamingException {
        
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
//    @RequestMapping(value = "/marks/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Marks> updateUser(@RequestBody Marks obj) {
//        iMarksService.update(obj);
//        return new ResponseEntity<Marks>(obj, HttpStatus.OK);
//    }

    @RequestMapping(value = "/marks/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        iMarksService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
