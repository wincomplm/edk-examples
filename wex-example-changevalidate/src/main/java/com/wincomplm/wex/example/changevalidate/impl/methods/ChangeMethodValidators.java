package com.wincomplm.wex.example.changevalidate.impl.methods;

import com.wincomplm.wex.change.validate.adv.impl.model.WexChangeItemPlus;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import java.util.List;
import wt.fc.Persistable;

/**
 *
 * @author Daniel
 */
@WexComponent(uid = "wex-change-validators", description = "Wex Change Validators")
public class ChangeMethodValidators {

    @WexMethod(name = "validate-example-OK", description = "Will show an OK validation message")
    public static Object[] validateExampleOK(Persistable persistable, List<Persistable> items) {
        Object[] result = new Object[2];
        result[0] = "This is an OK message";
        result[1] = 0;  // 0 represents OK
        return result;
    }

    @WexMethod(name = "validate-example-ERROR", description = "Will show an ERROR validation message")
    public static Object[] validateExampleError(Persistable persistable, List<Persistable> items) {
        Object[] result = new Object[2];
        result[0] = "This is an error message";
        result[1] = 1;
        return result;
    }

    @WexMethod(name = "validate-example-WARN", description = "Will show a WARN validation message")
    public static Object[] validateExampleWARN(Persistable persistable, List<Persistable> items) {
        Object[] result = new Object[2];
        result[0] = "This is a WARN message";
        result[1] = 2;
        return result;
    }

    @WexMethod(name = "validate-example-IGN", description = "Will show an IGNORE validation message")
    public static Object[] validateExampleIGN(Persistable persistable, List<Persistable> items) {
        Object[] result = new Object[2];
        result[0] = "This is a IGNORE message";
        result[1] = 3;
        return result;
    }

    @WexMethod(name = "validate-example-OK-with-WexChangeItemPlus", description = "Will show an OK validation message (Example OK validator with WexChangeItemPlus)")
    public static Object[] validateExampleOK(WexChangeItemPlus item, List<WexChangeItemPlus> items) {
        Object[] result = new Object[2];
        result[0] = "This is an OK message";
        result[1] = 0;  // 0 represents OK
        return result;
    }

    @WexMethod(name = "validate-example-ERROR-with-WexChangeItemPlus", description = "Will show an ERROR validation message (Example ERROR validator with WexChangeItemPlus)")
    public static Object[] validateExampleWex2ParamsObjArray(WexChangeItemPlus item, List<WexChangeItemPlus> items) {
        Object[] result = new Object[2];
        result[0] = "This is an error message";
        result[1] = 1;
        return result;
    }

    @WexMethod(name = "validate-example-WARN-with-WexChangeItemPlus", description = "Will show a WARN validation message (Example WARN validator with WexChangeItemPlus)")
    public static Object[] validateExampleWARN(WexChangeItemPlus item, List<WexChangeItemPlus> items) {
        Object[] result = new Object[2];
        result[0] = "This is a WARN message";
        result[1] = 2;
        return result;
    }

    @WexMethod(name = "validate-example-IGN-with-WexChangeItemPlus", description = "Will show an IGNORE validation message (Example Ignore [IGN] validator with WexChangeItemPlus)")
    public static Object[] validateExampleIGN(WexChangeItemPlus item, List<WexChangeItemPlus> items) {
        Object[] result = new Object[2];
        result[0] = "This is an IGNORE message";
        result[1] = 3;
        return result;
    }
}
