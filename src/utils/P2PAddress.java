package utils;

import interfaces.AddressI;
import interfaces.P2PAddressI;

public class P2PAddress implements P2PAddressI{
	
	private String address;
	
	public P2PAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(AddressI a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isP2PAddress() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isIPAddress() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getAddress() {
		return address;
	}
}
