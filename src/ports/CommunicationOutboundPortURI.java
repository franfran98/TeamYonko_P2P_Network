package ports;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.interfaces.OfferedCI;
import fr.sorbonne_u.components.interfaces.RequiredCI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;
import interfaces.CommunicationCI;
import interfaces.MessageI;
import interfaces.P2PAddressI;

public class CommunicationOutboundPortURI extends AbstractOutboundPort implements CommunicationCI{

	public CommunicationOutboundPortURI(ComponentI owner)
			throws Exception {
		super(CommunicationCI.class, owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect(P2PAddressI address, String communicationInboundPortURI, String routingInboundPortURI)
			throws Exception {
		// TODO Auto-generated method stub
		((CommunicationCI) getConnector()).connect(address, communicationInboundPortURI, routingInboundPortURI);
	}

	@Override
	public void routeMessage(MessageI m) throws Exception {
		// TODO Auto-generated method stub
		((CommunicationCI) getConnector()).routeMessage(m);
	}

	@Override
	public void ping() throws Exception {
		// TODO Auto-generated method stub
		((CommunicationCI) getConnector()).ping();
	}

}
