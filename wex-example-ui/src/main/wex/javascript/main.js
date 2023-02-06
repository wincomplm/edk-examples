var wexShowNotice = function (message) {  
    new jBox('Notice', { content: message, color: 'blue'});
}

var wexShowError = function (message) {  
    new jBox('Notice', { content: message, color: 'red'});
}

var gotoInfoArticle = function () {
    window.open("https://windchill-extensions.ptc.com/kb/articles/someArticle", true);
}

var doSomething = function () {
    wexShowNotice("You hit the button");
}


