package com.alexferreira10.demo.model.enums;

public enum Laboratory {
	//Automatically number to avoid conflicts in the database when changing the OrderStatus sequence
	MEDLEY(1), EMS(2), TEUTO(3), EUROFARMA(4), BILAB(5), GERMED(6);

	private int code;

	private Laboratory(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static Laboratory valueOf(int code) {
		for (Laboratory laboratory : Laboratory.values()) {
			if (laboratory.getCode() == code) {
				return laboratory;
			}
		}
		throw new IllegalArgumentException("Invalid Laboratory code");
	}
}