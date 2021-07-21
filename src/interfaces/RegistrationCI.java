package interfaces;

import java.util.Set;

import fr.sorbonne_u.components.interfaces.OfferedCI;
import fr.sorbonne_u.components.interfaces.RequiredCI;
import utils.ConnectionInfo;

public interface RegistrationCI extends OfferedCI, RequiredCI {
	
	public Set<ConnectionInfo> registerInternal (P2PAddressI address, String communicationInboundPortURI, PositionI initialPosition, double initialRange, String routingInboundPortURI) throws Exception;

	public Set<ConnectionInfo> registerAccessPoint( P2PAddressI address, String communicationInboundPortURI, PositionI initialPosition, double initialRange, String routingInboundPortURI) throws Exception;

	public void unregister(P2PAddressI address)  throws Exception;
}
