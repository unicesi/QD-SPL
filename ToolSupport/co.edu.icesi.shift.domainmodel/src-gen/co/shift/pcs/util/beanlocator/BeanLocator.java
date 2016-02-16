/**
This file is part of javaee-patterns.

javaee-patterns is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

javaee-patterns is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.opensource.org/licenses/gpl-2.0.php>.

* Copyright (c) 04. August 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package co.shift.pcs.util.beanlocator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import co.shift.pcs.util.beanlocator.GlobalJNDIName;

/**
 * Hides and simplifies the access to objects stored in the JNDI-tree.
 * 
 * @author Adam Bien, www.adam-bien.com
 */
public class BeanLocator {
	
	private GlobalJNDIName globalJNDIName;
	
	public BeanLocator(){
		globalJNDIName = new GlobalJNDIName();
	}
	
	public GlobalJNDIName getGlobalJNDIName(){
		return globalJNDIName;
	}
    /**
     * 
     * @param clazz the type (Business Interface or Bean Class)
     * @param jndiName the global JNDI name with the pattern: java:global[/<app-name>]/<module-name>/<bean-name>#<fully-qualified-
    interface-name>
     * @return The local or remote reference to the bean.
     */
    public static <T> T lookup(Class<T> clazz, String jndiName) {
            Object bean = lookup(jndiName);
            return clazz.cast(PortableRemoteObject.narrow(bean, clazz));
    }

    public static Object lookup(String jndiName) {
        Context context = null;
        try {
            context = new InitialContext();
            return context.lookup(jndiName);
        } catch (NamingException ex) {
            throw new IllegalStateException("Cannot connect to bean: " + jndiName + " Reason: " + ex, ex.getCause());
        } finally {
            try {
                context.close();
            } catch (NamingException ex) {
                throw new IllegalStateException("Cannot close InitialContext. Reason: " + ex, ex.getCause());
            }
        }
    }
}
