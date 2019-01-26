package com.kishore.testhrs;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class GetDuration {
	public static void main(String[] args) {
		String duration = "1h30m10s";

		long finalDuration;
		if (StringUtils.contains(duration, "h")) {
			finalDuration = getHours(duration);
		} else if (StringUtils.contains(duration, "m")) {
			finalDuration = getMinutes(duration);
		} else if (StringUtils.contains(duration, "s")) {
			finalDuration = getSeconds(duration);
		}else {
			finalDuration=0;
		}

		System.out.println(finalDuration);
	}

	public static long getHours(String dur) {

		String[] hrMin = StringUtils.split(dur, "h");
		if (hrMin.length == 2) {
			long min = getMinutes(hrMin[1]);
			long hr = Integer.parseInt(hrMin[0]);
			return (hr * 60 * 60) + min;
		} else {
			return 0;
		}
	}

	public static long getMinutes(String dur) {
		String[] minSec = StringUtils.split(dur, "m");
		if (minSec.length == 2) {
			long sec = getSeconds(minSec[1]);
			long min = Integer.parseInt(minSec[0]);
			
			return sec + (min * 60);
		} else {
			return 0;
		}
	}

	public static long getSeconds(String dur) {

		return Integer.parseInt(StringUtils.split(dur, "s")[0]);
	}
}
