/*
 *  Copyright (c) 2019 Wincom Consulting S.L.
 *  All Rights Reserved.
 *  This source is subject to the terms of a software license agreement.
 *  You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.tables.impl.ui.mvc.builders;

import com.ptc.core.htmlcomp.components.AbstractConfigurableTableBuilder;
import com.ptc.core.htmlcomp.tableview.ConfigurableTable;
import com.ptc.jca.mvc.components.JcaTableConfig;
import com.ptc.mvc.components.ColumnConfig;
import com.ptc.mvc.components.ComponentBuilder;
import com.ptc.mvc.components.ComponentConfig;
import com.ptc.mvc.components.ComponentConfigFactory;
import com.ptc.mvc.components.ComponentParams;
import com.wincomplm.wex.example.tables.impl.ui.model.WexTableRow;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import com.wincomplm.wex.system.impl.annotations.WexBean;
import java.util.ArrayList;
import java.util.Collection;
import wt.util.WTException;

/**
 * Example table
 * @author Simon
 */
@WexBean("com.wincomplm.wex-example-tables.wextable")
@WexComponent(uid = "com.wincomplm.wex-example-tables.wextable", description = "Wex Example Table")
@ComponentBuilder("com.wincomplm.wex-example-tables.wextable")
public class WexTableBuilder extends AbstractConfigurableTableBuilder {

    static IWexLogger logger = WexLogger.getLogger(WexTableBuilder.class);
    
    @Override
    public ComponentConfig buildComponentConfig(ComponentParams cp) throws WTException {
        logger.trace("=>buildComponentConfig {0}", cp);
        ComponentConfigFactory factory = getComponentConfigFactory();
        JcaTableConfig table = (JcaTableConfig) factory.newTableConfig();
        table.setSelectable(false);
        table.setConfigurable(false);
        table.setLabel("Title");
        addColumn(factory, "data", "wex-default-du", "Example Data", 200, table);
        logger.trace("<=buildComponentConfig");
        return table;
    }//buildComponentConfig

    void addColumn(ComponentConfigFactory factory, String id, String dataUtilityId, String label, int size, JcaTableConfig table) {
        logger.trace("=>ComponentConfigFactory {0}", id);
        ColumnConfig btCol = factory.newColumnConfig(id, true);
        if (dataUtilityId != null) {
            btCol.setDataUtilityId(dataUtilityId);
        }
        btCol.setWidth(size);
        btCol.setLabel(label);
        table.addComponent(btCol);
        logger.trace("<=ComponentConfigFactory {0}", id);
    }//addColumn

    @Override
    public Object buildComponentData(ComponentConfig cc, ComponentParams cp) throws Exception {
        logger.trace("=>buildComponentData {0} {1}", cc, cp);
        Collection<WexTableRow> result = new ArrayList();
        result.add(WexTableRow.newWexTableRow("Row 1"));
        result.add(WexTableRow.newWexTableRow("Row 2"));
        logger.trace("<=buildComponentData");
        return result;
    }//buildComponentData

    @Override
    public ConfigurableTable buildConfigurableTable(String string) throws WTException {
        return null;
    }
}
