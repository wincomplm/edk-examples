function action_SearchMultipleParts(data, params) {
    var WindchillRequester = Java.type('com.wincomplm.wex.kernel.api.invoke.WexInvoker');
    return WindchillRequester.invoke("com.wincomplm.wex-example-rest","wex-example-rest-methods.search-all-parts",data, params);
    
}