<%--

    Copyright (C) 2012 Esup Portail http://www.esup-portail.org
    Copyright (C) 2012 UNR RUNN http://www.unr-runn.fr
    @Author (C) 2012 Vincent Bonamy <Vincent.Bonamy@univ-rouen.fr>

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
            http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<portlet:defineObjects />

<c:set var="n">
  <portlet:namespace />
</c:set>

   <div class="portlet-section">
	<spring:message code="downloadAwaiting" arguments="${url}"/>
   </div>


			<div class="portlet-section-body">

			<div class="portlet-section-body">

<portlet:actionURL var="formDownloadUrl">
  <portlet:param name="action" value="downloadUrl"/>
</portlet:actionURL>

      <form:form action="${formDownloadUrl}" method="post">

        <label>
          <spring:message code="downloadUrl"/>
        </label>
        <input type="text" name="url"/>

        <input type="submit" value="<spring:message code="download"/>" name="createFolder"/>


      </form:form>


    </div>

  </div>


