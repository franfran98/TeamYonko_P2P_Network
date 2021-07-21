package cvm;

import components.AccessPoint;
import components.Internal;
import components.Simulator;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.AbstractComponentHelper;
import fr.sorbonne_u.components.cvm.AbstractCVM;
import utils.P2PAddress;
import utils.Position;

public class CVM_1 extends AbstractCVM{

	public CVM_1() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public void deploy() throws Exception {
		AbstractComponent.createComponent(Simulator.class.getCanonicalName(), new Object[] {});
		AbstractComponent.createComponent(AccessPoint.class.getCanonicalName(), new Object[] {
				new P2PAddress("accessPointAddress-1"),
				"accessPointCommunicationInboundPortURI-1",
				new Position(2,3),
				10.0,
				"accessPointRoutingInboundPortURI-1"	
		});
		AbstractComponent.createComponent(AccessPoint.class.getCanonicalName(), new Object[] {
				new P2PAddress("accessPointAddress-2"),
				"accessPointCommunicationInboundPortURI-2",
				new Position(3,4),
				3.0,
				"accessPointRoutingInboundPortURI-2"	
		});
		AbstractComponent.createComponent(Internal.class.getCanonicalName(), new Object[] {
				new P2PAddress("InternalAddress-1"),
				"InternalCommunicationInboundPortURI-1",
				new Position(5,6),
				10.0,
				"InternalRoutingInboundPortURI-1"	
		});
		AbstractComponent.createComponent(Internal.class.getCanonicalName(), new Object[] {
				new P2PAddress("InternalAddress-2"),
				"InternalCommunicationInboundPortURI-2",
				new Position(2,3),
				3.0,
				"InternalRoutingInboundPortURI-2"	
		});
		super.deploy();
	}
	

	public static void main(String[] args) {
			CVM_1 c1;
			try {
				c1 = new CVM_1();
				c1.startStandardLifeCycle(5000L);
				System.exit(0);
			} catch (Exception e) {
				System.out.println(e.toString());
				e.printStackTrace();
			}
	}

}
