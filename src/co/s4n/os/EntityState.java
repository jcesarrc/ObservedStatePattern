package co.s4n.os;

import java.io.Serializable;

/**
 * EntityWithStates
 * IEntityState
 * @author Yuji Kiriki.
 * Nov 20, 2010
 */

public abstract class EntityState implements Serializable
{
//------------------------------
//        Attributes
//------------------------------
	
	private static final long serialVersionUID = 8215249307544517604L;
	protected String name;
	
//------------------------------
//        Constructors
//------------------------------
	
	/**
	 * Constructor
	 */
	public EntityState( String name )
	{
		super( );
		this.name = name;
	}
	
//------------------------------
//          Methods
//------------------------------
	
	/**
	 * Compares to entity states
	 * @param otherState
	 * @return 1 if they are the same state, otherwise 0
	 */
	public Boolean isTheSameStateAs( EntityState otherState )
	{
		return this.name.equals( otherState.name );
	}
	
//------------------------------
//       Private methods
//------------------------------

}




