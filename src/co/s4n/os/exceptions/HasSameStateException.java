package co.s4n.os.exceptions;

/**
 * EntityWithStates
 * HasSameStateException
 * @author Yuji Kiriki.
 * Nov 23, 2010
 */

public class HasSameStateException extends BusinessException
{
	private static final long serialVersionUID = 4785612249974473623L;

	/**
	 * Constructor
	 */
	public HasSameStateException( )
	{
		super( "The entity has already that state." );
	}
	
}
