/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.ui.impl.ui.validator;

import com.ptc.core.ui.validation.UIValidationCriteria;
import com.ptc.core.ui.validation.UIValidationKey;
import com.ptc.core.ui.validation.UIValidationStatus;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexValidator;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import com.wincomplm.wex.ui.commons.validators.WexAdminUIValidator;

/**
 * A validator that ensures that the menu only appears for admin users
 * 
 * We could inherit directly from DefaultUIComponentValidator
 * @author simon
 */
@WexValidator({"edkHelloWorld","edkHelloWorldNonPop"})
@WexComponent(uid = "wex-example-ui.validator", description = "Menu validator")
public class WexMenuAdminUIValidator extends WexAdminUIValidator { 

    private static IWexLogger logger = WexLogger.getLogger(WexMenuAdminUIValidator.class);    
    
    @Override
    public UIValidationStatus preValidateAction(UIValidationKey uivk, UIValidationCriteria uivc) {
        logger.trace("=>preValidateAction");        
        UIValidationStatus displayStatus = super.preValidateAction(uivk, uivc);

        // Uncomment to show for all users
        // displayStatus = UIValidationStatus.ENABLED;
        logger.trace("<=preValidateAction {0}", displayStatus.getDisplay());
        return displayStatus;      
    }//preValidateAction

}
