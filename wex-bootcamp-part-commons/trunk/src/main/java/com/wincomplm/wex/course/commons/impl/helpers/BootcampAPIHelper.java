/*
 *  Copyright (c) 2021 Wincom Consulting S.L.
 *  All Rights Reserved.
 *  This source is subject to the terms of a software license agreement.
 *  You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.course.commons.impl.helpers;

import com.ptc.core.meta.common.TypeIdentifier;
import com.ptc.core.meta.type.mgmt.server.impl.association.AssociationConstraintHelper;
import com.ptc.windchill.enterprise.copy.server.CoreMetaUtility;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import wt.fc.PersistenceHelper;
import wt.fc.QueryResult;
import wt.folder.FolderHelper;
import wt.inf.container.WTContainer;
import wt.inf.container.WTContainerRef;
import wt.pdmlink.PDMLinkProduct;
import wt.pds.StatementSpec;
import wt.query.QueryException;
import wt.query.QuerySpec;
import wt.query.SearchCondition;
import wt.type.Typed;
import wt.util.WTException;

/**
 *
 * @author Nikolaos Papadakis (npapadakis@wincom-plm.com)
 */
public class BootcampAPIHelper {

    private static IWexLogger logger = WexLogger.getLogger(BootcampAPIHelper.class);
    public static final BootcampAPIHelper instance = new BootcampAPIHelper();

    public QueryResult getQueryResult(QuerySpec qs) throws WTException {
        logger.trace("<=> getQueryResult");
        return PersistenceHelper.manager.find(qs);

    }

    public QuerySpec getQuerySpecNameCourse(String keyword, Class klass) throws QueryException, WTException {
        logger.trace("=> getQuerySpecNameCourse - {0}", keyword);
        QuerySpec qs = new QuerySpec(klass);
        qs.setAdvancedQueryEnabled(true);
        qs.appendWhere(new SearchCondition(klass, "master>name", SearchCondition.LIKE, keyword + "%", false), new int[]{0});
        logger.trace("<= getQuerySpecNameCourse");
        return qs;

    }

    public wt.folder.Folder getFolderWithCreate(WTContainerRef contRef, String folderPath) throws Exception {
        logger.trace("=> getFolderWithCreate - {0}", folderPath);
        wt.folder.Folder folder = null;
        try {
            folder = FolderHelper.service.getFolder(folderPath, contRef);
        } catch (Exception e) {
            logger.error("Cannot get folder Exception : {0}", e);
        }
        if (folder == null) {
            logger.trace("Folder not found, creating folder");
            folder = FolderHelper.service.createSubFolder(folderPath, contRef);

        }
        logger.trace("<= getFolderWithCreate");
        return folder;
    }

    public PDMLinkProduct getProductByName(String name) throws WTException {
        logger.trace("=> getProductByName - {0) ", name);
        QuerySpec qs = new QuerySpec(PDMLinkProduct.class);
        SearchCondition sc = new SearchCondition(WTContainer.class, PDMLinkProduct.NAME, SearchCondition.EQUAL, name);
        qs.appendWhere(sc, new int[]{0});
        StatementSpec sSpec = qs;
        QueryResult qr = PersistenceHelper.manager.find(sSpec);
        if (qr.size() == 0) {
            logger.trace("No results found");
            return null;
        }
        logger.trace("<= getProductByName");
        return (PDMLinkProduct) qr.nextElement();
    }

    public TypeIdentifier getTypeIdentifier(String s) throws Exception {
        logger.trace("=> getTypeIdentifier - {0) ", s);
        if (s.indexOf("|") != -1 && !s.startsWith("WCTYPE|")) {
            s = (new StringBuilder()).append("WCTYPE|").append(s).toString();
        }
        TypeIdentifier typeidentifier = AssociationConstraintHelper.getTypeIdentifier(s);
        logger.trace("<= getTypeIdentifier");
        return typeidentifier;
    }

    public Typed setType(TypeIdentifier typeidentifier, Typed thisTyped) throws WTException {
        logger.trace("=> setType");
        thisTyped = (Typed) CoreMetaUtility.setType(thisTyped, typeidentifier);
        logger.trace("<= setType");
        return thisTyped;
    }

}
