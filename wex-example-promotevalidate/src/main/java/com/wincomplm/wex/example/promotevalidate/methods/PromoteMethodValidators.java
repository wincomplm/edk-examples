/*
 * Copyright (c) 2023 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */

package com.wincomplm.wex.example.promotevalidate.methods;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import java.util.List;
import wt.maturity.Promotable;

/**
 *
 * @author SimonHeath
 */
@WexComponent(uid = "wex-validators", description = "Wex Promotion Validators")
public class PromoteMethodValidators {

    @WexMethod(name = "validate-OK", description = "Will be ok")
    public Object[] validateOK(Promotable item, List items,String targetState) {
        Object[] result = new Object[2];
        result[0]="This is an OK message";
        result[1]=0;
        return result;
    }

    @WexMethod(name = "validate-error", description = "Will always throw an error")
    public Object[] validateError(Promotable item, List items,String targetState) {
        Object[] result = new Object[2];
        result[0]="This is an error message";
        result[1]=1;
        return result;
    }

    @WexMethod(name = "validate-warn", description = "Will always throw a warning")
    public Object[] validateWarn(Promotable item, List items,String targetState) {
        Object[] result = new Object[2];
        result[0]="This is an warning message";
        result[1]=2;
        return result;
    }


}
