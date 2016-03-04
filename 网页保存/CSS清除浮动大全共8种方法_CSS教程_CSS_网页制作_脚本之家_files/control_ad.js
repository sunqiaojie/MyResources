<!--
window.onerror = function () {return true};
function switchad(adname,adtpname){
 if (getid(adname) && getid(adtpname)){
getid(adname).innerHTML=getid(adtpname).innerHTML;
getid(adtpname).innerHTML='';
}
} 
//下载页广告
try {
switchad("logo_m","logo_m_tp");
switchad("logo_r","logo_r_tp");
switchad("tonglangg","tonglangg_tp");
switchad("tonglan960","tonglan960_tp");
switchad("title_ad1","title_ad1_tp");
switchad("art580","art580_tp");
//switchad("bd250","bd250_tp");
switchad("bd200","bd200_tp");
switchad("bd468","bd468_tp");
//switchad("con_ad1","con_ad1_tp");
//switchad("con_ad8","con_ad8_tp");
}catch(e){}

function setADCookie(name, value)
{
	var argv = setADCookie.arguments;
	var argc = setADCookie.arguments.length;
	var expires = (argc > 2) ? argv[2] : null;
	if(expires!=null)
	{
		var LargeExpDate = new Date ();
		LargeExpDate.setTime(LargeExpDate.getTime() + (expires*1000*300));
	}
	document.cookie = name + "=" + escape (value)+((expires == null) ? "" : ("; expires=" +LargeExpDate.toGMTString()));
}
function getCookie(Name)			//cookies读取JS
{
	var search = Name + "="
	if(document.cookie.length > 0) 
	{
		offset = document.cookie.indexOf(search)
		if(offset != -1) 
		{
			offset += search.length
			end = document.cookie.indexOf(";", offset)
			if(end == -1) end = document.cookie.length
			return unescape(document.cookie.substring(offset, end))
		 }
	else return ""
	  }
}


//对联
var cpro_id = 'u480030';
document.write('<scri'+'pt src="http://cpro.baidustatic.com/cpro/ui/f.js" type="text/javascript"></s'+'cript>');

//右下角


//右下角结束
//-->