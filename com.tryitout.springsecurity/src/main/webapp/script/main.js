
function getCookie(c_name)
{
var i,x,y,ARRcookies=document.cookie.split(";");
for (i=0;i<ARRcookies.length;i++)
{
  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
  if (x==c_name)
    {
    return unescape(y);
    }
  }
}

function getSecurityCookie(){
	var text =  getCookie("SPRING_SECURITY_REMEMBER_ME_COOKIE");
	var textDecoded = Base64.decode(text);  
	var p = document.getElementById("_cookie_out");
	text = text+", text decoded: " + textDecoded;
	p.innerText = text;
}