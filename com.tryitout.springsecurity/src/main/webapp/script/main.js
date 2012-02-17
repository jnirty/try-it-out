function getSecurityCookie(){
			$.ajax({
					url : "GetJdbcRememberMe.htm",
					success : function (data) {
						$("#content").html(data);
					},
					error : function (XMLHttpRequest, textStatus, errorThrown) {
						$("#content").html("Error occured:"+XMLHttpRequest.responseText);
					}
			});
}