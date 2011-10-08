package co.s4n.osp.observer;

import co.s4n.osp.exceptions.BusinessException;


/**
 * EntityWithStates
 * Observer
 * @author Yuji Kiriki.
 * Nov 23, 2010
 */
public interface Observer< T extends IMessage >
{
	/**
	 * Updates the observer
	 * @throws BusinessException
	 */
	public void update( ) throws BusinessException;
	
	/**
	 * Updates the observer with a message
	 * @param message
	 * @throws BusinessException
	 */
	public void update( T message ) throws BusinessException;
}
