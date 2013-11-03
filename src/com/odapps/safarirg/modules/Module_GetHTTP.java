package com.odapps.safarirg.modules;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Module_GetHTTP {

	public static String getInternetData()  throws Exception{

		BufferedReader in = null;
		String data = null;

		try {

			HttpClient client = new DefaultHttpClient();
			URI website = new URI("http://safarirg.parseapp.com/index.html");

			HttpGet request = new HttpGet();
			request.setURI(website);
			HttpResponse response = client.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String l = "";
			String nl = System.getProperty("line.separator");
			while((l = in.readLine()) != null) {
				sb.append(l + nl);
			}
			in.close();
			data = sb.toString();
			return data;

		} finally {

			if (in != null) {
				try {
					in.close();


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}		

}

