
/*
 * Copyright (c) 2022 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.ui.impl.ui.methods;

import com.ptc.core.components.forms.FormProcessingStatus;
import com.ptc.core.components.forms.FormResult;
import com.ptc.netmarkets.model.NmOid;
import com.ptc.netmarkets.util.beans.NmCommandBean;
import com.ptc.netmarkets.util.misc.NmContext;
import com.ptc.netmarkets.util.misc.NmContextItem;
import com.wincomplm.wex.kernel.impl.annotations.WexActionMethod;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import wt.util.WTException;


/**
 *
 * @author SimonHeath
 */
@WexComponent(uid = "action-methods", description = "Example Actions")
public class ExampleActionMethods {

    @WexActionMethod("example-command")
    public static FormResult exampleCommand(NmCommandBean ncb) throws Exception {
        FormResult formResult = new FormResult();
        formResult.setStatus(FormProcessingStatus.SUCCESS);
        Set<Object> selected = getSelected(ncb, null, true);
        System.out.println("Selected:" + selected);
// Exaample download
//        String url = "netmarkets/jsp/com/wincomplm/wex/xxxx/update/xxxxx.jsp";
//        formResult.setNextAction(FormResultAction.JAVASCRIPT);
//        formResult.setJavascript("PTC.util.replaceURL(\"" + url + "\" , \"false\");");
        return formResult;
    }
 
    
   private static <T> Set<T> getSelected(NmCommandBean commandBean, Class<T> klass, boolean throwIfEmpty) throws WTException {
        Set<T> result = getNmOidList(commandBean.getSelected(), klass);
        return result;
    }

    private static <T> Set<T> getNmOidList(List objectList, Class<T> klass) throws WTException {
        Set<T> result = new HashSet<T>();
        for (int i = 0; i < objectList.size(); i++) {
            Object object = objectList.get(i);
            T o = getObject(object, klass);
            if (o == null) {
                continue;
            }
            result.add(o);
        }
        return result;
    }

    private static <T> T getObject(Object object, Class<T> klass) throws WTException {
        NmOid nmOid = null;
        if (object instanceof NmContext) {
            nmOid = ((NmContext) object).getTargetOid();
        } else if (object instanceof NmOid) {
            nmOid = ((NmOid) object);
        } else if (object instanceof NmContextItem) {
            nmOid = ((NmContextItem) object).getOid();
        }
        if (nmOid == null) {
            return null;
        }
        if (klass != null && !klass.isAssignableFrom(nmOid.getReferencedClass())) {
            return null;
        }
        return (T) nmOid.getRefObject();

    }
}
        
        
