<%@ page import="com.wincomplm.wex.kernel.api.invoke.WexInvoker"%>


<html>
    <head>
        <meta charset="UTF-8">
        <title>Example Extension Diagnostics</title>
        <style>
            <%@ include file="kernel-css.jspf"%>
        </style>
        <script src="../lib/jquery-3.6.1.min.js"></script>
    </head>
    <body style="font-family: Arial; font-size: 90%; margin: 20px;  margin-top: 60px; ">
        <div class="wex-header">Example File Upload</div>
        <button class="wex-button wex-close" onClick="window.close()">Close</button>

        <table style="font-size: 90%">
            <tr>
                <tr>
                    <td>File</td>
                    <td><input class="form-control" type="file" id="uploadFile" name="uploadFile"></td>
                    <td></td>
                    <td><button class="wex-button wex-button-active" onclick="doAction()">Upload</button></td>
                </tr>
            </tr>
        </table>

        <script language="JavaScript">
  
            doAction = async function () {
                let formData = new FormData();
                formData.append("file", uploadFile.files[0]);
                var url = "run-diags.jsp";
                const response =  await fetch(url , {
                    method: "POST",
                    body: formData,
                });   
                if (!response.ok) {
                    alert("Upload failed");
                    return;
                }
                alert('The file has been uploaded successfully. Check MS logs.');
            }
            
            
        </script>

    </body>
</html>



