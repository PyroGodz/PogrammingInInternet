function Fill_JSON(req) {
    var xx = eval('(' + req.responseText + ')');
    var rc = "";
    for (var i = 0; i < xx.X.length; i++) {
        rc += (xx.X[i].rand + " ");
    }
    return (rc);
};

function OnClick_JSON(n, s) {
    let pattern = new RegExp(/^[1-9]+[0-9]*$/);
    console.log(n);
    if (pattern.test(n)) {
        if (req) {
            req = new XMLHttpRequest();
            req.open("POST", "http://localhost:8080/lab11/Sss_JSON", true);
            req.onreadystatechange = function () {
                if (req.readyState == 4) {
                    if (req.status == 200) {
                        s.firstChild.data = Fill_JSON(req);
                        s.className = "h1";
                    } else alert("status = " +
                        req.status + "\n" + req.statusText);
                }
                ;
            };
            req.setRequestHeader("XRand-N", n);
            req.send("null");
        }
        ;
    } else alert("error");
};


function OnClick_JSON_sync(n, s) {
    let req = new XMLHttpRequest();
    let pattern = new RegExp(/^[1-9]+[0-9]*$/);
    if (pattern.test(n.value)) {
        if (req) {
            req.open("POST", "http://localhost:8080/lab11/Sss_JSON_sync", true);
            req.onreadystatechange = function () {
                if (req.readyState == 4) {
                    if (req.status == 200) {
                        s.firstChild.data = Fill_JSON(req);
                        s.className = "h1";
                    } else {
                        alert("status = " +
                            req.status + "\n" + req.statusText);
                        alert("JSON Error");
                    }
                }
                ;
            };
            req.setRequestHeader("XRand-N", n.value);
            req.send("null");
        }
        ;
    } else alert("error in JSON");
};