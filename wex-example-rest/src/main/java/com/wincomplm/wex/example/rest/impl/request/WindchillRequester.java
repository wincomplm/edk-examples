package com.wincomplm.wex.example.rest.impl.request;

import com.google.gson.Gson;

import com.ptc.odata.core.entity.action.ActionProcessorData;
import com.ptc.odata.core.entity.processor.ActionResult;
import com.ptc.odata.core.entity.property.EntityAttribute;
import com.ptc.odata.core.entity.property.PropertyValueType;
import com.wincomplm.wex.config.impl.helpers.WexConfigRegistryHelper;
import com.wincomplm.wex.config.impl.registry.WexConfigRegistry;
import com.wincomplm.wex.example.rest.impl.config.RestExampleConfig;
import com.wincomplm.wex.example.rest.impl.model.WexExamplePart;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import com.wincomplm.wex.wt.framework.commons.persist.WexQueryHelper;
import java.sql.Timestamp;
import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.data.EntityCollection;
import org.apache.olingo.commons.api.data.Parameter;
import org.apache.olingo.commons.api.data.Property;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wt.fc.PersistenceHelper;
import wt.fc.QueryResult;
import wt.part.WTPart;
import wt.query.QueryException;
import wt.query.QuerySpec;
import wt.query.SearchCondition;
import wt.session.SessionHelper;
import wt.util.WTException;

@WexComponent(uid = "wex-example-rest-methods", description = "Methods")
public class WindchillRequester {

    private static IWexLogger logger = WexLogger.getLogger(WindchillRequester.class);
    public static RestExampleConfig config = (RestExampleConfig) WexConfigRegistry.instance.getConfiguration(RestExampleConfig.class);

    @WexMethod(name = "hello-world", description = "Hello World")
    public String helloWorld(Object data, Object params) throws Exception {
        logger.trace("=>helloWorld");
        String result = "Hello " + SessionHelper.getPrincipal().getName() + " from Wex!";
        logger.trace("<=helloWorld " + result);
        return result;
    }

    @WexMethod(name = "search-all-parts", description = "Search all parts")
    public ActionResult searchAllParts(ActionProcessorData data, Map<String, Parameter> params) throws Exception {
        logger.trace("=>searchAllParts");
        // All items in the "Parts" array of the request body.
        EntityCollection obj = (EntityCollection) params.get("Parts").getValue();
        List<Entity> entityList = obj.getEntities();
        List<String> partNumbers = new ArrayList<String>();
        Iterator<Entity> entityIterator = entityList.iterator();
        // Get the "Number" from each individual object in the "Parts" array.
        while (entityIterator.hasNext()) {
            Entity ent = entityIterator.next();
            logger.debug("Ent is " + ent.toString());
            Property numberProp = ent.getProperty("Number");
            String number = numberProp.getValue().toString();
            logger.debug("Ent Number " + number);
            String[] numbers = number.split(",");
            partNumbers.addAll(Arrays.asList(numbers));
        }
        JSONObject jsonObject = new JSONObject(); // ADD DATA HERE
        ActionResult actionResult = new ActionResult();
        logger.debug("new actionResult");

        EntityAttribute retEntity = new EntityAttribute("Edm.String", null, PropertyValueType.PRIMITIVE, jsonObject.toString());
        logger.debug("retEntity " + retEntity.toString());
        actionResult.setReturnedObject(retEntity);
        logger.trace("<=searchAllParts " + jsonObject.toString());
        return actionResult;
    }

    @WexMethod(name = "getModifiedParts", description = "Gets modified parts from x days ago")
    public String getModifiedParts(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.trace("=>getModifiedParts");
        String daysAgo = config.getPartsFromDaysAgo();
        Calendar today = Calendar.getInstance();
        today.add(Calendar.DATE, -Integer.parseInt(daysAgo));
        Date fromDaysAgo = today.getTime();
        List<WTPart> parts = getModifiedPartsFrom(fromDaysAgo);
        List<WexExamplePart> exParts = new ArrayList();
        for (WTPart part : parts) {
            WexExamplePart exPart = new WexExamplePart();
            exPart.setNumber(part.getNumber());
            exPart.setOid(WexQueryHelper.getOid(part));
            exPart.setVersion(part.getVersionIdentifier().getValue() + "." + part.getIterationIdentifier().getValue());
            exParts.add(exPart);
        }
        Gson gson = new Gson();
        String result = gson.toJson(exParts);
        logger.trace("<=getModifiedParts");
        return result;
    }

    private List<WTPart> getModifiedPartsFrom(Date from) throws QueryException, WTException {
        QuerySpec qs = new QuerySpec(WTPart.class);
        qs.appendWhere(new SearchCondition(WTPart.class, WTPart.MODIFY_TIMESTAMP, SearchCondition.GREATER_THAN_OR_EQUAL, new Timestamp(from.getTime())), new int[]{0});
        QueryResult qr = PersistenceHelper.manager.find(qs);
        return WexQueryHelper.getListFromQueryResult(qr);
    }

}
