package com.wincomplm.wex.example.promotevalidate.methods;

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

    @WexMethod(name = "validate-test-change-objarray", description = "Will always throw an error")
    public static Object[] validateTestWex2ParamsObjArray(Persistable persistable, List<Persistable> items) {
        Object[] result = new Object[2];
        result[0] = "This is an error message";
        result[1] = 1;
        return result;
    }
    
    @WexMethod(name = "validate-test-OK", description = "Will always throw an error")
    public static Object[] validateTestOK(Persistable persistable, List<Persistable> items) {
        Object[] result = new Object[2];
        result[0] = "This is an OK message";
        result[1] = 0;
        return result;
    }
    
    @WexMethod(name = "validate-test-WARN", description = "Will always throw an error")
    public static Object[] validateTestWARN(Persistable persistable, List<Persistable> items) {
        Object[] result = new Object[2];
        result[0] = "This is a WARN message";
        result[1] = 2;
        return result;
    }
    
    @WexMethod(name = "validate-test-IGN", description = "Will always throw an error")
    public static Object[] validateTestIGN(Persistable persistable, List<Persistable> items) {
        Object[] result = new Object[2];
        result[0] = "This is a IGNORE message";
        result[1] = 3;
        return result;
    }
}
