/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wincomplm.part.naming.nikosp.impl.ui.forms;

import com.ptc.core.components.beans.ObjectBean;
import com.ptc.core.components.forms.DefaultObjectFormProcessor;
import com.ptc.core.components.forms.FormProcessingStatus;
import com.ptc.core.components.forms.FormResult;
import com.ptc.core.components.util.FeedbackMessage;
import com.ptc.core.ui.resources.FeedbackType;
import com.ptc.netmarkets.util.beans.NmCommandBean;
import com.wincomplm.part.naming.nikosp.impl.helpers.PartCreationHelper;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import java.util.List;
import wt.session.SessionHelper;
import wt.util.WTException;

/**
 *
 * @author Mateo
 */
@WexComponent(uid = "WexPartNamingFormProcessor", description = "Part Naming From NikosP")
public class WexPartNamingFormProcessor extends DefaultObjectFormProcessor {

    private static IWexLogger logger = WexLogger.getLogger(WexPartNamingFormProcessor.class);

    @Override
    public FormResult doOperation(NmCommandBean ncb, List<ObjectBean> list) throws WTException {
        logger.trace("=>doOperation @Override");
        FormResult result = new FormResult(FormProcessingStatus.SUCCESS);
        PartCreationHelper helper = new PartCreationHelper();
        try {

            String wtPartPrefix = (String) ncb.getText().get("partNumberingNikosPPrefix");
            helper.createPart(wtPartPrefix);
            result.setStatus(FormProcessingStatus.SUCCESS);
            result.addFeedbackMessage(new FeedbackMessage(FeedbackType.SUCCESS, SessionHelper.getLocale(), "Nikos Part Naming", null, "Custom Part was created successfully."));

        } catch (Exception e) {
            return reportFailure("Failed to create part " + e.getLocalizedMessage(), e);
        }

        logger.trace("<=doOperation @Override");
        return result;
    }

    private FormResult reportFailure(String txtmessage, Exception e) throws WTException {

        logger.error("=>reportFailure " + txtmessage + " {0}", e);
        FormResult result;
        result = new FormResult(FormProcessingStatus.FAILURE);
        FeedbackMessage message = new FeedbackMessage(FeedbackType.FAILURE, null, txtmessage, null);
        result.addFeedbackMessage(message);
        logger.error("<=reportFailure ");
        return result;
    }

}
