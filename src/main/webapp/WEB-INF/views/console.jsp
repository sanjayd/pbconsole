<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:layout>
	<div class="col-md-4 col-md-offset-4 text-center">
	    <p>Alarm: <input id="alarm-toggle" type="checkbox" data-on="success" data-off="danger" <c:if test="${isArmed}">checked="checked"</c:if> /></p>
	</div>
</t:layout>
