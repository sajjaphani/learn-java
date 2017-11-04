# Learn Java

This repository consists of some Java examples. These examples could be a language feature, could be a design principle, how to do it in Java, etc. This is not an exhaustive list, will be adding more in future.

Below table of contents can be used to quickly navigate to the examples.<br>

## Table of Contents

- [Some Examples](#some-examples)
	- [Binary Heap](#binary-heap)
	- [Bit Manipulation](#bit-manipulation)
- [Java 7 Features](#java7-features)
- [Java 8 Features](#java8-features)
- [Concurrency](#concurrency)
	- [Threads](#threads)
	- [Synchronization](#synchronization)
	- [Locks](#locks)
	- [Callable](#callable)
	- [Uncaught Exception Handler](#uncaught-exception-handler)
	- [Synchronous Queue](#synchronous-queue)
	- [Transfer Queue](#transfer-queue)
	- [Synchronizers](#synchronizers)
		- [Semaphore](#semaphore)
- [Object Design](#objecdt-design)

## Some Examples

This section contains few examples.

### Binary Heap

In Java, PriorityQueue is based on Min Heap. To make it a Max Heap we can provide a custom comparator, where we simply can reverse the order of comparision.

See [Binary Heap Example](/src/org/learnjava/BinaryHeapExample.java) for more details.

### Bit Manipulation

[Bit Manipulation](https://en.wikipedia.org/wiki/Bit_manipulation) involves operating on the specific bits of a data, typically numbers.

See [Bit Manipulation Example](/src/org/learnjava/BitManipulationExample.java) for commonly useful operations on bits.
	
## Java 7 Features

To be filled

## Java 8 Features

To be filled

## Concurrency

This section contains some examples of multi-threading in Java.

### Threads

A [thread](https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html) is a thread of execution in a program.

This [example](/src/org/learnjava/concurrent/Threads.java) shows the ways to creating and starting a thread.

### Synchronization

The Java language provides two basic [synchronization idioms](https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html): synchronized methods and synchronized statements. 

This [example](/src/org/learnjava/concurrent/SynchronizedCounterExample.java) uses synchronized method for sharing access to fields.

### Locks

Java [Lock](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/Lock.html) API provides more visibility and options for locking. 

This [example](/src/org/learnjava/concurrent/LockCounterExample.java) shows the usage of Lock API for impleneting a counter to be accessed through multiple threads.

### Callable

A [Callable](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Callable.html) task that returns a result and may throw an exception. 

This [example](/src/org/learnjava/concurrent/CallableExample.java) contains the usage of Callable which returns a result upon completion.

### Uncaught Exception Handler

An [UncaughtExceptionHandler](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.UncaughtExceptionHandler.html) can be configured to be invoked when a Thread abruptly terminates due to an uncaught exception.

This [example](/src/org/learnjava/concurrent/UncaughtExceptionHandlerTest.java) describes different ways to configure the uncaught exception handler.

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

#### CountDownLatch

#### CyclicBarrier

#### Exchanger

#### Phaser
## Object Design

To be filled