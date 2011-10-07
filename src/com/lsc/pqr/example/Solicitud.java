package com.lsc.pqr.example;

import java.util.List;

import co.s4n.os.EntityWithStates;
import co.s4n.os.EntityState;
import co.s4n.os.events.DomainEvent;
import co.s4n.os.observer.Observer;

/**
 * EntityWithStates
 * Solicitud
 * @author Yuji Kiriki.
 * Nov 23, 2010
 */

public class Solicitud extends EntityWithStates
{
//------------------------------
//        Attributes
//------------------------------
	
//------------------------------
//        Constructors
//------------------------------
	
	/**
	 * Constructor
	 */
	public Solicitud( List< Observer< DomainEvent< EntityState >>> observers, String id, EntityState state, List< EntityState > states )
	{
		super( observers, id, state, states );
	}

//------------------------------
//          Methods
//------------------------------
	
//------------------------------
//       Private methods
//------------------------------

}




