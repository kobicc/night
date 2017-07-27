package com.kobicc.kbsp.controller;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;

public class ApController {
	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		client.getParams().setParameter("http.useragent", "org.ap-FeedReader/1.0");
		HostConfiguration host = client.getHostConfiguration();
		host.setHost(new URI("http://syndication.ap.org:80", true));
		GetMethod method = new
				GetMethod("/AP.Distro.Feed/GetFeed.aspx?idList=30598&idListType=products&maxItems=25");
		Credentials credentials = new UsernamePasswordCredentials("NEWWORLDRADIO_webfeeds", "@Pwf$110268");
		AuthScope authScope = new AuthScope(host.getHost(), host.getPort());
		HttpState state = client.getState();
		state.setCredentials(authScope, credentials);
		int httpStatusCode = client.executeMethod(host, method);
		if(httpStatusCode == 200){
			String xmlFeed = method.getResponseBodyAsString();
			System.out.println(xmlFeed);
		}
	}
}
