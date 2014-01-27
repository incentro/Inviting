<%
String status = "";
if(request.getSession().getAttribute("status") != null){
    status = (String)request.getSession().getAttribute("status");
}else if(!status.equals("ingelogd")){
    response.sendRedirect("/Inviting/index.jsp?message=Log+eerst+in+om+verder+te+gaan");
}
//session.removeAttribute("status");
%>