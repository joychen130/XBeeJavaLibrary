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
package com.digi.xbee.api.models;

import java.util.HashMap;

import com.digi.xbee.api.utils.HexUtils;

/**
 * Enumerates the different hardware versions of the XBee devices.
 */
public enum HardwareVersionEnum {

	// Enumeration entries
	X09_009(0x01, "X09-009"),
	X09_019(0x02, "X09-019"),
	XH9_009(0x03, "XH9-009"),
	XH9_019(0x04, "XH9-019"),
	X24_009(0x05, "X24-009"),
	X24_019(0x06, "X24-019"),
	X09_001(0x07, "X09-001"),
	XH9_001(0x08, "XH9-001"),
	X08_004(0x09, "X08-004"),
	XC09_009(0x0A, "XC09-009"),
	XC09_038(0x0B, "XC09-038"),
	X24_038(0x0C, "X24-038"),
	X09_009_TX(0x0D, "X09-009-TX"),
	X09_019_TX(0x0E, "X09-019-TX"),
	XH9_009_TX(0x0F, "XH9-009-TX"),
	XH9_019_TX(0x10, "XH9-019-TX"),
	X09_001_TX(0x11, "X09-001-TX"),
	XH9_001_TX(0x12, "XH9-001-TX"),
	XT09B_XXX(0x13, "XT09B-xxx (Attenuator version)"),
	XT09_XXX(0x14, "XT09-xxx"),
	XC08_009(0x15, "XC08-009"),
	XC08_038(0x16, "XC08-038"),
	XB24_AXX_XX(0x17, "XB24-Axx-xx"),
	XBP24_AXX_XX(0x18, "XBP24-Axx-xx"),
	XB24_BXIX_XXX(0x19, "XB24-BxIx-xxx and XB24-Z7xx-xxx"),
	XBP24_BXIX_XXX(0x1A, "XBP24-BxIx-xxx and XBP24-Z7xx-xxx"),
	XBP09_DXIX_XXX(0x1B, "XBP09-DxIx-xxx Digi Mesh"),
	XBP09_XCXX_XXX(0x1C, "XBP09-XCxx-xxx: S3 XSC Compatibility"),
	XBP08_DXXX_XXX(0x1D, "XBP08-Dxx-xxx 868MHz"),
	XBP24B(0x1E, "XBP24B: Low cost ZB PRO and PLUS S2B"),
	XB24_WF(0x1F, "XB24-WF: XBee 802.11 (Redpine module)"),
	AMBER_MBUS(0x20, "??????: M-Bus module made by Amber"),
	XBP24C(0x21, "XBP24C: XBee PRO SMT Ember 357 S2C PRO"),
	XB24C(0x22, "XB24C: XBee SMT Ember 357 S2C"),
	XSC_GEN3(0x23, "XSC_GEN3: XBP9 XSC 24 dBm"),
	SRD_868_GEN3(0x24, "SDR_868_GEN3: XB8 12 dBm"),
	ABANDONATED(0x25, "Abandonated"),
	SMT_900LP(0x26, "900LP (SMT): 900LP on 'S8 HW'"),
	WIFI_ATHEROS(0x27, "WiFi Atheros (TH-DIP) XB2S-WF"),
	SMT_WIFI_ATHEROS(0x28, "WiFi Atheros (SMT) XB2B-WF"),
	SMT_475LP(0x29, "475LP (SMT): Beta 475MHz"),
	XBEE_CELL_TH(0x2A, "XBee-Cell (TH): XBee Cellular"),
	XLR_MODULE(0x2B, "XLR Module"),
	XB900HP_NZ(0x2C, "XB900HP (New Zealand): XB9 NZ HW/SW"),
	XBP24C_TH_DIP(0x2D, "XBP24C (TH-DIP): XBee PRO DIP"),
	XB24C_TH_DIP(0x2E, "XB24C (TH-DIP): XBee DIP"),
	XLR_BASEBOARD(0x2F, "XLR Baseboard");
	
	// Variables
	private final int value;
	
	private final String description;
	
	private final static HashMap<Integer, HardwareVersionEnum> lookupTable = new HashMap<Integer, HardwareVersionEnum>();
	
	static {
		for (HardwareVersionEnum hv:values())
			lookupTable.put(hv.getValue(), hv);
	}
	
	/**
	 * Class constructor. Instantiates a new {@code HardwareVersion} 
	 * enumeration entry with the given parameters.
	 * 
	 * @param value Hardware version numeric value 
	 * @param description Hardware version description.
	 */
	private HardwareVersionEnum(int value, String description) {
		this.value = value;
		this.description = description;
	}
	
	/**
	 * Returns the Hardware version numeric value.
	 * 
	 * @return The hardware version numeric value.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Returns the hardware version description.
	 * 
	 * @return The hardware version description.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Returns the {@code HardwareVersionEnum} associated to the given 
	 * numeric value.
	 * 
	 * @param value Numeric value of the {@code HardwareVersionEnum} to 
	 *              retrieve.
	 * 
	 * @return The {@code HardwareVersionEnum} associated to the given numeric 
	 *         value, {@code null} if there is not any 
	 *         {@code HardwareVersionEnum} associated to that value.
	 */
	public static HardwareVersionEnum get(int value) {
		return lookupTable.get(value);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return HexUtils.byteToHexString((byte)value) + ": " + description;
	}
}
