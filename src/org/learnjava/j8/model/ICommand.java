package org.learnjava.j8.model;

/**
 * This interface has a single abstract method and hence it is a functional
 * interface.
 * 
 * @author psajja
 *
 */
@FunctionalInterface
public interface ICommand {
	
	void execute(String command);
}