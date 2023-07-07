package com.firstbit;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;

public class Devices implements IControllable {

	private String deviceName;
	private String deviceType;
	// isDeviceTurnOn?? --> turnOn -- true, turn Off --> false 
	private Boolean isDeviceTurnOn;  
	private Integer time;
	LocalTime startTime;
	LocalTime stopTime;

	// no args 
	public Devices() {

	}

	// parameterized constructor
	public Devices(String deviceName, String deviceType) {
		this.deviceName = deviceName;
		this.deviceType = deviceType;
	}

	// second parameterized constructor
	public Devices(String deviceName, String deviceType, Boolean isDeviceTurnOn, Integer time, LocalTime startTime) {
		super();
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.isDeviceTurnOn = false;
		this.time = 0;
		this.startTime = LocalTime.now();
	}

	// setters and getters
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Boolean isDeviceTurnOn() {
		return isDeviceTurnOn;
	}

	public void isDeviceTurnOn(Boolean isDeviceTurnOn) {
		this.isDeviceTurnOn = isDeviceTurnOn;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getStopTime() {
		return stopTime;
	}

	public void setStopTime(LocalTime stopTime) {
		this.stopTime = stopTime;
	}

	@Override
	public void deviceTurnOn() {
		this.isDeviceTurnOn = true;
		this.startTime = LocalTime.now();
	}

	@Override
	public void deviceTurnOff() {
		this.isDeviceTurnOn = false;
		this.startTime = LocalTime.now();
	}

	@Override
	public void countTime() {
		if (startTime != null) {
			this.time = (int) this.stopTime.until(startTime, ChronoUnit.SECONDS);
		}
		System.out.println("Device Active time was " + time + " seconds");
	}

}
