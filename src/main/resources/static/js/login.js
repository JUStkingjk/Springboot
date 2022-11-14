window.onload = function (){
    let username = getCookie("username");
    let password = getCookie("password");
    if(username !== ""&& password !== ""){
        document.getElementsByName("Ucount").value = username;
        document.getElementsByName("Upassword").value = password;
    }
}
function getCookie(name){
    let cookie = document.cookie;
    if(cookie !== ""){
        let strings = cookie.split("; ");
        for(let i=0;i<strings.length;i++){
            let cookieElement = strings[i];
            let arr = cookieElement.split("=");
            let key = arr[0];
            let value = arr[1];
            if(key === name){
                return value;
            }
        }
    }
    console.info("cookie = null")
    return "fxxk";
}