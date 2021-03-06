/**
* Copyright ?? 2013 Universidad Icesi
* 
* This file is part of SongStock.
* 
* SongStock is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* 
* SongStock is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with SongStock.  If not, see <http://www.gnu.org/licenses/>.
**/
package co.shift.pcs.basic.web;

import com.vaadin.ui.Component;

/**
 * Interface defining the UI contributor services.
 * 
 * @author Andr??s Paz
 *
 */
public interface UIContributor {

	/**
	 * Contributes new UI elements to the specified component using the specified data (optional).
	 * @param component to be extended
	 * @param data required for the contribution (optional)
	 * @throws Exception if there was a problem extending the component.
	 */
	public void contributeUITo(Component component, Object data) throws Exception;
}
