package ports;

import java.util.Set;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.interfaces.RequiredCI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;
import interfaces.P2PAddressI;
import interfaces.RoutingManagementCI;
import utils.RouteInfo;

public class routingOutboundPortURI extends AbstractOutboundPort implements RoutingManagementCI{

	public routingOutboundPortURI(String uri, ComponentI owner) throws Exception {
		super(uri, RoutingManagementCI.class, owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateRouting(P2PAddressI neighbourg, Set<RouteInfo> routes) throws Exception {
		// TODO Auto-generated method stub
		((RoutingManagementCI)getConnector()).updateRouting(neighbourg, routes);
	}

	@Override
	public void updateAccessPoint(P2PAddressI neighbour, int numberOfHops) throws Exception {
		// TODO Auto-generated method stub
		((RoutingManagementCI)getConnector()).updateAccessPoint(neighbour, numberOfHops);
	}

}
