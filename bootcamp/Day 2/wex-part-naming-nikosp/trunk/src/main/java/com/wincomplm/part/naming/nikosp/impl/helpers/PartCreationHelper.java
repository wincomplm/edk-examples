/*
 *  Copyright (c) 2020 Wincom Consulting S.L.
 *  All Rights Reserved.
 *  This source is subject to the terms of a software license agreement.
 *  You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.part.naming.nikosp.impl.helpers;

import com.wincomplm.part.naming.nikosp.impl.config.PartNamingNikosPConfig;
import com.wincomplm.wex.config.impl.registry.WexConfigRegistry;
import com.wincomplm.wex.course.commons.impl.helpers.BootcampAPIHelper;
import com.wincomplm.wex.course.commons.impl.helpers.PartNameHelper;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import com.wincomplm.wex.wt.framework.commons.persist.WexQueryHelper;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wt.fc.QueryResult;
import wt.part.WTPart;

/**
 *
 * @author Nikolaos Papadakis (npapadakis@wincom-plm.com)
 */
@WexComponent(uid = "wex-part-creation-helper", description = "Wex Part Naming")
public class PartCreationHelper {

    private static IWexLogger logger = WexLogger.getLogger(PartCreationHelper.class);
    private PartNamingNikosPConfig config = (PartNamingNikosPConfig) WexConfigRegistry.instance.getConfiguration("com.wincomplm.wex-part-naming-nikosp");

    @WexMethod(name = "create-part", description = "Create part")
    public void createPart(String namePrefix) throws Exception {

        logger.trace("=> createPart");
        String productName = config.getContainer(); // Became configuration
        String partType = config.getType(); // Became configuration
        String folder = config.getFolder(); // Became configuration
        String calculatedName = PartNameHelper.instance.createPartCommons(namePrefix, folder, productName, partType);
        logger.warn("We create a new part {0}", calculatedName);
        logger.trace("<= createPart {0}", calculatedName);

    }

    @WexMethod(name = "calculate-name", description = "Calculate Name")
    public void calculateName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.trace("=> calculateName");
        String namePrefix = request.getParameter("name").toUpperCase();
        QueryResult qrNumber = BootcampAPIHelper.instance.getQueryResult(BootcampAPIHelper.instance.getQuerySpecNameCourse(namePrefix, WTPart.class));
        List<WTPart> listFromQueryResult = WexQueryHelper.getListFromQueryResult(qrNumber);

        String calculatedName = PartNameHelper.instance.calculateName(listFromQueryResult, namePrefix);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(calculatedName);
        logger.trace("<= calculateName");
    }

}
