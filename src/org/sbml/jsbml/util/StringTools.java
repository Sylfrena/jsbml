/*
 * $Id$
 * $URL$
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 *
 * Copyright (C) 2009-2011 jointly by the following organizations:
 * 1. The University of Tuebingen, Germany
 * 2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK
 * 3. The California Institute of Technology, Pasadena, CA, USA
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation. A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as <http://sbml.org/Software/JSBML/License>.
 * ----------------------------------------------------------------------------
 */

package org.sbml.jsbml.util;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.sbml.jsbml.resources.Resource;

/**
 * This class provides a collection of convenient methods for manipulating
 * Strings.
 * 
 * @author Andreas Dr&auml;ger
 * @author rodrigue
 * @since 0.8
 * @version $Rev$
 */
public class StringTools {

	/**
	 * New line separator of this operating system
	 */
	private static final String newLine = System.getProperty("line.separator");

	/**
	 * 
	 */
	public static final String SCIENTIFIC_FORMAT = "########0.#########E0";
	/**
	 * 
	 */
	public static final String DECIMAL_FORMAT = "#############0.##############";
	/**
	 * 
	 */
	public static final String REAL_FORMAT = "#########################.#########################";

	/**
	 * Takes the given StringBuffer as input and appends every further Object to
	 * it.
	 * 
	 * @param k
	 * @param things
	 * @return
	 */
	public static final StringBuffer append(StringBuffer k, Object... things) {
		for (Object t : things) {
			k.append(t);
		}
		return k;
	}

	/**
	 * 
	 * @param sb
	 * @param elems
	 */
	public static void append(StringBuilder sb, Object... elems) {
		for (Object e : elems) {
			sb.append(e);
		}
	}

	/**
	 * This method concatenates two or more object strings into a new
	 * StringBuffer.
	 * 
	 * @param buffers
	 * @return
	 */
	public static final StringBuffer concat(Object... buffers) {
		StringBuffer res = new StringBuffer();
		for (Object buffer : buffers) {
			if (buffer != null) {
				res.append(buffer.toString());
			}
		}
		return res;
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public static final String encodeForHTML(String string) {
		final StringBuilder result = new StringBuilder();
		try {
			Properties p = Resource
					.readProperties("org/sbml/jsbml/resources/cfg/HTML_CharEncodingTable.txt");
			for (char character : string.toCharArray()) {
				if (p.containsKey(String.valueOf(character))) {
					result.append(p.get(String.valueOf(character)));
				} else {
					result.append(character);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			result.append(string);
		}
		return result.toString();
	}

	/**
	 * Returns a String whose first letter is now in lower case.
	 * 
	 * @param name
	 * @return
	 */
	public static final String firstLetterLowerCase(String name) {
		char c = name.charAt(0);
		if (Character.isLetter(c))
			c = Character.toLowerCase(c);
		if (name.length() > 1)
			name = Character.toString(c) + name.substring(1);
		else
			return Character.toString(c);
		return name;
	}

	/**
	 * Returns a String who's first letter is now in upper case.
	 * 
	 * @param name
	 * @return
	 */
	public static final String firstLetterUpperCase(String name) {
		char c = name.charAt(0);
		if (Character.isLetter(c)) {
			c = Character.toUpperCase(c);
		}
		if (name.length() > 1) {
			name = Character.toString(c) + name.substring(1);
		} else {
			return Character.toString(c);
		}
		return name;
	}

	/**
	 * Returns the number as an English word. Zero is converted to "no". Only
	 * positive numbers from 1 to twelve can be converted. All other numbers are
	 * just converted to a String containing the number.
	 * 
	 * @param number
	 * @return
	 */
	public static String getWordForNumber(long number) {
		if ((number < Integer.MIN_VALUE) || (Integer.MAX_VALUE < number))
			return Long.toString(number);
		switch ((int) number) {
		case 0:
			return "no";
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		case 10:
			return "ten";
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		default:
			return Long.toString(number);
		}
	}

	/**
	 * 
	 * @return
	 */
	public static final String newLine() {
		return newLine;
	}

	/**
	 * Returns a {@link String} from the given value that does not contain a
	 * point zero at the end if the given value represents an integer number.
	 * The returned {@link String} displays the number in a {@link Locale}
	 * -dependent way, i.e., the decimal separator and the symbols to represent
	 * the digits are chosen from the system's configuration. Furthermore, a
	 * scientific style including 'E' will be used if the value is smaller than
	 * 1E-5 or greater than 1E5.
	 * 
	 * @param value
	 * @return
	 */
	public static final String toString(double value) {
		return toString(Locale.getDefault(), value);
	}
	
	/**
	 * Allows for {@link Locale}-dependent number formatting.
	 * @param locale
	 * @param value
	 * @return
	 */
	public static final String toString(Locale locale, double value) {
		if (((int) value) - value == 0) {
			return String.format("%d", Integer.valueOf((int) value));
		}
		if ((Math.abs(value) < 1E-5) || (1E5 < Math.abs(value))) {
			DecimalFormat df = new DecimalFormat(SCIENTIFIC_FORMAT,
					new DecimalFormatSymbols(locale));
			return df.format(value);
		}
		DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT,
				new DecimalFormatSymbols(locale));
		return df.format(value);
	}

	/**
	 * Parses a String into a double number following the rules of the SBML
	 * specifications, section 3.1.5.
	 * 
	 * @param valueAsStr
	 *            a double as a String
	 * @return the String as a double. If the String is not a valid double
	 *         number, {@link Double.NaN} is returned.
	 */
	// TODO : we need to take care of these INFINITY numbers when we write back
	// the SBML file !!
	public static double parseSBMLDouble(String valueAsStr) {

		double value = Double.NaN;
		String toTest = valueAsStr.trim();

		try {
			value = Double.parseDouble(toTest);
		} catch (NumberFormatException e) {
			if (toTest.equalsIgnoreCase("INF")) {
				value = Double.POSITIVE_INFINITY;
			} else if (toTest.equalsIgnoreCase("-INF")) {
				value = Double.NEGATIVE_INFINITY;
			} else {
				Logger logger = Logger.getLogger(StringTools.class);
				logger.warn("Could not create a double from the string " + valueAsStr);
			}
		}

		return value;
	}

	/**
	 * Parses a {@link String} into an int number following the rules of the SBML
	 * specifications, section 3.1.3.
	 * 
	 * @param valueAsStr
	 *            an int as a {@link String}
	 * @return the {@link String} as an int. If the {@link String} is not a valid int number, 0
	 *         is returned.
	 */
	public static int parseSBMLInt(String valueAsStr) {
		int value = 0;
		try {
			value = Integer.parseInt(valueAsStr.trim());
		} catch (NumberFormatException e) {
			Logger logger = Logger.getLogger(StringTools.class);
			logger.warn("Could not create an integer from the string " + valueAsStr);
		}
		return value;
	}
	
	/**
	 * Parses a {@link String} into an short number following the rules of the
	 * SBML specifications, section 3.1.3.
	 * 
	 * @param value
	 *            an int as a String
	 * @return the {@link String} as an short. If the {@link String} is not a
	 *         valid short number, 0 is returned.
	 */
	public static int parseSBMLShort(String value) {
		short v = 0;
		try {
			v = Short.parseShort(value.trim());
		} catch (NumberFormatException e) {
			Logger logger = Logger.getLogger(StringTools.class);
			logger.warn("Could not create a short from the string " + value);
		}
		return v;
	}

	/**
	 * Parses a String into a boolean following the rules of the SBML
	 * specifications, section 3.1.2.
	 * 
	 * @param valueAsStr
	 *            a boolean as a String
	 * @return the String as a boolean. If the String is not a valid boolean,
	 *         false is returned.
	 */
	public static boolean parseSBMLBoolean(String valueAsStr) {

		String toTest = valueAsStr.trim();

		// Test for true/false ignoring case.
		boolean value = Boolean.parseBoolean(toTest);

		if (toTest.equals("0")) {
			value = false; // this test would not be needed as the value is
			// already false but it is there for completion.
		} else if (toTest.equals("1")) {
			value = true;
		} else if (!(toTest.equalsIgnoreCase("true") 
				|| toTest.equalsIgnoreCase("false"))) 
		{
			Logger logger = Logger.getLogger(StringTools.class);
			logger.warn("Could not create a boolean from the string " + valueAsStr);
		}

		return value;
	}

	/**
	 * Returns a HTML formated String, in which each line is at most lineBreak
	 * symbols long.
	 * 
	 * @param string
	 * @return
	 */
	public static String toHTML(String string) {
		return toHTML(string, Integer.MAX_VALUE);
	}

	/**
	 * Returns a HTML formated String, in which each line is at most lineBreak
	 * symbols long.
	 * 
	 * @param string
	 * @param lineBreak
	 * @return
	 */
	public static String toHTML(String string, int lineBreak) {
		StringTokenizer st = new StringTokenizer(string != null ? string : "",
				" ");
		StringBuilder sb = new StringBuilder();
		if (st.hasMoreElements())
			sb.append(st.nextElement().toString());
		int length = sb.length();
		sb.insert(0, "<html><body>");
		while (st.hasMoreElements()) {
			if (length >= lineBreak && lineBreak < Integer.MAX_VALUE) {
				sb.append("<br/>");
				length = 0;
			} else
				sb.append(' ');
			String tmp = st.nextElement().toString();
			length += tmp.length() + 1;
			sb.append(tmp);
		}
		sb.append("</body></html>");
		return sb.toString();
	}

}
