<%@ page import="DBHandler.DBQueries" %>
<jsp:include page="select/table_displayer.jsp" >
    <jsp:param name="title" value="Stocks" />
    <jsp:param name="sql" value="<%=DBQueries.stock%>" />
</jsp:include>