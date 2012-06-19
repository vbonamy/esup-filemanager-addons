/**
 * Copyright (C) 2012 Esup Portail http://www.esup-portail.org
 * Copyright (C) 2012 UNR RUNN http://www.unr-runn.fr
 * @Author (C) 2012 Vincent Bonamy <Vincent.Bonamy@univ-rouen.fr>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.esupportail.portlet.filemanager.dlportlet;

import javax.portlet.Event;
import javax.portlet.EventRequest;

import org.apache.log4j.Logger;
import org.esupportail.portlet.filemanager.EsupFileManagerConstants;
import org.esupportail.portlet.filemanager.api.DownloadResponse;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.EventMapping;

@Controller
@Scope("request")
@RequestMapping("VIEW")
public class DlPortletControllerEvents {

	protected Logger log = Logger.getLogger(DlPortletControllerEvents.class);

    @EventMapping(EsupFileManagerConstants.DOWNLOAD_RESPONSE_QNAME_STRING)
    public void handleDownloadResult(EventRequest request) {
        
    	log.info("DlPortletControllerEvents.handleDownloadResult from EsupFilemanager-dlportlet is called");
    	
    	final Event event = request.getEvent();
        final DownloadResponse downloadResponse = (DownloadResponse) event.getValue();

        log.info("downloadResponse : " + downloadResponse.getSummary());
    }
	 
	
}
