/**
 * This package and its sub packages contains examples related to object design.
 * These could be a design principle, or design pattern, or a attempt to solve a
 * design problem.
 * <p>
 * The three traits has a bad design.
 * <ul>
 * <li>It is hard to change because every change affects too many other parts of
 * the system. (Rigidity)</li>
 * <li>When you make a change, unexpected parts of the system break. (Fragility)
 * </li>
 * <li>It is hard to reuse in another application because it cannot be
 * disentangled from the current application. (Immobility)</li>
 * </ul>
 * </p>
 * <p>
 * <b> Design Principles: </b> A design principle is a basic tool or technique
 * that can be applied to designing or writing code to make that code more
 * maintainable, flexible, or extensible.
 * <ul>
 * <li>Encapsulate what varies - Identify the aspects of your application that
 * vary and separate them from what stays the same.</li>
 * <li>Program to an interface, not an implementation.</li>
 * <li>Classes are about behavior and functionality.</li>
 * <li>Favor composition over inheritance.</li>
 * <li>Strive for loosely coupled designs between objects that interact.</li>
 * <li>DRY - Don't repeat yourself. E.g, {@link org.learnjava.design.DryExample
 * Don't Repeat Yourself}</li>
 * <li>Principle of Least Knowledge - talk only to your immediate friends.</li>
 * <li>The Hollywood Principle Don’t call us, we’ll call you. E.g,
 * {@link org.learnjava.design.HollywoodPrincipleExample The Hollywood
 * Principle}</li>
 * <li>Each class in your application should have only one reason to change.
 * E.g, {@link org.learnjava.design.SingleResponsibilityExample Single
 * Responsibility Principle}</li>
 * <li>Classes should be open for extension but closed for modification.
 * {@link org.learnjava.design.OpenCloseExample Open Close Principle}</li>
 * <li>Derived classes must be substitutable for their base classes.
 * {@link org.learnjava.design.LiskovSubstitutionExample Liskov's Substitution
 * Principle}</li>
 * <li>Make fine grained interfaces that are client specific.
 * {@link org.learnjava.design.InterfaceSegregationExample Interface Segregation
 * Principle}</li>
 * <li>Depend upon abstractions. Do not depend upon concrete classes.
 * {@link org.learnjava.design.DependencyInversionExample Dependency Inversion
 * Principle}</li>
 * </ul>
 * The last 5 in the list are called SOLID principles and is an acronym for the
 * first five object-oriented design principles by Robert C. Martin.
 * </p>
 * 
 * <p>
 * <b>Further Reading:</b>
 * </p>
 * <ul>
 * <li>Head First Object-Oriented Analysis and Design By by David West, Brett
 * McLaughlin, Gary Pollice</li>
 * <li>Head First Design Patterns: A Brain-Friendly Guide By Bert Bates, Kathy
 * Sierra, Eric Freeman, Elisabeth Robson</li>
 * <li><a href="http://www.oodesign.com/design-principles.html"> http://www.
 * oodesign.com/design-principles.html</a></li>
 * <li><a href="http://butunclebob.com/ArticleS.UncleBob.PrinciplesOfOod">http:/
 * /butunclebob.com/ArticleS.UncleBob.PrinciplesOfOod</a></li>
 * </ul>
 * </p>
 * 
 * @author psajja
 *
 */
package org.learnjava.design;