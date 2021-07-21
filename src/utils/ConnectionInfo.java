package utils;

import interfaces.P2PAddressI;

public class ConnectionInfo {
	private P2PAddressI address;
	private String communicationInboundPortURI;
	private String routingInboundPortURI;
	private boolean isRouting;

	public ConnectionInfo(P2PAddressI address, String communicationInboundPortURI, String routingInboundPortURI) {
		this.address = address;
		this.communicationInboundPortURI = communicationInboundPortURI;
		this.routingInboundPortURI = routingInboundPortURI;
	}

	public P2PAddressI getAddress() {
		return address;
	}

	public String getCommunicationInboundPortURI() {
		return communicationInboundPortURI;
	}

	public String getRoutingInboundPortURI() {
		return routingInboundPortURI;
	}

}

