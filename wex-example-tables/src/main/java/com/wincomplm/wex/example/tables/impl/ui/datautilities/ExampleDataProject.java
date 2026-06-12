/*
 * Copyright (c) 2019 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.tables.impl.ui.datautilities;

import com.ptc.core.components.descriptor.ModelContext;
import com.ptc.core.components.factory.AbstractDataUtility;
import com.ptc.core.components.rendering.guicomponents.GUIComponentArray;
import com.ptc.core.components.rendering.guicomponents.IconComponent;
import com.ptc.core.components.rendering.guicomponents.TextBox;
import com.wincomplm.wex.example.tables.impl.ui.model.WexTableRow;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexDataUtility;
import com.wincomplm.wex.wt.framework.api.system.WTConstants;
import wt.util.WTException;

/**
 *
 * @author Vlad-Tudor Marchis <vmarchis@wincom-plm.com>
 */
@WexDataUtility("wex-example-table-project")
@WexComponent(uid = "wex-example-table-project", description = "project")
public class ExampleDataProject extends AbstractDataUtility {

    static String JSPLOC = WTConstants.CODEBASE + "/netmarkets/jsp/com/wincomplm/wex/example/tables/";
    @Override
    public Object getDataValue(String string, Object o, ModelContext mc) throws WTException {
        if (!(o instanceof WexTableRow)) {
            return null;
        }
        GUIComponentArray result = new GUIComponentArray();
       TextBox tb = new TextBox();
       tb.setName("test");
       tb.setReadOnly(true);
       tb.setWidth(50);
        result.addGUIComponent(tb);
        String infojsp = JSPLOC +"search.jsp";
        String url = "javascript:wexOpen('wex-search-info' ,'" + infojsp + "')";
        IconComponent ic = getIcon(url,"Search...");
        result.addGUIComponent(ic);
        
        return result;
        
    }

    

    private IconComponent getIcon(String url, String tooltip) {
        IconComponent icon = new IconComponent();
        icon.setSrc(JSPLOC +"images/search.gif");
        if (url != null) {
            icon.setUrl(url);
        }
        icon.setTooltip(tooltip);
        return icon;
    }
    
    
}
