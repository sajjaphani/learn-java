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
	- [Deadlocks](#deadlocks)
	- [Locks](#locks)
	- [Dining Philosophers Problem](#dining-philosophers-problem)
	- [Callable](#callable)
	- [Uncaught Exception Handler](#uncaught-exception-handler)
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

The [producer–consumer problem](https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem) (also known as the bounded-buffer problem) is a classic example of a multi-process synchronization problem. The problem describes two processes, the producer and the consumer, who share a common, fixed-size buffer used as a queue.

This [example](/src/org/learnjava/concurrent/producerconsumer/ProducerConsumerSynchronizedExample.java) demonstrates the use of synchronization(wait, notify/notifyAll) to solve the problem.

This [example](/src/org/learnjava/concurrent/producerconsumer/ProducerConsumerBlockingQueueExample.java) solves the problem using [BlockingQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/BlockingQueue.html).

This [example](/src/org/learnjava/concurrent/producerconsumer/ProducerConsumerSemaphoreExample.java) solves the problem using [Semaphores](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Semaphore.html), where a single element custom Queue is implemented.

This [example](/src/org/learnjava/concurrent/producerconsumer/ProducerConsumerSemaphoreExample2.java) solves the problem using [Semaphores](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Semaphore.html), where a custom bounded Queue is implemented.

### Fork/Join

The [fork/join framework](https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html) is an implementation of the [ExecutorService](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html) helps you take advantage of multiple processors. It is designed for work that can be broken into smaller pieces recursively. The goal is to use all the available processing power to enhance the performance of your application.

The center of the fork/join framework is the [ForkJoinPool](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html). ForkJoinPool implements the core work-stealing algorithm and can execute [ForkJoinTask](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinTask.html) processes.

This [example](/src/org/learnjava/concurrent/forkjoin/ForkJoinActionExample.java) demonstrates the use of ForkJoinPool to execute a [RecursiveAction](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/RecursiveAction.html) which does not produce any result.

This [example](/src/org/learnjava/concurrent/forkjoin/ForkJoinTaskExample.java) demonstrates the use of ForkJoinPool to execute a [RecursiveTask](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/RecursiveTask.html) which does not produce any result.

## Object Design

To be filled