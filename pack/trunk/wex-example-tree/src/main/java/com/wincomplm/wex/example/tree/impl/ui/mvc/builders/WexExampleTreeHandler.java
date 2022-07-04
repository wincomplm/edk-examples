/*
 * Copyright (c) 2014 Wincom Consulting S.L. 
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.tree.impl.ui.mvc.builders;

import com.ptc.core.components.beans.TreeHandlerAdapter;
import com.ptc.netmarkets.model.NmSimpleOid;
import com.wincomplm.wex.example.tree.impl.ui.model.WexTreeRow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wt.util.WTException;

/**
 *
 * @author Nassim Bouayad-Agha (nbouayad@wincom-consulting.com)
 */
public class WexExampleTreeHandler extends TreeHandlerAdapter {


    public static WexExampleTreeHandler newWexExampleTreeHandler() throws Exception {
        WexExampleTreeHandler instance = new WexExampleTreeHandler();
        instance.initialize();
        return instance;

    }


    protected void initialize() throws Exception {
    }
    

    @Override
    public Map<Object, List> getNodes(List list) throws WTException {
        Map<Object, List> result = new HashMap<Object, List>();
        for (Object object : list) {
            
            String key = "";
            if (object instanceof WexTreeRow) {
                key=((WexTreeRow) object).getData();
            } 
            // Watch out, sometimes we get just the reference            
            if (object instanceof NmSimpleOid) {
                 key= ((NmSimpleOid) object).getInternalName();                                
            } 
            
            if (key.equals("Root")) {              
                String[] kids = {"kid 1","kid 2"};
                addKids( object, result, kids);
            }
            if (key.equals("kid 1")) {              
                String[] kids = {"gkid 1","gkid 2"};
                addKids(object, result, kids);
            }
                
        }
        return result;
    }

    private void addKids(Object o, Map<Object, List> result, String[] kids) {
        System.out.println("addKids " + kids);
        List children = new ArrayList();
        result.put(o, children);
        for (String kid : kids) {
            children.add(WexTreeRow.newWexTreeRow(kid));
        }
    }


    @Override
    public List<Object> getRootNodes() throws WTException {
        try {
            List<Object> result = new ArrayList<Object>();
            result.add(WexTreeRow.newWexTreeRow("Root"));
            return result;
        } catch (Exception e) {
            throw new WTException(e);
        }
    }


}
