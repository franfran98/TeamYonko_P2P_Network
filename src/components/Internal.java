package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import connectors.CommunicationServiceConnector;
import connectors.ServiceConnector;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import interfaces.CommunicationCI;
import interfaces.MessageI;
import interfaces.P2PAddressI;
import interfaces.RegistrationCI;
import interfaces.RoutingManagementCI;
import ports.AccessPointCommunicationInboundPortURI;
import ports.CommunicationOutboundPortURI;
import ports.InternalCommunicationInboundPortURI;
import ports.elementOutboundPort;
import utils.ConnectionInfo;
import utils.P2PAddress;
import utils.Position;

@RequiredInterfaces(required = { RegistrationCI.class, CommunicationCI.class })
@OfferedInterfaces(offered = { CommunicationCI.class, RoutingManagementCI.class })
public class Internal extends AbstractComponent{
	private P2PAddressI address; 
	private String communicationInboundPortURI; 
	private Position initialPosition;
	private double initialRange;
	private String routingInboundPortURI;
	private elementOutboundPort simulatorOutboundPort;
	
	private InternalCommunicationInboundPortURI icipURI;
	private List<CommunicationOutboundPortURI> copURI = new ArrayList<>();
	
	protected Internal(P2PAddressI address, String communicationInboundPortURI, Position initialPosition, double initialRange, String routingInboundPortURI) {
		super(3,0);
		this.address = address;
		this.communicationInboundPortURI = communicationInboundPortURI;
		this.initialPosition = initialPosition;
		this.initialRange = initialRange;
		this.routingInboundPortURI = routingInboundPortURI;
		try {
			icipURI = new InternalCommunicationInboundPortURI(communicationInboundPortURI, this);
			simulatorOutboundPort = new elementOutboundPort(this);
			
			icipURI.publishPort();
			simulatorOutboundPort.localPublishPort();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connect(P2PAddressI address, String communicationInbondPortURI, String routingInboundPortURI) throws Exception {
		P2PAddress other = (P2PAddress)address;
		P2PAddress a =  (P2PAddress)this.address;
		System.out.println(a.getAddress()+" se connect à : "+other.getAddress());
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
		int i = 0;
		for(ConnectionInfo c : conns) {
			this.copURI.add(new CommunicationOutboundPortURI(this));
			this.copURI.get(i).publishPort();
			doPortConnection(copURI.get(i).getPortURI(), c.getCommunicationInboundPortURI(), CommunicationServiceConnector.class.getCanonicalName());
			System.out.println("Connection Port faite");
			this.copURI.get(i).connect(address, communicationInboundPortURI, routingInboundPortURI);
			System.out.println("Connection faite");
			i++;
		}
	}
	
	@Override
	public void	finalise() throws Exception {
		doPortDisconnection(simulatorOutboundPort.getPortURI());
		this.simulatorOutboundPort.unpublishPort();
		this.icipURI.unpublishPort();
		for(CommunicationOutboundPortURI c : this.copURI) {
			doPortDisconnection(c.getPortURI());
			c.unpublishPort();
		}
		super.finalise();
	}
}
