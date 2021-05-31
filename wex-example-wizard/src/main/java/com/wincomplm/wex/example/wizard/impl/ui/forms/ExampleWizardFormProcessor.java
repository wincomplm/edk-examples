/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.wizard.impl.ui.forms;

import com.ptc.core.components.beans.ObjectBean;
import com.ptc.core.components.forms.DefaultObjectFormProcessor;
import com.ptc.core.components.forms.FormProcessingStatus;
import com.ptc.core.components.forms.FormResult;
import com.ptc.netmarkets.util.beans.NmCommandBean;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import java.util.List;
import wt.util.WTException;

/**
 * Standard form processor
 * @author Branimir Sokolov<bsokolov@wincom-plm.com>
 */
@WexComponent(uid = "ExampleWizardFormProcessor", description = "Example form processor")
public class ExampleWizardFormProcessor extends DefaultObjectFormProcessor {
    private static IWexLogger logger = WexLogger.getLogger(ExampleWizardFormProcessor.class);
    @Override
    public FormResult doOperation(NmCommandBean ncb, List<ObjectBean> list) throws WTException {        
        logger.trace("=>doOperation");        
        FormResult result = new FormResult(FormProcessingStatus.SUCCESS);            
        logger.trace("<=doOperation {0}", result);
        return result;
    }        
}
