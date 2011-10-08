package com.lsc.pqr.example;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import co.s4n.osp.EntityState;
import co.s4n.osp.events.DomainEvent;
import co.s4n.osp.events.DomainEventType;
import co.s4n.osp.exceptions.BusinessException;
import co.s4n.osp.exceptions.HasSameStateException;
import co.s4n.osp.observer.Observer;

import com.lsc.pqr.example.listeners.NotificationXXXEventListener;
import com.lsc.pqr.example.states.StateA;
import com.lsc.pqr.example.states.StateB;

public class ClientTest
{

	private ArrayList< Observer< DomainEvent< EntityState >>> observers;
	private ArrayList< DomainEvent< EntityState > > interestingDomainEvents;
	private ArrayList< EntityState > states;
	private Solicitud solicitud;
	
	@Before
	public void prepareSimpleCase( )
	{
		/* Definition of the interesting events */
		interestingDomainEvents = new ArrayList< DomainEvent< EntityState > >( );
		interestingDomainEvents.add( new DomainEvent< EntityState >( DomainEventType.DOMAIN, new StateB( ) ) );		
		/* Configuration of observers */
		observers = new ArrayList< Observer< DomainEvent< EntityState >>>( );
		observers.add( new NotificationXXXEventListener( interestingDomainEvents ) );
		/* Entity possible states */
		states = new ArrayList< EntityState >( );
		states.add( new StateA( ) );
		states.add( new StateB( ) );
		/* The entity */
		solicitud = new Solicitud( observers, "Solicitud de prueba", new StateA( ), states );
	}
	
	@Test
	public void testSettingStateB( )
	{
		try
		{
			StateB stateB = new StateB( );
			solicitud.setState( stateB );
			assertTrue( stateB.isTheSameStateAs( solicitud.getState( ) ) );
		}
		catch ( HasSameStateException e )
		{
			System.out.println( "La solicitud ya se encuentra en el estado. Mensaje de error: " + e.getMessage( ) );
		}
		catch ( BusinessException e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSettingStateA( )
	{
		try
		{
			StateA stateA = new StateA( );
			solicitud.setState( stateA );
			fail();
		}
		catch ( HasSameStateException e )
		{
			System.out.println( "La solicitud ya se encuentra en el estado. Mensaje de error: " + e.getMessage( ) );
		}
		catch ( BusinessException e )
		{
			e.printStackTrace();
		}
	}

}
