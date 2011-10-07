package co.s4n.os.observer;

import java.util.List;

import co.s4n.os.exceptions.BusinessException;

/**
 * EntityWithStates
 * Observable
 * @author Yuji Kiriki.
 * Nov 23, 2010
 */
public class Observable < T extends IMessage >
{
//------------------------------
//        Attributes
//------------------------------
	
	private List< Observer< T > > observers;
	
//------------------------------
//        Constructors
//------------------------------
	
	/**
	 * Constructor
	 */
	public Observable( List< Observer< T > > observers )
	{
		this.observers = observers;
	}

//------------------------------
//          Methods
//------------------------------
	
	/**
	 * Adds a new observer
	 * @param observer
	 */
	public void addObserver( Observer< T > observer )
	{
		observers.add( observer );
	}
	
	/**
	 * Notify observers
	 * @throws BusinessException
	 */
	public void notifyObservers( ) throws BusinessException
	{
		for ( Observer< T > observer : observers )
		{
			observer.update( );
		}
	}
	
	/**
	 * Notify observers using message
	 * @param message
	 * @throws BusinessException
	 */
	public void notifyObservers( T message ) throws BusinessException
	{
		for ( Observer< T > observer : observers )
			observer.update( message );
	}
	
//------------------------------
//       Private methods
//------------------------------	
}