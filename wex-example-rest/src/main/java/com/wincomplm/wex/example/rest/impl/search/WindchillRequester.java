package com.wincomplm.wex.example.rest.impl.search;

import com.ptc.odata.core.entity.action.ActionProcessorData;
import com.ptc.odata.core.entity.processor.ActionResult;
import com.ptc.odata.core.entity.property.EntityAttribute;
import com.ptc.odata.core.entity.property.PropertyValueType;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;

import wt.query.ArrayExpression;

import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.data.EntityCollection;
import org.apache.olingo.commons.api.data.Parameter;
import org.apache.olingo.commons.api.data.Property;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WexComponent(uid = "wex-example-rest-methods", description = "Methods")
public class WindchillRequester {

    private static IWexLogger logger = WexLogger.getLogger(WindchillRequester.class);

    public WindchillRequester() {
        logger.trace("=>WindchillRequester() -> initializing");
        logger.trace("<=WindchillRequester()");
    }

    
    @WexMethod(name = "search-all-parts", description = "Search all parts")
    // entry from custom ProdMgmt unbound action
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
        ArrayExpression expr = new ArrayExpression(partNumbers.toArray());
        JSONObject jsonObject = BatchSearch.getParts(expr);
        ActionResult actionResult = new ActionResult();
        logger.debug("new actionResult");

        EntityAttribute retEntity = new EntityAttribute("Edm.String", null, PropertyValueType.PRIMITIVE, jsonObject.toString());
        logger.debug("retEntity " + retEntity.toString());
        actionResult.setReturnedObject(retEntity);
        logger.trace("<=searchAllParts " + jsonObject.toString());
        return actionResult;
    }
}
