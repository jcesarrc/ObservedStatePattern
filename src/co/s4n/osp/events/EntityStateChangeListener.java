package co.s4n.osp.events;

import java.util.List;

import co.s4n.osp.EntityState;
import co.s4n.osp.observer.Observer;

/**
 * EntityWithStates
 * DomainEventListener
 * @author Yuji Kiriki.
 * Nov 23, 2010
 */

public abstract class EntityStateChangeListener implements Observer< DomainEvent< EntityState > >
{
//------------------------------
//        Attributes
//------------------------------
	
	private List< DomainEvent< EntityState > > interestingDomainEvents;
	
//------------------------------
//        Constructors
//------------------------------
	
	/**
	 * Constructor
	 */
	public EntityStateChangeListener( List< DomainEvent< EntityState >> interestingDomainEvents )
	{
		super( );
		this.interestingDomainEvents = interestingDomainEvents;
	}
	
//------------------------------
//          Methods
//------------------------------
	
	/**
	 * @return The interesting domain events for this listener
	 */
	public List< DomainEvent< EntityState >> getInterestingDomainEvents( )
	{
		return interestingDomainEvents;
	}
	
	/**
	 * @param domainEvent
	 * @return
	 */
	public Boolean amIInterested( DomainEvent< EntityState > domainEvent )
	{
		for ( DomainEvent< EntityState > interestingDomainEvent : this.interestingDomainEvents )
			if( interestingDomainEvent.getType( ).equals( domainEvent.getType( ) ) )
				return Boolean.TRUE;

		return Boolean.FALSE;
	}
	
//------------------------------
//       Private methods
//------------------------------

}


