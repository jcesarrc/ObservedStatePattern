package com.lsc.pqr.example;

import java.util.ArrayList;

import co.s4n.os.EntityState;
import co.s4n.os.events.DomainEvent;
import co.s4n.os.events.DomainEventType;
import co.s4n.os.exceptions.BusinessException;
import co.s4n.os.exceptions.HasSameStateException;
import co.s4n.os.observer.Observer;

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
		/* Configuration of observers */
		ArrayList< Observer< DomainEvent< EntityState >>> observers = new ArrayList< Observer< DomainEvent< EntityState >>>( );
		{
			ArrayList< DomainEvent< EntityState > > interestingDomainEvents = new ArrayList< DomainEvent< EntityState > >( );
			{
				interestingDomainEvents.add( new DomainEvent< EntityState >( DomainEventType.DOMAIN, new StateB( ) ) );
			}
			observers.add( new NotificationXXXEventListener( interestingDomainEvents ) );
		}

		/* Defined states of the entity */
		ArrayList< EntityState > states = new ArrayList< EntityState >( );
		{
			states.add( new StateA( ) );
			states.add( new StateB( ) );
		}

		/*-----------------------*/
		/*   Actual client code  */
		/*-----------------------*/
		Solicitud solicitud = new Solicitud( observers, "Solicitud #1", new StateA( ), states );
		try
		{
			solicitud.setState( new StateB( ) );
			System.out.println( solicitud.getState( ) );
		}
		catch ( HasSameStateException e )
		{
			e.printStackTrace( );
			System.out.println( "La solicitud ya se encuentra en el estado." );
		}
		catch ( BusinessException e )
		{
			e.printStackTrace( );
		}
	}

}
