/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

import java.util.Date;

/**
 * This interface provides functionality necessary to update a speed view.
 * 
 * @author Clemens Krainer
 */
public interface ISpeedView extends INavigatorView
{
	/**
	 * Communicate the current speed to the view.
	 *  
	 * @param date the instant as a <code>Date</code> object. 
	 * @param speed the according speed.
	 */
	public void setSpeed (Date date, double speed);
}
