package ports;

import java.util.Set;

import components.Simulator;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;
import interfaces.P2PAddressI;
import interfaces.PositionI;
import interfaces.RegistrationCI;
import utils.ConnectionInfo;

@SuppressWarnings("serial")
public class SimulatorInboundPort extends AbstractInboundPort implements RegistrationCI{
	public	SimulatorInboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, RegistrationCI.class, owner) ;

		assert	uri != null && owner instanceof Simulator ;
	}

	@Override
	public Set<ConnectionInfo> registerInternal(P2PAddressI address, String communicationInboundPortURI,
			PositionI initialPosition, double initialRange, String routingInboundPortURI) throws Exception {
		// TODO Auto-generated method stub
		return this.getOwner().handleRequest(owner -> ((Simulator)owner).registerInternal(address, communicationInboundPortURI,
				initialPosition, initialRange, routingInboundPortURI)) ;
	}

	@Override
	public Set<ConnectionInfo> registerAccessPoint(P2PAddressI address, String communicationInboundPortURI,
			PositionI initialPosition, double initialRange, String routingInboundPortURI) throws Exception {
		// TODO Auto-generated method stub
		return this.getOwner().handleRequest(owner -> ((Simulator)owner).registerAccessPoint(address, communicationInboundPortURI,
				initialPosition, initialRange, routingInboundPortURI)) ;
	}

	@Override
	public void unregister(P2PAddressI address) {
		// TODO Auto-generated method stub
		
	}
}
