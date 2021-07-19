package com.wincomplm.wex.example.rest.impl.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ptc.core.businessfield.common.BusinessField;
import com.ptc.core.businessfield.common.BusinessFieldIdFactoryHelper;
import com.ptc.core.businessfield.common.BusinessFieldServiceHelper;
import com.ptc.core.businessfield.server.BusinessFieldIdentifier;
import com.ptc.core.businessfield.server.businessObject.BusinessObject;
import com.ptc.core.businessfield.server.businessObject.BusinessObjectHelper;
import com.ptc.core.businessfield.server.businessObject.BusinessObjectHelperFactory;
import com.ptc.core.command.common.CommandException;
import com.ptc.core.meta.common.AttributeTypeIdentifierSet;
import com.ptc.core.meta.common.DisplayOperationIdentifier;
import com.ptc.core.meta.common.TypeIdentifier;
import com.ptc.core.meta.type.command.typemodel.common.GetSchemaAttributesCommand;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;

import wt.fc.Persistable;
import wt.fc.PersistenceHelper;
import wt.fc.QueryResult;
import wt.part.WTPart;
import wt.part.WTPartMaster;
import wt.pds.StatementSpec;
import wt.query.ArrayExpression;
import wt.query.ClassAttribute;
import wt.query.QuerySpec;
import wt.query.SearchCondition;
import wt.session.SessionHelper;
import wt.type.ClientTypedUtility;
import wt.util.WTException;
import wt.vc.Mastered;
import wt.vc.VersionControlHelper;

public class BatchSearch {

    private static IWexLogger logger = WexLogger.getLogger(BatchSearch.class);
    private static final String AGCO_PART_TYPE = "WCTYPE|wt.part.WTPart|com.agcocorp.eame.AGCOPart";

    /**
     * This method returns a JSONObject containing information about WTParts and
     * their attributes. The WTParts are located using the part numbers
     * specified in the input ArrayExpression.
     *
     * @param partNumbers an ArrayExpression object containing one or more
     * WTPart numbers
     * @return JSONObject a JSONObject containing information about all WTParts
     * located
     */
    public static JSONObject getParts(ArrayExpression partNumbers) throws JSONException {
        logger.trace("=>getParts");
        QueryResult results = null;
        try {
            logger.info("Searching for : " + partNumbers.toString());
            QuerySpec querySpec = new QuerySpec(WTPartMaster.class);
            ClassAttribute numberId = new ClassAttribute(WTPartMaster.class, WTPartMaster.NUMBER);
            SearchCondition condition3 = new SearchCondition(numberId, SearchCondition.IN, partNumbers);
            querySpec.appendWhere(condition3, new int[0]);
            results = PersistenceHelper.manager.find((StatementSpec) querySpec);
            // use the WTPartMasters to get the latest Design versions of all WTParts
            ArrayList<WTPart> latestParts = createLatestPartsArray(results);
            logger.trace("<=getParts");
            return getBusinessAtts(latestParts);
        } catch (WTException wte) {
            logger.error("Caught an error locating part(s)"
                    + ". Exception follows : \n" + wte.getLocalizedMessage());
            logger.trace("<=getParts");
            // TODO: this should probably be cleaned up. Will it get cleaned up? Let's find out!
            return null;
        }
    }

    /*
	 * Given a list of WTPartMasters this method returns a list of the latest WTParts located using the getLatestDesignVersionOfMaster() method.
	 * @param  masters  a QueryResult containing WTPartMasters
	 * @return  ArrayList<WTPart>  an ArrayList containing the latest Design version of all WTPartMasters specified in the input parameter
     */
    private static ArrayList<WTPart> createLatestPartsArray(QueryResult masters) {
        logger.trace("=>createLatestPartsArray");
        ArrayList<WTPart> latestParts = new ArrayList<WTPart>();
        while (masters.hasMoreElements()) {
            WTPartMaster master = (WTPartMaster) masters.nextElement();
            WTPart latest = getLatestDesignVersionOfMaster(master);
            logger.trace("Located " + latest.getDisplayIdentifier());
            latestParts.add(latest);
        }
        logger.trace("<=createLatestPartsArray " + latestParts.size());
        return latestParts;
    }

    /*
	 * This method will return the latest Design version of the given WTPartMaster.
	 * @param  master  a WTPartMaster
	 * @return WTPart  the latest Design version
     */
    private static WTPart getLatestDesignVersionOfMaster(WTPartMaster master) {
        logger.trace("=>getLatestDesignVersionOfMaster " + master.getNumber());
        WTPart latestPart = null;
        QueryResult qr = null;
        try {
            // get all versions of the given master, hypothetically returned in order from newest to oldest
            qr = VersionControlHelper.service.allVersionsOf((Mastered) master);
        } catch (WTException wte) {
            logger.error("Caught an exception while trying to find the latest version of a WTPartMaster.", wte);
        } finally {
            if (qr != null) {
                logger.debug("Unique iterations of part " + qr.size());
                while (qr.hasMoreElements()) {
                    latestPart = (WTPart) qr.nextElement();
                    logger.debug("Part is " + latestPart.getNumber());
                    String view = latestPart.getViewName();
                    logger.debug("Part view is " + view);
                    if (view.equalsIgnoreCase("Design")) {
                        break;
                    } else {
                        logger.trace("Continuing because current part is not a Design part.");
                        latestPart = null;
                        continue;
                    }
                }
            }
        }
        logger.trace("<=getLatestDesignVersionOfMaster " + latestPart.getDisplayIdentifier());
        return latestPart;
    }

    /*
	 * This method returns an ArrayList containing the names of all attributes located for the given Windchill type.
	 * 
	 * See CS289935 for further information about this implementation.
	 * 
	 * @param  typeName  the internal name of a Windchill type.
	 * @return  ArrayList<String>  containing all attribute names located for the given type.
     */
    @SuppressWarnings({"rawtypes"})
    private static ArrayList<String> getAllAttributes(String typeName) throws CommandException, WTException {
        logger.trace("=>getAllAttributes " + typeName);
        ArrayList<String> attributes = new ArrayList<String>();
        try {
            TypeIdentifier typeId = ClientTypedUtility.getTypeIdentifier(typeName);
            GetSchemaAttributesCommand cmd = new GetSchemaAttributesCommand();
            cmd.setType_id(typeId);
            AttributeTypeIdentifierSet set = ((GetSchemaAttributesCommand) cmd.execute()).getAttributes();

            Iterator iterator = set.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                String next = iterator.next().toString();
                logger.debug(i + " Attribute element: " + next + ", class:" + next.getClass().toString());
                // trim up the attribute names to get the internal names that can be loaded using the BusinessObjectHelper
                String shortName = next.substring(next.lastIndexOf("~") + 1);
                logger.debug("Short name is " + shortName);
                attributes.add(shortName);
                i++;
            }
        } catch (WTException wte) {
            logger.error("Caught exception processing attributes for " + typeName);
        }
        logger.trace("<=getAllAttributes");
        return attributes;
    }

    /*
	 * Given an ArrayList of WTParts, this method finds all MBA and IBA objects for the AGCO_PART_TYPE, retrieves the value of each attribute for each part,
	 * constructs a JSON object containing all relevant information about the part, and returns it.
	 * 
	 * See CS221988 for further information about this implementation.
     */
    private static JSONObject getBusinessAtts(ArrayList<WTPart> parts) {
        logger.trace("=>getBusinessAtts");
        JSONObject jsonObject = new JSONObject();
        JSONArray partsArray = new JSONArray();
        try {
            Object[] objArray = parts.toArray();
            Persistable[] persistables = Arrays.copyOf(objArray, objArray.length, Persistable[].class);
            final BusinessObjectHelper BUS_OBJ_HELPER = BusinessObjectHelperFactory.getBusinessObjectHelper();
            List<BusinessObject> bus_objs = BUS_OBJ_HELPER.newBusinessObjects(SessionHelper.getLocale(), new DisplayOperationIdentifier(),
                    false, persistables);
            ArrayList<String> atts = null;
            try {
                atts = getAllAttributes(AGCO_PART_TYPE);
            } catch (WTException wte) {
                logger.error("Caught " + wte);
            }

            Collection<BusinessField> bus_fields = new ArrayList<BusinessField>();

            if (atts != null) {
                Iterator<String> att_iterator = atts.iterator();
                while (att_iterator.hasNext()) {
                    String att = att_iterator.next();
                    // I don't know what SCA attrs are so I skipped those
                    // MBAs need special handling that isn't included here
                    if (att.startsWith("IBA")) {
                        att = att.substring(4);
                        bus_fields.add(getBusinessField(AGCO_PART_TYPE, att));
                    }
                }
            }

            BUS_OBJ_HELPER.load(bus_objs, bus_fields);
            int index = 0;
            for (BusinessObject bus_obj : bus_objs) {
                logger.debug("bus_obj " + bus_obj.getWTReference().getObject());
                Persistable p = bus_obj.getWTReference().getObject();
                if (p instanceof WTPart) {
                    WTPart part = (WTPart) p;
                    JSONObject partObject = new JSONObject();
                    //TODO: offload this probably
                    partObject.put("Number", part.getNumber());
                    partObject.put("View", part.getViewName());
                    partObject.put("Version", part.getVersionIdentifier().getValue() + "." + part.getIterationIdentifier().getValue());
                    for (BusinessField bus_field : bus_fields) {
                        try {
                            if (bus_field.getName() != null) {
                                if (bus_obj.get(bus_field) != null) {
                                    logger.debug(bus_field.getName() + " : " + bus_obj.get(bus_field));
                                    partObject.put(bus_field.getName(), bus_obj.get(bus_field));
                                }
                            }
                        } catch (WTException wte) {
                            logger.error("Caught exception processing " + bus_field.getName());
                        } catch (NullPointerException e) {
                            logger.error("Caught NPE processing " + bus_field);
                        }
                    }
                    partsArray.put(index, partObject);
                    index++;
                }
            }
            jsonObject.put("Parts", partsArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.trace("<=getBusinessAtts");
        return jsonObject;
    }

    /*
	 * This method returns the BusinessFieldIdentifier of the given attribute name for the given type name.
	 * 
	 * @param  type_name  the internal name of a Windchill type
	 * @param  attr_name  the internal name of a Windchill attribute
	 * @return  BusinessField  the BusinessField object describing the requested attribute for the requested type
     */
    private static BusinessField getBusinessField(final String type_name, final String attr_name) throws WTException {
        logger.trace("=>getBusinessField " + attr_name);
        BusinessFieldIdentifier bfid = BusinessFieldIdFactoryHelper.FACTORY.getTypeBusinessFieldIdentifier(attr_name, type_name);
        logger.trace("<=getBusinessField");
        return BusinessFieldServiceHelper.SERVICE.getBusinessField(bfid);
    }
}
