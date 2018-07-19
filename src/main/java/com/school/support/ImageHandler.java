/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template mainSource, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.support;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author User
 */
public class ImageHandler {

    public String upload(File mainSource, String subFolder) {
        if (mainSource != null) {
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
                String dbpath = servletContext.getRealPath("/");
                String webcut = dbpath.substring(0, dbpath.lastIndexOf("\\"));
                String buildcut = webcut.substring(0, webcut.lastIndexOf("\\"));
                String maniUrlPath = buildcut.substring(0, buildcut.lastIndexOf("\\"));
                //InputStream inputStream = mainSource.getInputstream();
               printPaths();
                String path = maniUrlPath + "\\SchoolManagement\\web\\resources\\" + subFolder + mainSource.getName();

                File destFile = new File(path);
                if (!destFile.exists()) {
                    //FileUtils.copyInputStreamToFile(inputStream, destFile);
                    //student.setImageName(mainSource.getFileName());
                    copyFile(mainSource, destFile);
                    return mainSource.getName();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void copyFile(File source, File distination) {
        try {
            Files.copy(source.toPath(), distination.toPath());
            //System.out.println("File Copied");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printPaths() {
         //String name=mainSource.getFileName();
//                System.out.println("->dbpath: " + dbpath);
//                System.out.println("->webcut: " + webcut);
//                System.out.println("->buildcut: " + buildcut);
//                System.out.println("->maniUrlPath: " + maniUrlPath);
//                System.out.println("->dbpath: " + dbpath);
//                //System.out.println("->destinationPaht: "+path);
//                System.out.println("->resourcePaht: " + mainSource.toString());
//                System.out.println("imageName: " + mainSource.getName());
//                System.out.println("name"+name+" "+name.lastIndexOf("\\"));
//                name=name.substring(name.lastIndexOf("\\"));
//                name=name.substring(1);
//            while(name.lastIndexOf(name, 0)>=0){
//                
//                System.out.println("name"+name+" "+name.indexOf(name, 0));
//            }

                //String path =maniUrlPath+"\\SchoolManagement\\web\\resources\\images\\"+name;
    }
}
