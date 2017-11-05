/**
 * Examples related to deadlock situations.
 * <p>
 * Deadlock Conditions
 * <ul>
 * <li>Mutual Exclusion: The resources involved must be unshareable.</li>
 * <li>Hold and Wait: The processes must hold the resources they have already
 * been allocated while waiting for other resources.</li>
 * <li>No Pre-emption: Resources already allocated to a process cannot be
 * preempted.</li>
 * <li>Circular Wait: The processes in the system form a circular chain where
 * each process in the list is waiting for a resource held by the next process
 * in the list.</li>
 * </ul>
 * <p>
 * 
 * @author psajja
 *
 */
package org.learnjava.concurrent.deadlock;