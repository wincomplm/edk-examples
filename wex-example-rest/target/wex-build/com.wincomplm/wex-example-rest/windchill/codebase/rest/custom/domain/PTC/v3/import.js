
function function_HelloWorld(data, params) {
    return "Hello World!";
}

function function_HelloWex(data, params) {
    var WindchillRequester = Java.type('com.wincomplm.wex.kernel.api.invoke.WexInvoker');
    return WindchillRequester.invoke("com.wincomplm.wex-example-rest","wex-example-rest-methods.hello-world",data, params);
}



    
    