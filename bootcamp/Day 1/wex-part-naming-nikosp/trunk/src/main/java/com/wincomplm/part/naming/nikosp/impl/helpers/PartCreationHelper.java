/*
 *  Copyright (c) 2020 Wincom Consulting S.L.
 *  All Rights Reserved.
 *  This source is subject to the terms of a software license agreement.
 *  You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.part.naming.nikosp.impl.helpers;

import com.wincomplm.wex.course.commons.impl.helpers.BootcampAPIHelper;
import com.wincomplm.wex.course.commons.impl.helpers.PartNameHelper;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import com.wincomplm.wex.wt.framework.commons.persist.WexQueryHelper;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wt.fc.QueryResult;
import wt.part.WTPart;
import wt.util.WTException;
import wt.util.WTPropertyVetoException;

/**
 *
 * @author Nikolaos Papadakis (npapadakis@wincom-plm.com)
 */
@WexComponent(uid = "wex-naming-helper", description = "Wex Part Naming")
public class PartCreationHelper {

    private static IWexLogger logger = WexLogger.getLogger(PartCreationHelper.class);

    @WexMethod(name = "create-part", description = "Create part")
    public String createPart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.trace("=> createPart");
        String productName = "Bootcamp"; // Can become a config or a wizard option
        String partType = "wt.part.WTPart"; // Can become a config or a wizard option
        String namePrefix = "NikosPrefix"; // Can become a config or a wizard option
     //   String calculatedName = PartNameHelper.instance.createPartCommons(namePrefix, productName, partType); // Replaced
        String calculatedName = createPart(namePrefix, productName, partType);
        logger.warn("We create a new part {0}", calculatedName);
        logger.trace("<= createPart {0}", calculatedName);
        return calculatedName;
    }

    @WexMethod(name = "create-part-feedback", description = "Create part")
    public String createPartFeedback(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String namePrefix = "NikosPrefix"; // Can become a config or a wizard option
        QueryResult qrNumber = BootcampAPIHelper.instance.getQueryResult(BootcampAPIHelper.instance.getQuerySpecNameCourse(namePrefix.toUpperCase(), WTPart.class)); // this have to be changed to handle other types
        List<WTPart> listFromQueryResult = WexQueryHelper.getListFromQueryResult(qrNumber);
        return "Before this part we have created another " + listFromQueryResult.size() + " parts";
    }

    private String createPart(String namePrefix, String productName, String partType) throws WTException, Exception, WTPropertyVetoException {
        logger.trace("=> createPart");
        QueryResult qrNumber = BootcampAPIHelper.instance.getQueryResult(BootcampAPIHelper.instance.getQuerySpecNameCourse(namePrefix.toUpperCase(), WTPart.class)); // this have to be changed to handle other types
        List<WTPart> listFromQueryResult = WexQueryHelper.getListFromQueryResult(qrNumber);
        logger.trace("Parts already found: {0}", listFromQueryResult.size());
        String calculatedName = PartNameHelper.instance.calculateName(listFromQueryResult, namePrefix);
        PartNameHelper.instance.createPart(calculatedName, namePrefix, productName, partType);
        logger.trace("<= createPart");
        return calculatedName;
    }

}
