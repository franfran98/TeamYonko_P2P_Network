package interfaces;

import fr.sorbonne_u.components.interfaces.OfferedCI;
import fr.sorbonne_u.components.interfaces.RequiredCI;

public interface CommunicationCI extends OfferedCI, RequiredCI {
	public void connect(P2PAddressI address, String communicationInbondPortURI, String routingInboundPortURI) throws Exception;
	public void routeMessage(MessageI m) throws Exception;
	public void ping() throws Exception;
}
