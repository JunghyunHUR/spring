package net.jason.sp;

import java.util.*;

public class JavaCollection {
	List addressList;
	Set addressSet;
	Map addressMap;
	Properties addressProps;
	
	public List getAddressList() {
		System.out.println("Sel Element : " + addressList);
		return addressList;
	}
	public void setAddressList(List addressList) {
		this.addressList = addressList;
	}
	public Set getAddressSet() {
		System.out.println("Sel Element : " + addressSet);
		return addressSet;
	}
	public void setAddressSet(Set addressSet) {
		this.addressSet = addressSet;
	}
	public Map getAddressMap() {
		System.out.println("Sel Element : " + addressMap);
		return addressMap;
	}
	public void setAddressMap(Map addressMap) {
		this.addressMap = addressMap;
	}
	public Properties getAddressProps() {
		System.out.println("Sel Element : " + addressProps);
		return addressProps;
	}
	public void setAddressProps(Properties addressProps) {
		this.addressProps = addressProps;
	}
	
}
