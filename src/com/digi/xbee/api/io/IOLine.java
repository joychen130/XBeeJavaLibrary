/**
* Copyright (c) 2014 Digi International Inc.,
* All rights not expressly granted are reserved.
*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this file,
* You can obtain one at http://mozilla.org/MPL/2.0/.
*
* Digi International Inc. 11001 Bren Road East, Minnetonka, MN 55343
* =======================================================================
*/
package com.digi.xbee.api.io;

import java.util.HashMap;

public enum IOLine {

	// Enumeration types.
	DIO0_AD0("DIO0_AD0", 0, "D0", null),
	DIO1_AD1("DIO1_AD1", 1, "D1", null),
	DIO2_AD2("DIO2_AD2", 2, "D2", null),
	DIO3_AD3("DIO3_AD3", 3, "D3", null),
	DIO4_AD4("DIO4_AD4", 4, "D4", null),
	DIO5_AD5("DIO5_AD5", 5, "D5", null),
	DIO6("DIO6", 6, "D6", null),
	DIO7("DIO7", 7, "D7", null),
	DIO8("DIO8", 8, "D8", null),
	DIO9("DIO9", 9, "D9", null),
	DIO10_PWM0("DIO10_PWM0", 10, "P0", "M0"),
	DIO11_PWM1("DIO11_PWM1", 11, "P1", "M1"),
	DIO12("DIO12", 12, "P2", null),
	DIO13("DIO13", 13, "P3", null),
	DIO14("DIO14", 14, "P4", null),
	DIO15("DIO15", 15, "P5", null),
	DIO16("DIO16", 16, "P6", null),
	DIO17("DIO17", 17, "P7", null),
	DIO18("DIO18", 18, "P8", null),
	DIO19("DIO19", 19, "P9", null);
	
	// Variables.
	private final static HashMap <Integer, IOLine> lookupTableIndex = new HashMap<Integer, IOLine>();
	
	private final String name;
	private final String atCommand;
	private final String atPWMCommand;
	
	private final int index;
	
	static {
		for (IOLine dio:values())
			lookupTableIndex.put(dio.getIndex(), dio);
	}
	
	/**
	 * Class constructor. Instances a new object of type {@code IOLine}
	 * for the enumeration.
	 * 
	 * @param name The name of the IO line.
	 * @param index The index associated to the IO line.
	 * @param atCommand The AT command corresponding to the IO line.
	 * @param atPWMCommand The PWM AT command corresponding to the IO line (if any).
	 */
	IOLine(String name, int index, String atCommand, String atPWMCommand) {
		this.name = name;
		this.index = index;
		this.atCommand = atCommand;
		this.atPWMCommand = atPWMCommand;
	}
	
	/**
	 * Retrieves the name of the IO line.
	 * 
	 * @return The name of the IO line.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Retrieves the index of the IO line.
	 * 
	 * @return The index of the IO line.
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Retrieves the AT command associated to the IO line.
	 * 
	 * @return The AT command associated to the IO line.
	 */
	public String getATCommand() {
		return atCommand;
	}
	
	/**
	 * Retrieves whether or not the IO line has PWM capability.
	 * 
	 * @return True if the provided IO line has PWM, false otherwise.
	 */
	public boolean hasPWMCapability() {
		return atPWMCommand != null;
	}
	
	/**
	 * Retrieves the PWM AT command associated to the IO line.
	 * 
	 * @return The PWM AT command associated to the IO line.
	 */
	public String getPWMATCommand() {
		return atPWMCommand;
	}
	
	/**
	 * Retrieves the IO line corresponding to the provided index.
	 * 
	 * @param index The index corresponding to the IO line to retrieve.
	 * @return The IO line corresponding to the provided index.
	 */
	public static IOLine getDIO(int index) {
		if (lookupTableIndex.containsKey(index))
			return lookupTableIndex.get(index);
		return null;
	}
}