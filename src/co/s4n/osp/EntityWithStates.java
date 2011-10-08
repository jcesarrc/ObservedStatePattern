package co.s4n.osp;

import java.util.List;

import co.s4n.osp.events.DomainEvent;
import co.s4n.osp.events.DomainEventType;
import co.s4n.osp.exceptions.BusinessException;
import co.s4n.osp.exceptions.HasSameStateException;
import co.s4n.osp.observer.Observable;
import co.s4n.osp.observer.Observer;

/**
 * EntityWithStates
 * EntityWithStates
 * @author Yuji Kiriki.
 * Nov 20, 2010
 */
public abstract class EntityWithStates extends Observable< DomainEvent< EntityState > >
{
//------------------------------
//        Attributes
//------------------------------
	
	private String id;
	private EntityState state;
	private List< EntityState > states;
	
//------------------------------
//        Constructors
//------------------------------

	/**
	 * Constructor
	 */
	public EntityWithStates( List< Observer< DomainEvent< EntityState >>> observers, String id, EntityState state, List< EntityState > states )
	{
		super( observers );
		this.id = id;
		this.state = state;
		this.states = states;
	}


//------------------------------
//          Methods
//------------------------------
	
	/**
	 * @param states
	 */
	public void setStates( List< EntityState > states )
	{
		this.states = states;
	}
	
	/**
	 * @return
	 */
	public List< EntityState > getStates( )
	{
		return states;
	}

	/**
	 * @return The actual state of the entity
	 */
	public EntityState getState( )
	{
		return state;
	}
	
	/**
	 * @return The actual state of the entity
	 * @throws BusinessException 
	 */
	public void setState( EntityState newState ) throws BusinessException
	{
		if( newState.isTheSameStateAs( this.state ) )
			throw new HasSameStateException( );

		this.state = newState;
		DomainEvent< EntityState > message = new DomainEvent< EntityState >( DomainEventType.DOMAIN, newState );
		notifyObservers( message );
	}
		
	/**
	 * @return
	 */
	public String getId( )
	{
		return id;
	}

//------------------------------
//       Private methods
//------------------------------
	
}





