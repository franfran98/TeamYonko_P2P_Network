package ports;

import java.util.Set;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.interfaces.OfferedCI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;
import interfaces.P2PAddressI;
import interfaces.RegistrationCI;
import interfaces.RoutingManagementCI;
import utils.RouteInfo;

public class routingInboundPortURI extends AbstractInboundPort implements RoutingManagementCI{

	public routingInboundPortURI(String uri, ComponentI owner) throws Exception {
		super(uri, RoutingManagementCI.class, owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateRouting(P2PAddressI neighbourg, Set<RouteInfo> routes) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccessPoint(P2PAddressI neighbour, int numberOfHops) throws Exception {
		// TODO Auto-generated method stub
	}

}
