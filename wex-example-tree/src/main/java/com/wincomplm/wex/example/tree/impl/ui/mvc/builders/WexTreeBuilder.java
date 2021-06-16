/*
 *  Copyright (c) 2019 Wincom Consulting S.L.
 *  All Rights Reserved.
 *  This source is subject to the terms of a software license agreement.
 *  You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.tree.impl.ui.mvc.builders;

import com.ptc.core.components.descriptor.DescriptorConstants.TableTreeProperties;
import com.ptc.core.htmlcomp.components.AbstractConfigurableTableBuilder;
import com.ptc.core.htmlcomp.tableview.ConfigurableTable;
import com.ptc.jca.mvc.components.JcaTreeConfig;
import com.ptc.mvc.components.ColumnConfig;
import com.ptc.mvc.components.ComponentBuilder;
import com.ptc.mvc.components.ComponentConfig;
import com.ptc.mvc.components.ComponentConfigFactory;
import com.ptc.mvc.components.ComponentParams;
import com.ptc.mvc.components.FindInTableMode;
import com.ptc.mvc.components.TreeConfig;
import com.ptc.mvc.components.ds.DataSourceMode;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import com.wincomplm.wex.system.impl.annotations.WexBean;
import wt.util.WTException;

/**
 * Example table
 * @author Simon
 */
@WexBean("com.wincomplm.wex-example-tree.wextree")
@WexComponent(uid = "com.wincomplm.wex-example-tree.wextree", description = "Wex Example Tree")
@ComponentBuilder("com.wincomplm.wex-example-tree.wextree")
public class WexTreeBuilder extends AbstractConfigurableTableBuilder {

    static IWexLogger logger = WexLogger.getLogger(WexTreeBuilder.class);
    
    @Override
    public ComponentConfig buildComponentConfig(ComponentParams cp) throws WTException {
        logger.trace("=>buildComponentConfig {0}", cp);
        ComponentConfigFactory factory = getComponentConfigFactory();

        TreeConfig tree = factory.newTreeConfig();
        //((JcaTreeConfig) tree).setDataSourceMode(DataSourceMode.ASYNCHRONOUS);
        tree.setLabel("Example Tree");
        
        ColumnConfig col = factory.newColumnConfig("wex-example-tree-data", true);
        col.setLabel("Data");
        tree.addComponent(col);
        
        tree.setFindInTableMode(FindInTableMode.CLIENT_ONLY);
       ((JcaTreeConfig) tree).setExpansionLevel(TableTreeProperties.ONE_EXPAND);
        tree.setShowTreeLines(true);
        tree.setShowCustomViewLink(false);
       

        logger.trace("<=buildComponentConfig");
        return tree;
    }//buildComponentConfig



    @Override
    public Object buildComponentData(ComponentConfig cc, ComponentParams cp) throws Exception {
        logger.trace("=>buildComponentData {0} {1}", cc, cp);
        WexExampleTreeHandler handler =  WexExampleTreeHandler.newWexExampleTreeHandler();
        logger.trace("<=buildComponentData");
        return handler;
    }//buildComponentData

    @Override
    public ConfigurableTable buildConfigurableTable(String string) throws WTException {
        return null;
    }
}
