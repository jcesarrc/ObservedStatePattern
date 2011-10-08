package com.lsc.pqr.example;

import java.util.ArrayList;

import co.s4n.osp.EntityState;
import co.s4n.osp.events.DomainEvent;
import co.s4n.osp.events.DomainEventType;
import co.s4n.osp.exceptions.BusinessException;
import co.s4n.osp.exceptions.HasSameStateException;
import co.s4n.osp.observer.Observer;

import com.lsc.pqr.example.listeners.NotificationXXXEventListener;
import com.lsc.pqr.example.states.StateA;
import com.lsc.pqr.example.states.StateB;

/**
 * EntityWithStates
 * Client
 * @author Yuji Kiriki.
 * Nov 23, 2010
 */
public class Client
{
	/**
	 * @param args
	 */
	public static void main( String[ ] args )
	{

	}

}
