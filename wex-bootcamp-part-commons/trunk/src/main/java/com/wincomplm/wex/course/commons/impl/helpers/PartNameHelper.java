/*
 *  Copyright (c) 2021 Wincom Consulting S.L.
 *  All Rights Reserved.
 *  This source is subject to the terms of a software license agreement.
 *  You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.course.commons.impl.helpers;

import com.ptc.core.meta.common.TypeIdentifier;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import com.wincomplm.wex.wt.framework.commons.persist.WexQueryHelper;
import java.util.List;
import wt.fc.PersistenceHelper;
import wt.fc.QueryResult;
import wt.folder.FolderHelper;
import wt.inf.container.WTContainerRef;
import wt.part.WTPart;
import wt.pdmlink.PDMLinkProduct;
import wt.util.WTException;
import wt.util.WTPropertyVetoException;

/**
 *
 * @author Nikolaos Papadakis (npapadakis@wincom-plm.com)
 */
public class PartNameHelper {

    public static final PartNameHelper instance = new PartNameHelper();

    private static IWexLogger logger = WexLogger.getLogger(PartNameHelper.class);

    public String createPartCommons(String namePrefix, String productName, String partType) throws WTException, Exception, WTPropertyVetoException {
        return createPartCommons(namePrefix, namePrefix, productName, partType);
    }

    public String createPartCommons(String namePrefix, String folderName, String productName, String partType) throws WTException, Exception, WTPropertyVetoException {
        QueryResult qrNumber = BootcampAPIHelper.instance.getQueryResult(BootcampAPIHelper.instance.getQuerySpecNameCourse(namePrefix.toUpperCase(), WTPart.class));
        List<WTPart> listFromQueryResult = WexQueryHelper.getListFromQueryResult(qrNumber);
        String calculatedName = calculateName(listFromQueryResult, namePrefix.toUpperCase());
        createPart(calculatedName, folderName, productName, partType);
        return calculatedName;
    }

    private void createPart(String calculatedName, String folderName, String productName, String partType) throws WTPropertyVetoException, Exception, WTException {
        WTPart part = WTPart.newWTPart();
        part.setName(calculatedName);
        PDMLinkProduct product = BootcampAPIHelper.instance.getProductByName(productName);
        part.setContainer(product);
        part.setNumber(calculatedName);
        TypeIdentifier thisTypeIdentifier = BootcampAPIHelper.instance.getTypeIdentifier(partType);
        part = (WTPart) BootcampAPIHelper.instance.setType(thisTypeIdentifier, part);
        WTContainerRef containerRef = part.getContainerReference();
        wt.folder.Folder folder = BootcampAPIHelper.instance.getFolderWithCreate(containerRef, "/Default/" + folderName);
        FolderHelper.assignLocation(part, folder);
        PersistenceHelper.manager.save(part);
    }

    public String calculateName(List<WTPart> listFromQueryResult, String namePrefix) throws WTException {
        logger.trace("=> calculateName Name Prefix : {0}", namePrefix);
        {
            if (listFromQueryResult == null || listFromQueryResult.isEmpty()) {
                namePrefix = namePrefix + "-001";
            } else {
                String[] split = null;
                String higher = "000";
                for (WTPart part : listFromQueryResult) {
                    String number = null;
                    number = part.getNumber();
                    split = number.split("-");
                    if (split[1].compareTo(higher) >= 1) {
                        higher = split[1];
                    }
                }

                namePrefix = augmentAndReturn(higher, split);
            }
            logger.trace("<= calculateName Name Prefix : {0}", namePrefix);
            return namePrefix.replaceAll("\\[|\\]|,|%", "");
        }
    }

    public String augmentAndReturn(String higher, String[] split) throws NumberFormatException, WTException {
        logger.trace("=> augmentAndReturn");
        String name;
        int temp = Integer.parseInt(higher) + 1;
        if (temp < 10) {
            split[1] = "00" + Integer.toString(temp);
        } else if (temp < 100) {
            split[1] = "0" + Integer.toString(temp);
        } else {
            split[1] = Integer.toString(temp);
        }
        name = String.join("-", split);
        String newName = name;

        logger.trace("<= augmentAndReturn");
        return newName;
    }
}
