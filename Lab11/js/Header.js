function OnClick_Header(x,y, z){
    let pattern = new RegExp(/^[0-9]*\.?[0-9]+$/);
    if (pattern.test(x.value) && pattern.test(y.value)){
        if (req){
            req.open("POST","http://localhost:8080/lab11/Sss_Header", true);
            req.onreadystatechange = function(){
                if (req.readyState == 4){
                    if (req.status == 200)
                    {z.value=req.getResponseHeader("Value-Z");}
                    else alert("status = "+
                        req.status +"\n"+req.statusText);
                }
            };
            req.setRequestHeader("Value-X",  x.value);
            req.setRequestHeader("Value-Y",  y.value);
            req.send("null");
        }
    }else alert ("error");
};


function OnClick_Header_sync(x, y, z) {
    let req = new XMLHttpRequest();
    let pattern = new RegExp(/^[0-9]*\.?[0-9]+$/);
    if (pattern.test(x.value) && pattern.test(y.value)){
        if (req){
            req.open("POST","http://localhost:8080/lab11/Sss_Header_sync", true);
            req.onreadystatechange = function(){
                if (req.readyState == 4){
                    if (req.status == 200)
                    {z.value=req.getResponseHeader("Value-Z");}
                    else alert("status = "+
                        req.status +"\n"+req.statusText);
                }
            };
            req.setRequestHeader("Value-X",  x.value);
            req.setRequestHeader("Value-Y",  y.value);
            req.send("null");
        }
    }else alert ("error");
};
