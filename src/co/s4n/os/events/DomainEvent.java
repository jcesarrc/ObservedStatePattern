package co.s4n.os.events;

import java.util.Calendar;
import java.util.Date;

import co.s4n.os.observer.IMessage;

/**
 * EntityWithStates
 * DomainEvent
 * @author Yuji Kiriki.
 * Nov 23, 2010
 */

public class DomainEvent< T > implements IMessage
{
//------------------------------
//        Attributes
//------------------------------
	
	private DomainEventType type;
	private Date occured;
	private Date notified;
	private T data;
	
//------------------------------
//        Constructors
//------------------------------
	
	/**
	 * Constructor
	 */
	public DomainEvent( DomainEventType type, T data )
	{
		super( );
		this.type = type;
		this.occured = Calendar.getInstance( ).getTime( );
	}
	
//------------------------------
//          Methods
//------------------------------

	/**
	 * @return
	 */
	public DomainEventType getType( )
	{
		return type;
	}
	
	/**
	 * @return
	 */
	public Date getOccured( )
	{
		return occured;
	}

	/**
	 * @param occured
	 */
	public void setOccured( Date occured )
	{
		this.occured = occured;
	}

	/**
	 * @return
	 */
	public Date getNotified( )
	{
		return notified;
	}

	/**
	 * @param notified
	 */
	public void setNotified( Date notified )
	{
		this.notified = notified;
	}

	/**
	 * @return
	 */
	public T getData( )
	{
		return data;
	}
	
	/**
	 * @return
	 */
	public void setData( T data )
	{
		this.data = data;
	}
	
	/**
	 * @param other
	 * @return
	 */
	public Boolean isSameEventAs( DomainEvent< T > other )
	{
		boolean occuredAtTheSameTime = other.occured.equals( this.occured );
		boolean haveTheSameType = other.type.equals( this.type );
		return occuredAtTheSameTime && haveTheSameType;
	}

//------------------------------
//       Private methods
//------------------------------

}




