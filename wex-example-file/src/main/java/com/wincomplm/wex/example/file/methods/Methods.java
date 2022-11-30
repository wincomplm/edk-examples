/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.file.methods;


import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author simon
 */

@WexComponent(uid = "methods", description = "Wex File Methods")
public class Methods {

    @WexMethod(name = "test", description = "Upload file")
    public void test(HttpServletRequest httprequest, HttpServletResponse response) throws Exception {
       
        if (!ServletFileUpload.isMultipartContent(httprequest)) {
            throw new Exception("Invalid request");
        }
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(1000000);
        File repositoryPath = new File(System.getProperty("java.io.tmpdir"));
        diskFileItemFactory.setRepository(repositoryPath);
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setSizeMax(1000000);
        List<FileItem> items = servletFileUpload.parseRequest(httprequest);
        if (items.size()!=1) {
            throw new Exception("Invalid request");
        }
        InputStream wexFileIs = items.get(0).getInputStream();
        String filename = items.get(0).getName();
        if (filename==null) {
            System.out.println("No file");
            throw new Exception("No file given");
        }
        System.out.println("Filename: " + filename);
        System.out.println("Here we have a stream: " + wexFileIs);
        
    }//test
}
