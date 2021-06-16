/*
 * Copyright (c) 2019 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.tree.impl.ui.datautilities;

import com.ptc.core.components.descriptor.ModelContext;
import com.ptc.core.components.factory.AbstractDataUtility;
import com.wincomplm.wex.example.tree.impl.ui.model.WexTreeRow;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexDataUtility;
import wt.util.WTException;

/**
 *
 * @author Vlad-Tudor Marchis <vmarchis@wincom-plm.com>
 */
@WexDataUtility("wex-example-tree-data")
@WexComponent(uid = "wex-example-tree-data", description = "Data")
public class ExampleDataUtil extends AbstractDataUtility {

    @Override
    public Object getDataValue(String string, Object o, ModelContext mc) throws WTException {
        if (!(o instanceof WexTreeRow)) {
            return null;
        }
        return ((WexTreeRow) o).getData();
    }

}
