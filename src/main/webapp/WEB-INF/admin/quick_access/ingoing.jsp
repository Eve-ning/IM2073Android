<%@ page import="DBHandler.DBQueries" %>
<jsp:include page="select/table_displayer.jsp" >
    <jsp:param name="title" value="Ingoing Records" />
    <jsp:param name="sql" value="<%=DBQueries.ingoing%>" />
</jsp:include>