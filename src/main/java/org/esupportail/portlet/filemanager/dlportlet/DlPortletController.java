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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.esupportail.portlet.filemanager.EsupFileManagerConstants;
import org.esupportail.portlet.filemanager.api.DownloadRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

@Controller
@Scope("request")
public class DlPortletController {

	protected Logger log = Logger.getLogger(DlPortletController.class);

    
    @RequestMapping("VIEW")
    public ModelAndView renderView(@RequestParam(required=false) String url, 
    		RenderRequest request, RenderResponse response) {	
		ModelMap model = new ModelMap();     
		model.put("url", url);
    	return new ModelAndView("dl-portlet", model);
    }
    
	@RequestMapping(value = {"VIEW"}, params = {"action=downloadUrl"})
    public void downloadUrl(@RequestParam(value = "url") String url,
            ActionRequest request, ActionResponse response) {

        // construct a new search query object from the string query                                                                                         
        final DownloadRequest urlObj = new DownloadRequest();
        urlObj.setUrl(url);
	
        // send a search query event                                                                                                                         
        response.setEvent(EsupFileManagerConstants.DOWNLOAD_REQUEST_QNAME, urlObj);
        response.setRenderParameter("url", url);
    }
	
}
