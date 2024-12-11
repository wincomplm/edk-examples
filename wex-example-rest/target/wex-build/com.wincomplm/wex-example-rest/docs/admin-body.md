### Admin Guide

Once installed the extensions adds these Rest services

[/Windchill/servlet/odata/PTC/HelloWorld](/Windchill/servlet/odata/PTC/HelloWorld)

and 

[/Windchill/servlet/odata/PTC/HelloWex](/Windchill/servlet/odata/PTC/HelloWex)

Additionally there are other ways to extract data from the system without the use of REST feature.
In this case we can use a simple JSP page and JSON to look at modified parts from days ago. It can be accesed in

[/Windchill/netmarkets/jsp/com/wincomplm/wex/example/rest/getModifiedParts.jsp](/Windchill/netmarkets/jsp/com/wincomplm/wex/example/rest/getModifiedParts.jsp)

A configuration is available to look for parts that were modified X days ago:



![file]({{package-images}}/image_1.png)