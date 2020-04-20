/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

public interface INavigatorView
{
	/**
	 * Invalidate the displayed data. A controller calls this method to notify a
	 * view that no more data is available. By receiving this notification, the
	 * view should change its appearance.
	 */
	public void invalidate ();
}
