package components;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;
import interfaces.P2PAddressI;
import interfaces.PositionI;
import interfaces.RegistrationCI;
import ports.SimulatorInboundPort;
import utils.ConnectionInfo;
import utils.ElementData;

@OfferedInterfaces(offered = { RegistrationCI.class })
public class Simulator extends AbstractComponent{
	
	public static String URI = "simulator-uri"; 
	private Map<P2PAddressI, ElementData> internals;
	private Map<P2PAddressI, ElementData> accessPoints;
	private SimulatorInboundPort simulatorInboundPort;

	protected Simulator() {
		super(5, 0);
		// TODO Auto-generated constructor stub
		internals = new HashMap<>();
		accessPoints = new HashMap<>();

		try {
			this.simulatorInboundPort = new SimulatorInboundPort(URI, this);
			simulatorInboundPort.publishPort();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public synchronized void shutdown() throws ComponentShutdownException {
		try {
			simulatorInboundPort.unpublishPort();
			System.out.println("Simulateur arrétée...");
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
	}
	
	@Override
	public synchronized void execute() throws Exception {
		System.out.println("Simulateur lancée...");
		super.execute();
	}
	
	public Set<ConnectionInfo> registerInternal (P2PAddressI address, String communicationInboundPortURI, PositionI initialPosition, 
			double initialRange, String routingInboundPortURI) {
		System.out.println("Enregistrement d'un élément interne");
		Set<ConnectionInfo> res = new HashSet<>();
		
		internals.put(address, new ElementData(communicationInboundPortURI, initialPosition, routingInboundPortURI));

		for (Map.Entry inter : internals.entrySet()) {
			ElementData current = ((ElementData) inter.getValue());
			PositionI temp = ((ElementData) inter.getValue()).getInitialPosition();	    
			if(initialPosition.distance(temp)<=initialRange) {
				res.add(new ConnectionInfo((P2PAddressI)inter.getKey(), current.getCommunicationInboundPortURI(), current.getRoutingInboundPortURI()) );
			}
		}
		
		for (Map.Entry accessPoint : accessPoints.entrySet()) {
			ElementData current = ((ElementData) accessPoint.getValue());
			PositionI temp = ((ElementData) accessPoint.getValue()).getInitialPosition();	    
			if(initialPosition.distance(temp)<=initialRange) {
				res.add(new ConnectionInfo((P2PAddressI)accessPoint.getKey(), current.getCommunicationInboundPortURI(), current.getRoutingInboundPortURI()) );
			}
		}
		System.out.println("Nb connexion possible pour ce Internal : "+ res.size());
		System.out.println("Enregistrement d'un interne : FINI");
		return res;
		
	}
	
	public Set<ConnectionInfo> registerAccessPoint (P2PAddressI address, String communicationInboundPortURI, PositionI initialPosition, 
			double initialRange, String routingInboundPortURI) {
		System.out.println("Enregistrement d'un point d'accés...");
		
		accessPoints.put(address, new ElementData(communicationInboundPortURI, initialPosition, routingInboundPortURI));
		
		Set<ConnectionInfo> res = new HashSet<>();
		
		for (Map.Entry inter : internals.entrySet()) {
			ElementData current = ((ElementData) inter.getValue());
			PositionI temp = ((ElementData) inter.getValue()).getInitialPosition();	    
			if(initialPosition.distance(temp)<=initialRange) {
				res.add(new ConnectionInfo((P2PAddressI)inter.getKey(), current.getCommunicationInboundPortURI(), current.getRoutingInboundPortURI()) );
			}
		}
		
		for (Map.Entry accessPoint : accessPoints.entrySet()) {
			ElementData current = ((ElementData) accessPoint.getValue());
			PositionI temp = ((ElementData) accessPoint.getValue()).getInitialPosition();	    
			res.add(new ConnectionInfo((P2PAddressI)accessPoint.getKey(), current.getCommunicationInboundPortURI(), current.getRoutingInboundPortURI()) );
		}
		
		System.out.println("Nb connexion possible pour ce point d'accés : "+ res.size());
		System.out.println("Enregistrement d'un point d'accés : FINI");
		
		return res;
	}
	
	public Map<P2PAddressI, ElementData> getInternals() {
		return internals;
	}

	public Map<P2PAddressI, ElementData> getAccessPoints() {
		return accessPoints;
	}


	public SimulatorInboundPort getSimulatorInboundPort() {
		return simulatorInboundPort;
	}

}
