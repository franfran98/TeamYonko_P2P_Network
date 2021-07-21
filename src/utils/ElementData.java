package utils;

import interfaces.PositionI;

public class ElementData {
	private String communicationInboundPortURI;
	private PositionI initialPosition;
	private String routingInboundPortURI;
	
	public ElementData(String cipURI, PositionI initialPosition, String ripURI) {
		this.communicationInboundPortURI = cipURI;
		this.initialPosition = initialPosition;
		this.routingInboundPortURI = ripURI;
	}

	public String getCommunicationInboundPortURI() {
		return communicationInboundPortURI;
	}

	public PositionI getInitialPosition() {
		return initialPosition;
	}

	public String getRoutingInboundPortURI() {
		return routingInboundPortURI;
	}
}
