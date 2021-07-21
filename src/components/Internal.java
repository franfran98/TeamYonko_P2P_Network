package components;

import java.util.Set;

import connectors.ServiceConnector;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import interfaces.CommunicationCI;
import interfaces.MessageI;
import interfaces.P2PAddressI;
import interfaces.RegistrationCI;
import interfaces.RoutingManagementCI;
import ports.elementOutboundPort;
import utils.ConnectionInfo;
import utils.Position;

@RequiredInterfaces(required = { RegistrationCI.class })
@OfferedInterfaces(offered = { CommunicationCI.class, RoutingManagementCI.class })
public class Internal extends AbstractComponent{
	private P2PAddressI address; 
	private String communicationInboundPortURI; 
	private Position initialPosition;
	private double initialRange;
	private String routingInboundPortURI;
	private elementOutboundPort simulatorOutboundPort;
	
	protected Internal(P2PAddressI address, String communicationInboundPortURI, Position initialPosition, double initialRange, String routingInboundPortURI) {
		super(1,0);
		this.address = address;
		this.communicationInboundPortURI = communicationInboundPortURI;
		this.initialPosition = initialPosition;
		this.initialRange = initialRange;
		this.routingInboundPortURI = routingInboundPortURI;
		try {
			simulatorOutboundPort = new elementOutboundPort(this);
			simulatorOutboundPort.localPublishPort();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connect(P2PAddressI address, String communicationInbondPortURI, String routingInboundPortURI) throws Exception {
		
	}
	
	public void routeMessage(MessageI m)throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void ping() throws Exception {
		// TODO Auto-generated method stub
	}
	
	@Override
	public synchronized void execute() throws Exception{
		doPortConnection(simulatorOutboundPort.getPortURI(), Simulator.URI, ServiceConnector.class.getCanonicalName());
		Set<ConnectionInfo> conns = simulatorOutboundPort.registerInternal(address, communicationInboundPortURI, initialPosition, initialRange, routingInboundPortURI);
	}
	
	@Override
	public void	finalise() throws Exception {
		doPortDisconnection(simulatorOutboundPort.getPortURI());
		this.simulatorOutboundPort.unpublishPort();
		super.finalise();
	}
}
