package com.demo;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class SystemInformation {
	public String getSystemInformation() {
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		StringBuilder sb = new StringBuilder();
		sb.append("System Information => ");
		String operatingSystemName = operatingSystemMXBean.getName();
		sb.append("\nOS Name: " + operatingSystemName);
		String osArchitecture = operatingSystemMXBean.getArch();
		sb.append("\nOS Architecture: " + osArchitecture);
		String osVersion = operatingSystemMXBean.getVersion();
		sb.append("\nOS Version: " + osVersion);
		String processorIdentifier = System.getenv("PROCESSOR_IDENTIFIER");
		sb.append("\nProcessor Specification: " + processorIdentifier);
		int availableProcessors = operatingSystemMXBean.getAvailableProcessors();
		sb.append("\nNumber Of Processors: " + availableProcessors);

		String output = sb.toString();
		System.out.println(sb.toString());

		return output;
	}
}
