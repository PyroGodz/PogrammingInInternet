function crReq() {
    let req = null;
    if (window.XMLHttpRequest) {
        req = window.XMLHttpRequest;
        req = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        try {
            req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                req = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                req = null;
            }
        }
    }
    return req;
}
