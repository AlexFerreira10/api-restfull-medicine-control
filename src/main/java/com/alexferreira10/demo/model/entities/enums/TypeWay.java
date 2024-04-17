package com.alexferreira10.demo.model.entities.enums;

public enum TypeWay {

	ORAL(1), NASAL(2), VENOSO(3), INTRAMUSCULAR(4), RETAL(5);

	private int code;

	private TypeWay(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TypeWay valueOf(int code) {
		for (TypeWay way : TypeWay.values()) {
			if (way.code == code) {
				return way;
			}
		}
		throw new IllegalArgumentException("Invalid TypeWay code");
	}
}