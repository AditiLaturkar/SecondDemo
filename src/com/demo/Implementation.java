package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;

public class Implementation {

	private static int getInternetConnectionSpeed() {
		return 0;
	}

	public static boolean pingWebsite(String websiteUrl) {
		websiteUrl = websiteUrl.trim();
		if (null != websiteUrl && !websiteUrl.isEmpty()) {
			if (!websiteUrl.startsWith("http")) {
				websiteUrl = "https://" + websiteUrl;
			}
		}
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) new URL(websiteUrl).openConnection();
		} catch (IOException e) {
			return false;
		}
		connection.setConnectTimeout(1000);
		connection.setReadTimeout(1000);
		try {
			connection.setRequestMethod("HEAD");
		} catch (ProtocolException e) {
			return false;
		}
		int responseCode = 0;
		try {
			responseCode = connection.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (200 <= responseCode && responseCode <= 399);
	}

	public static String runSystemCommand(String Command) {
		StringBuilder sb = new StringBuilder();
		try {
			Process p = Runtime.getRuntime().exec(Command);
			BufferedReader InputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String s = "";

			while ((s = InputStream.readLine()) != null) {
				sb.append(s + "\n");
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String traceRoute(String website) throws UnknownHostException {
		InetAddress byName = InetAddress.getByName(website);
		String Command = "tracert " + byName.getHostAddress();
		String traceRoute = runSystemCommand(Command);
		return traceRoute;
	}

}
