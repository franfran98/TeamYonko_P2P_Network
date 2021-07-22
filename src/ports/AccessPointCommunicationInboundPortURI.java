package ports;

import components.AccessPoint;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;
import interfaces.CommunicationCI;
import interfaces.MessageI;
import interfaces.P2PAddressI;

public class AccessPointCommunicationInboundPortURI extends AbstractInboundPort implements CommunicationCI{

	public AccessPointCommunicationInboundPortURI(String uri, ComponentI owner)
			throws Exception {
		super(uri, CommunicationCI.class, owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect(P2PAddressI address, String communicationInbondPortURI, String routingInboundPortURI)
			throws Exception {
		this.getOwner().handleRequest(owner -> ((AccessPoint)owner)).connect(address, communicationInbondPortURI, routingInboundPortURI);
	}

	@Override
	public void routeMessage(MessageI m) throws Exception {
		// TODO Auto-generated method stub
		this.getOwner().handleRequest(owner -> ((AccessPoint)owner)).routeMessage(m);
	}

	@Override
	public void ping() throws Exception {
		// TODO Auto-generated method stub
		this.getOwner().handleRequest(owner -> ((AccessPoint)owner)).ping();
	}

}
