package connectors;

import fr.sorbonne_u.components.connectors.AbstractConnector;
import interfaces.CommunicationCI;
import interfaces.MessageI;
import interfaces.P2PAddressI;

public class CommunicationServiceConnector extends AbstractConnector implements CommunicationCI{

	@Override
	public void connect(P2PAddressI address, String communicationInbondPortURI, String routingInboundPortURI)
			throws Exception {
		// TODO Auto-generated method stub
		((CommunicationCI)this.offering).connect(address, communicationInbondPortURI, routingInboundPortURI);
	}

	@Override
	public void routeMessage(MessageI m) throws Exception {
		// TODO Auto-generated method stub
		((CommunicationCI)this.offering).routeMessage(m);
	}

	@Override
	public void ping() throws Exception {
		// TODO Auto-generated method stub
		((CommunicationCI)this.offering).ping();
	}
	
}
