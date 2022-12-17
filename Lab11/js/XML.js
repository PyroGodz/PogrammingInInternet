function Fill(req){
    let xmldoc = req.responseXML;
    let tsnum = xmldoc.getElementsByTagName('num');
    let rc = "";
    for (let i = 0; i < tsnum.length; i++){
        rc += tsnum[i].firstChild.data+" ";
    }
    return rc;
};

function OnClick_XML(n, s){
    let pattern = new RegExp(/^[1-9]+[0-9]*$/);
    if (pattern.test(n)){
        if (req){
            req.open("POST","http://localhost:8080/lab11/Sss_XML", true);
            req.onreadystatechange = function(){
                if (req.readyState == 4){
                    if (req.status == 200){
                        s.firstChild.data = Fill(req);
                        s.className ="h1";
                    }else alert("status = "+
                        req.status +"\n"+req.statusText);
                }
            };
            req.setRequestHeader("XRand-N",  n)
            req.send("null");
        }
    }else alert ("error");
};


function OnClick_XML_sync(n, s){
    let req = new XMLHttpRequest();
    let pattern = new RegExp(/^[1-9]+[0-9]*$/);
    console.log(n);
    if (pattern.test(n.value)){
        if (req){
            req.open("POST","http://localhost:8080/lab11/Sss_XML_sync", true);
            req.onreadystatechange = function(){
                if (req.readyState == 4){
                    if (req.status == 200){
                        s.firstChild.data = Fill(req);
                        s.className ="h1";
                    }else
                    {alert("status = "+
                        req.status +"\n"+req.statusText);
                        alert("XML Error");
                    }
                }
            };
            req.setRequestHeader("XRand-N",  n.value);
            req.send("null");
        }
    }else alert ("error in XML");
};
