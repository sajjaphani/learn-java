# Learn Java

This repository consists of some Java examples. These examples could be a language feature, could be a design principle, how to do it in Java, etc. This is not an exhaustive list, will be adding more in future.

Below table of contents can be used to quickly navigate to the examples.<br>

## Table of Contents

- [Some Examples](#some-examples)
	- [Fail Fast and Fail Safe Iterator](#fail-fast-and-fail-safe-iterator)
	- [External and Internal Iteration](#external-and-internal-iteration)
	- [Object Ordering](#object-ordering)
	- [Binary Heap](#binary-heap)
	- [Bit Manipulation](#bit-manipulation)
- [Java 7 Features](#java-7-features)
	- [Binary Literals](#binary-literals)
	- [Numeric Literals](#numeric-literals)
	- [Strings in Switch](#strings-in-switch)
	- [Try With Resources](#try-with-resources)
	- [Catch Multiple Exception Types](#catch-multiple-exception-types)
- [Java 8 Features](#java-8-features)
	- [Default Methods](#default-methods)
	- [Iteration](#iteration)
	- [Functional Interfaces](#functional-interfaces)
- [Concurrency](#concurrency)
	- [Threads](#threads)
	- [Busy Spinning](#busy-spinning)
	- [Synchronization](#synchronization)
	- [Deadlocks](#deadlocks)
	- [Locks](#locks)
	- [Dining Philosophers Problem](#dining-philosophers-problem)
	- [Callable](#callable)
	- [Uncaught Exception Handler](#uncaught-exception-handler)
	- [Shutdown Hooks](#shutdown-hooks)
	- [Synchronous Queue](#synchronous-queue)
	- [Transfer Queue](#transfer-queue)
	- [Synchronizers](#synchronizers)
		- [Semaphore](#semaphore)
		- [Count Down Latch](#count-down-latch)
		- [Cyclic Barrier](#cyclic-barrier)
		- [Exchanger](#exchanger)
		- [Phaser](#phaser)
	- [Ordered Execution](#ordered-execution)
	- [Producer Consumer Problem](#producer-consumer-problem)
	- [Fork/Join](#forkjoin)
- [Object Design](#object-design)
	- [Design Principles](#design-principles)
- [References](#references)

## Some Examples

This section contains few examples.

### Fail Fast and Fail Safe Iterator

Fail-fast iterators will throw a ConcurrentModificationException if the collection is structurally modified at any time after the iterator is created, with the exception of through the iterator's own remove or add methods. Fail-safe (Weakly-consistent, technically correct term), does not throw a ConcurrentModificationException if any collection is structurally modified after the iterator is created. See this [example](/src/org/learnjava/FailFastAndFailSafeIteratorExample.java) for more details. 

### External and Internal Iteration

From Java 8, we can also use internal iteration added to collections. See [Iteration](#iteration) in Java 8 Features section.

### Object Ordering

[Object Ordering](https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html) privides a way to arrange the items in a particular order from an array or a collection. Java provides two interfaces [Comparable](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html) and [Comparator](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html) for ordering the objects. This [example](/src/org/learnjava/ComparableExample.java) shows the use of Comparable to provide natural ordering to the objects. This [example](/src/org/learnjava/ComparatorExample.java) shows the use of Comparator to order the objects that otherwise not possible with natural ordering.

### Binary Heap

In Java, PriorityQueue is based on Min Heap. To make it a Max Heap we can provide a custom comparator, where we simply can reverse the order of comparision.

See [Binary Heap Example](/src/org/learnjava/BinaryHeapExample.java) for more details.

### Bit Manipulation

[Bit Manipulation](https://en.wikipedia.org/wiki/Bit_manipulation) involves operating on the specific bits of a data, typically numbers.

See [Bit Manipulation Example](/src/org/learnjava/BitManipulationExample.java) for commonly useful operations on bits.
	
## Java 7 Features

There are a number of enhancements added to [Java 7](https://docs.oracle.com/javase/7/docs/technotes/guides/language/enhancements.html). This section presents few examples of the same.

### Binary Literals

In Java SE 7, the integral types (byte, short, int, and long) can also be expressed using the [binary number system](https://docs.oracle.com/javase/7/docs/technotes/guides/language/binary-literals.html). This [example](/src/org/learnjava/j7/BinaryLiteralExample.java) shows the use of binary literals in Java 7 or later.

### Numeric Literals

From Java 7, any number of underscore characters (_) can appear anywhere between digits in a [numerical literal](https://docs.oracle.com/javase/7/docs/technotes/guides/language/underscores-literals.html). This allows to separate groups of digits in numeric literals, which can improve the readability of code. This [example](/src/org/learnjava/j7/NumericLiteralExample.java) shows the use of binary literals in Java 7 or later.

### Strings in Switch

From Java 7, we can use strings in [switch statement expression](https://docs.oracle.com/javase/7/docs/technotes/guides/language/strings-switch.html). This [example](/src/org/learnjava/j7/SwitchExample.java) shows the use of strings in switch statement in Java 7 or later. 

### Try With Resources

A resource must be closed after the program is finished with it. The [try-with-resources statement](https://docs.oracle.com/javase/7/docs/technotes/guides/language/try-with-resources.html) ensures that each resource is closed at the end of the statement. This [example](/src/org/learnjava/j7/TryWithResourceExample.java) shows the use of try with resources. 

### Catch Multiple Exception Types

From Java 7, a single catch block can handle more than one type of exception. [This feature](https://docs.oracle.com/javase/7/docs/technotes/guides/language/catch-multiple.html) can reduce code duplication and lessen the temptation to catch an overly broad exception and further enhances the readability of code. This [example](/src/org/learnjava/j7/MultiCatchExample.java) shows the use of multi-catch. 

## Java 8 Features

There are a number of enhancements added to [Java 8](https://docs.oracle.com/javase/8/docs/technotes/guides/language/enhancements.html). This section presents few examples of the same.

### Default Methods

[Default methods](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html) in Java 8 allows developers to add new methods to existing interfaces without breaking the existing implementations. Default methods allows to extend existing interfaces in a backward compatible way. Further the implementing classes can choose to override the default implementation provided by the interface. This [example](/src/org/learnjava/j8/DefaultMethodExample.java) shows the use of default methods in Java 8. 

### Iteration

With the addition of functional interfaces in Java 8, we can iterate the collection elements through external iteration, where the clients can focus on what to do with the elements rather than controlling the iteration. This [example](/src/org/learnjava/j8/IteratorExample.java) shows the use of internal iteration and external iteration. 

### Functional Interfaces

In Java 8, functions became first class citizens. We can take functions as arguments of other functions, return functions and store functions as objects. [Functional interfaces](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html) provide target types for lambda expressions and method references. Each functional interface has a single abstract method, called the functional method for that functional interface, to which the lambda expression's parameter and return types are matched or adapted. This [example](/src/org/learnjava/j8/FunctionalInterfaceExample.java) shows the basic use of functions in Java 8. 

## Concurrency

This section contains some examples of multi-threading in Java. The [document](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html) from Javadoc provides good starting point with a brief descriptions of the main components.

### Threads

A [thread](https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html) is a thread of execution in a program.

This [example](/src/org/learnjava/concurrent/Threads.java) shows the ways to creating and starting a thread.

### Busy Spinning

Busy spinning/waiting is a technique where one thread waits for a result from another thread and use an empty loop to wait for that result. This [example](/src/org/learnjava/concurrent/BusySpinningExample.java) shows how to busy wait for a condition. This is not a recommended approach, use other synchronization mechanisms for thread communiatioin.

### Synchronization

The Java language provides two basic [synchronization idioms](https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html): synchronized methods and synchronized statements. 

This [example](/src/org/learnjava/concurrent/SynchronizedCounterExample.java) uses synchronized method for sharing access to fields.

### Deadlocks

[Deadlock](https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html) describes a situation where two or more threads are blocked forever, waiting for each other.

This [example](/src/org/learnjava/concurrent/deadlock/DeadLockExample.java) demonstrates the occurrence of a deadlock.

This [example](/src/org/learnjava/concurrent/deadlock/DeadLockFreeExample.java) modifies the above one to eliminate the deadlock.

### Locks

Java [Lock](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/Lock.html) API provides more visibility and options for locking. 

This [example](/src/org/learnjava/concurrent/LockCounterExample.java) shows the usage of Lock API for implementing a counter to be accessed through multiple threads.

[Condition](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/Condition.html) separates the Object monitor methods (wait, notify and notifyAll) into distinct objects and combines them with the use of arbitrary Lock implementations to achieve the effect of having multiple wait-sets per object. A Lock replaces the use of synchronized methods and statements, a Condition replaces the use of the Object monitor methods.

This [example](/src/org/learnjava/concurrent/LockConditionExample.java) shows the usage of Lock with Condition to implement bounded buffer counter which can be used to solve a producer consume problem.

### Dining Philosophers Problem

The [dining philosophers problem](https://en.wikipedia.org/wiki/Dining_philosophers_problem) was designed to illustrate the challenges of avoiding deadlock, a system state in which no progress is possible.

This [example](/src/org/learnjava/concurrent/dinning/DiningPhilosophersExample.java) provides a solution to the dining philosophers problem with the help of [Fork](/src/org/learnjava/concurrent/dinning/Fork.java) and [Philosopher](/src/org/learnjava/concurrent/dinning/Philosopher.java) classes simulating the problem without result into a dead lock situation.

### Callable

A [Callable](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Callable.html) task that returns a result and may throw an exception. 

This [example](/src/org/learnjava/concurrent/CallableExample.java) contains the usage of Callable which returns a result upon completion.

### Uncaught Exception Handler

An [UncaughtExceptionHandler](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.UncaughtExceptionHandler.html) can be configured to be invoked when a Thread abruptly terminates due to an uncaught exception.

This [example](/src/org/learnjava/concurrent/UncaughtExceptionHandlerTest.java) describes different ways to configure the uncaught exception handler.

### Shutdown Hooks

Shutdown hooks allows developers to plug in a piece of code to be executed when the JVM is shutting down. This [example](/src/org/learnjava/ShutdownHookExample.java) shows the configuration of a shutdown hook. [Design of the Shutdown Hooks API](https://docs.oracle.com/javase/1.5.0/docs/guide/lang/hook-design.html) provides details regarding design decisions of the Java Shutdown Hooks API

### Synchronous Queue

A [SynchronousQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/SynchronousQueue.html) is a blocking queue in which each insert operation must wait for a corresponding remove operation by another thread, and vice versa.

This [example](/src/org/learnjava/concurrent/SynchronousQueueExample.java) uses a synchronous queue for solving producer consumer problem.

### Transfer Queue

A [TransferQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/TransferQueue.html) is a blocking queue in which producers may wait for consumers to consume elements.

This [example](/src/org/learnjava/concurrent/TransferQueueExample.java) uses a transfer queue for solving producer consumer problem.

### Synchronizers

Java provides five classes for dealing with common special-purpose synchronization idioms. This section covers example of these synchronizers.

#### Semaphore

[Semaphores](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Semaphore.html) often known as counting semaphore. A semaphore maintains a set of permits. Semaphores are often used to restrict the number of threads than can access some (physical or logical) resource.

This [example](/src/org/learnjava/concurrent/SemaphoreExample.java) demonstrates the use of Semaphores.

#### Count Down Latch

[CountDownLatch](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CountDownLatch.html) is a synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.

This [example](/src/org/learnjava/concurrent/CountDownLatchExample.java) demonstrates the use of CountDownLatch.

#### Cyclic Barrier

[CyclicBarrier](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CyclicBarrier.html) is a synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point. 

This [example](/src/org/learnjava/concurrent/CyclicBarrierExample.java) demonstrates the use of CyclicBarrier.

#### Exchanger

[An Exchanger](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Exchanger.html) represents a synchronization point at which threads can pair and swap elements within pairs.. 

This [example](/src/org/learnjava/concurrent/ExchangerExample.java) demonstrates the use of Exchanger.

#### Phaser

Added in Java 7, [Phaser is](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Phaser.html) a reusable synchronization barrier, similar in functionality to CyclicBarrier and CountDownLatch but supporting more flexible usage.

This [example](/src/org/learnjava/concurrent/PhaserExample.java) demonstrates the use of Phaser.

### Ordered Execution

Suppose you have situation where the class has three methods and each needs to be executed in a separate thread. The methods must be executed in the given order. Thread A should call first thread B should call second, and thread C should call third.

This [example](/src/org/learnjava/concurrent/OrderedExecutionExample.java) shows how to achieve the above using Semaphores.

### Producer Consumer Problem

The [producer-consumer problem](https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem) (also known as the bounded-buffer problem) is a classic example of a multi-process synchronization problem. The problem describes two processes, the producer and the consumer, who share a common, fixed-size buffer used as a queue.

This [example](/src/org/learnjava/concurrent/producerconsumer/ProducerConsumerSynchronizedExample.java) demonstrates the use of synchronization(wait, notify/notifyAll) to solve the problem.

This [example](/src/org/learnjava/concurrent/producerconsumer/ProducerConsumerBlockingQueueExample.java) solves the problem using [BlockingQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/BlockingQueue.html).

This [example](/src/org/learnjava/concurrent/producerconsumer/ProducerConsumerSemaphoreExample.java) solves the problem using [Semaphores](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Semaphore.html), where a single element custom Queue is implemented.

This [example](/src/org/learnjava/concurrent/producerconsumer/ProducerConsumerSemaphoreExample2.java) solves the problem using [Semaphores](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Semaphore.html), where a custom bounded Queue is implemented.

This [example](/src/org/learnjava/concurrent/producerconsumer/ProducerConsumerVolatileExample.java) solves the problem with the help of volatile modifier, where a single element custom Queue is implemented.

### Fork/Join

The [fork/join framework](https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html) is an implementation of the [ExecutorService](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html) helps you take advantage of multiple processors. It is designed for work that can be broken into smaller pieces recursively. The goal is to use all the available processing power to enhance the performance of your application.

The center of the fork/join framework is the [ForkJoinPool](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html). ForkJoinPool implements the core work-stealing algorithm and can execute [ForkJoinTask](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinTask.html) processes.

This [example](/src/org/learnjava/concurrent/forkjoin/ForkJoinActionExample.java) demonstrates the use of ForkJoinPool to execute a [RecursiveAction](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/RecursiveAction.html) which does not produce any result.

This [example](/src/org/learnjava/concurrent/forkjoin/ForkJoinTaskExample.java) demonstrates the use of ForkJoinPool to execute a [RecursiveTask](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/RecursiveTask.html) which does not produce any result.

## Object Design

An object contains state (data) and behaviour (methods to manipulate data). The interface of an object defines how the object can be interacted with. Object-oriented design concerned with defining the objects and their interactions to solve a problem.

### Design Principles

[Design principles](http://www.oodesign.com/design-principles.html) represent a set of guidelines that helps us to avoid having a bad design. This section present some principles with the examples. The first five of these principles are known as SOLID principles and are associated to [Robert Martin](https://www.amazon.in/Principles-Patterns-Practices-Robert-Martin/dp/0131857258). These five principles are principles of class design, focus very tightly on dependency management.

**Single Responsibility Principle**	- A class should have one, and only one, reason to change. This [example](/src/org/learnjava/design/SingleResponsibilityExample.java) shows how to decompose a class into multiple classes which handle a single responsibility upon decomposition.

**Open Closed Principle** - You should be able to extend a classes behavior, without modifying it. This [example](/src/org/learnjava/design/OpenCloseExample.java) shows how to achieve open closed principle. It also delegates the responsibily to the corresponding object as the object knows to how to deal with its state.

**Liskov Substitution Principle** -	Derived classes must be substitutable for their base classes. This [example](/src/org/learnjava/design/LiskovSubstitutionExample.java) shows how improperly extending a class violates the Liskov Substitution Principle.

**Interface Segregation Principle** - Make fine grained interfaces that are client specific. This [example](/src/org/learnjava/design/InterfaceSegregationExample.java) talks about interface segregation principle with the help of multiple interfaces that are client specific.

**Dependency Inversion Principle** - Depend upon abstractions. Do not depend upon concrete classes. This [example](/src/org/learnjava/design/DependencyInversionExample.java) shows how we can reuse the components if we depend upon abstractions rather than implementaion details

**DRY - Don't repeat yourself** - Dry talks about having each feature is implemented exactly one place where it exits. This [example](/src/org/learnjava/design/DryExample.java) shows DRY principle by placing the functionality in a common sensible place where it beongs.

**The Hollywood Principle** - Don't call us, we'll call you. This [example](/src/org/learnjava/design/HollywoodPrincipleExample.java) shows the use of Hollywood principle, which is pretty much similar to Template Method pattern.

## References

To be added.