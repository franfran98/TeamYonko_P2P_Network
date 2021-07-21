package connectors;

import java.util.Set;

import fr.sorbonne_u.components.connectors.AbstractConnector;
import fr.sorbonne_u.components.examples.basic_cs.interfaces.URIProviderCI;
import interfaces.P2PAddressI;
import interfaces.PositionI;
import interfaces.RegistrationCI;
import utils.ConnectionInfo;

public class ServiceConnector extends AbstractConnector implements RegistrationCI{

	@Override
	public Set<ConnectionInfo> registerInternal(P2PAddressI address, String communicationInboundPortURI,
			PositionI initialPosition, double initialRange, String routingInboundPortURI) throws Exception {
		// TODO Auto-generated method stub
		return ((RegistrationCI)this.offering).registerInternal(address, communicationInboundPortURI,
				initialPosition, initialRange, routingInboundPortURI);
	}

	@Override
	public Set<ConnectionInfo> registerAccessPoint(P2PAddressI address, String communicationInboundPortURI,
			PositionI initialPosition, double initialRange, String routingInboundPortURI) throws Exception {
		return ((RegistrationCI)this.offering).registerAccessPoint(address, communicationInboundPortURI,
				initialPosition, initialRange, routingInboundPortURI);
	}

	@Override
	public void unregister(P2PAddressI address) throws Exception {
		// TODO Auto-generated method stub
	}

}
