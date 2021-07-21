package interfaces;

import java.util.Set;

import utils.RouteInfo;
import fr.sorbonne_u.components.interfaces.OfferedCI;
import fr.sorbonne_u.components.interfaces.RequiredCI;

public interface RoutingManagementCI extends OfferedCI, RequiredCI {
	public void updateRouting(P2PAddressI neighbourg, Set<RouteInfo> routes) throws Exception;
	public void updateAccessPoint(P2PAddressI neighbour, int numberOfHops) throws Exception;
	
}
