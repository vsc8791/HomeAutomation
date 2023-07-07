package com.firstbit;

import java.util.List;

public class Room {

	private String roomType;
	private List<Devices> devicesList;

	public Room() {
	}

	public Room(String roomType, List<Devices> devicesList) {
		super();
		this.roomType = roomType;
		this.devicesList = devicesList;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public List<Devices> getDevicesList() {
		return devicesList;
	}

	public void setDevicesList(List<Devices> devicesList) {
		this.devicesList = devicesList;
	}

	// Method

	public void addRoom(String roomType) {
		this.roomType = roomType;
	}

	public void addDevice(String deviceName, String deviceType) {
		devicesList.add(new Devices(deviceName, deviceType));
	}

	public void displayTime() {
		for (Devices devices : devicesList) {
			System.out.println(devices.getDeviceName() + "  ::  ");
			devices.countTime();
		}
	}

	public void displayStatusForAllDevices() {
		System.out.println(roomType + " ==>");
		for (Devices devices : devicesList) {
			System.out.println(devices.getDeviceName() + " :: " + (devices.isDeviceTurnOn() ? "ON" : "OFF"));
		}

	}

	public void displayStatusForSingleDevice(String deviceName) {
		System.out.println(roomType + "=>");
		for (Devices devices : devicesList) {

			if (devices.getDeviceName().equals(deviceName))
				System.out.println(
						"Status : " + (devices.isDeviceTurnOn() ? "ON" : "OFF") + " for Device :" + deviceName);

		}

	}

	public void changeStatus(String deviceName) {

		System.out.println("You want to Change Status for Device" + deviceName);
		Boolean flag = false;
		Devices device = new Devices();
		for (Devices devices : devicesList) {
			device = devices;
			if (devices.getDeviceName().equals(deviceName)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			if (device.isDeviceTurnOn()) {
				System.out.println("Previous Device Status :" + (device.isDeviceTurnOn() ? "ON" : "OFF")
						+ " for Device :" + deviceName);
				device.deviceTurnOff();
				System.out.println("Current Device Status :" + (device.isDeviceTurnOn() ? "ON" : "OFF")
						+ " for Device :" + deviceName);
			} else {
				System.out.println("Previous Device Status :" + (device.isDeviceTurnOn() ? "ON" : "OFF")
						+ " for Device :" + deviceName);
				device.deviceTurnOn();
				System.out.println("Current Device Status :" + (device.isDeviceTurnOn() ? "ON" : "OFF")
						+ " for Device :" + deviceName);
			}

		} else {
			System.out.println("Device NOT FOUND");
		}
	}

}
