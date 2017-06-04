package com.ecomm.commonutility.logger;

public class LoggerConstants {

	public static String wing;
	public static String ENTER_CAPTION;
	public static String LEAVE_CAPTION;
	public static String ERROR_CAPTION;
	public static String TAB_ENTER;
	public static String TAB_LEAVE;
	public static String TAB_ERROR;

	public LoggerConstants(final int wingLength, final String wingChar,
			final String ENTER_CAPTION, final String LEAVE_CAPTION,
			final String ERROR_CAPTION) {

		String wingBuilder = "";
		for (int i = 0; i < wingLength; ++i) {
			wingBuilder += wingChar;
		}
		LoggerConstants.wing = wingBuilder;
		LoggerConstants.ENTER_CAPTION = ENTER_CAPTION;
		LoggerConstants.LEAVE_CAPTION = LEAVE_CAPTION;
		LoggerConstants.ERROR_CAPTION = ERROR_CAPTION;
		LoggerConstants.TAB_ENTER = ENTER_CAPTION.replaceAll("[A-Z]", " ");
		LoggerConstants.TAB_LEAVE = LEAVE_CAPTION.replaceAll("[A-Z]", " ");
		LoggerConstants.TAB_ERROR = ERROR_CAPTION.replaceAll("[A-Z]", " ");
	}

}
