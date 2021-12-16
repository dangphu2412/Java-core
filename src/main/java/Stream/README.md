# Introduction
- Root reference: https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
## What is Java Stream?

  - Java Streams are basically a pipeline of aggregate operations that can be applied to process a sequence of elements
  - An aggregate operation is a higher-order function that receives a behaviour in a form of a function or lambda, and that behaviour is what gets applied to our sequence.
  - The central API class is the Stream<T>.

  ![alt text](./parallel.png)

### The classes Stream, IntStream, LongStream, and DoubleStream are streams over objects and the primitive int, long and double types. Streams differ from collections in several ways:
  - Is not a data structure that stores elements;
  - Functional in nature.
  - An operation on a stream produces a result, but does not modify its source.
  - Laziness-seeking.
  - Possibly unbounded.
  - Consumable.

## Why is Java Stream?
### Declarative paradigm
  - Streams are written specifying what has to be done, but not how.
### Lazily evaluated
  - This basically means that until we call a **terminal operation**, our stream won’t be doing anything, we will just have declared what our pipeline will be doing.
### It can be consumed only once
  - Once we call a terminal operation, a new stream would have to be generated in order to apply the same series of aggregate operations.
### Can be parallelised
  - Java Streams are sequential by default, but they can be very easily parallelised.

# Java Streams as a series of connected pipes
- Where in each pipe our data gets processed differently; this concept is very similar to UNIX pipes!
## Phases of a stream
![alt text](./phases.png)

- They won’t get executed until we call our terminal operation.
- There are two main interfaces of Java in Stream we should take care:
  - Spliterator
    - Iterating
    - The potential splitting of elements.
      - Splitting will take a big importance when running parallel streams as it’ll be the one responsible for splitting the stream to give an independent “piece of work” to each thread.
  - Collector

# Stream internals
- Java Streams operations are stored internally using a LinkedList structure and in its internal storage structure, each stage gets assigned a bitmap that follows this structure:
- You can take a look at: StreamOpFlag

![alt text](./flag.png)

## This is what bitmap representation allows Java is to do stream optimisations.
- Example:
  - map -> clear SORTED and DISTINCT bits because data may have changed **BUT** always preserve SIZED flag as the size of the stream will never be modified using map.
  - filter -> clear SIZED flag because size of the stream may have changed, but it’ll always preserve SORTED and DISTINCT flags because filter will never modify the structure of the data.

## So how does the Stream use these flags for its own benefit?
- So each operation combines the flags from the previous stage with its own flags, generating a new set of flags.
- Java Streams are able to make transparent optimisations to our Streams

## Execution
- Lazily executed -> when a terminal operation: `Collector` get executed and what happened is that the Stream selects an execution plan.
- Two main scenarios:
  - Stateless
    - A stateless operation doesn’t need to know about any other element to be able to emit a result. Examples of stateless operations are: filter, map or flatMap.
  - NOT all stages are stateless.
    - Stateful operations: On the contrary, stateful operations need to know about all the elements before emitting a result. Examples of stateful operations are: sorted, limit or distinct.

### If all operations are stateless -> the Stream can be processed in one go
### If it contains stateful operations -> the pipeline is divided into sections using the stateful operations as delimiters.

