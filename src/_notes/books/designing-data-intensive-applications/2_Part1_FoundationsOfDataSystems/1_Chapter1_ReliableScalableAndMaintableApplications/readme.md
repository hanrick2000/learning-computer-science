# Reliable, Scalable, and Maintainable Applications

- [Reliable, Scalable, and Maintainable Applications](#reliable-scalable-and-maintainable-applications)
  - [Thinking About Data Systems](#thinking-about-data-systems)
  - [Reliability](#reliability)
    - [Hardware Faults](#hardware-faults)
    - [Software Errors](#software-errors)
    - [Human Errors](#human-errors)
    - [How Important Is Reliability](#how-important-is-reliability)
  - [Scalability](#scalability)
    - [Describing Load](#describing-load)
    - [Describing Performance](#describing-performance)

Many applications today are *data-intensive*, as opposed to *compute-intensive*. Raw CPU power is rarely a limiting factor for these applications—bigger problems are usually the amount of data, the complexity of data, and the speed at which it is changing.

A data-intensive application is typically built from standard building blocks that provide commonly needed functionality. For example, many applications need to:

- Store data so that they, or another application, can find it again later (*databases*)
- Remember the result of an expensive operation, to speed up reads (*caches*)
- Allow users to search data by keyword or filter it in various ways (*search indexes*)
- Send a message to another process, to be handled asynchronously (*stream processing*)
- Periodically crunch a large amount of accumulated data (*batch processing*)

When building an application, we still need to figure out which tools and which approaches are the most appropriate for the task at hand. And it can be hard to combine tools when you need to do something that a single tool cannot do alone.

In this chapter, we will start by exploring the fundamentals of what we are trying to achieve: reliable, scalable, and maintainable data systems. We’ll clarify what those things mean, outline some ways of thinking about them, and go over the basics that we will need for later chapters.

## Thinking About Data Systems

Many new tools for data storage and processing have emerged in recent years. They are optimized for a variety of different use cases, and they no longer neatly fit into traditional categories. For example, there are data stores that are also used as message queues (Redis), and there are message queues with database-like durability guarantees (Apache Kafka). The boundaries between the categories are becoming blurred.

Secondly, increasingly many applications now have such demanding or wide-ranging requirements that a single tool can no longer meet all of its data processing and storage needs. Instead, the work is broken down into tasks that can be performed efficiently on a single tool, and those different tools are stitched together using application code.

If you are designing a data system or service, a lot of tricky questions arise. How do you ensure that the data remains correct and complete, even when things go wrong internally? How do you provide consistently good performance to clients, even when parts of your system are degraded? How do you scale to handle an increase in load? What does a good API for the service look like?

In this book, we focus on three concerns that are important in most software systems:

**Reliability**: The system should continue to work correctly (performing the correct function at the desired level of performance) even in the face of adversity (hardware or software faults, and even human error).

**Scalability**: As the system grows (in data volume, traffic volume, or complexity), there should be reasonable ways of dealing with that growth.

**Maintainability**: Over time, many different people will work on the system (engineering and operations, both maintaining current behavior and adapting the system to new use cases), and they should all be able to work on it *productively*.

Various techniques, architectures, and algorithms are used in order to achieve those goals.

## Reliability

For software, typical expectations include:

- The application performs the function that the user expected.
- It can tolerate the user making mistakes or using the software in unexpected ways.
- Its performance is good enough for the required use case, under the expected load and data volume.
- The system prevents any unauthorized access and abuse.

- Reliability - continuing to work correctly, even when things go wrong.
- faults - things that can go wrong.
- fault-tolerant or resilient - systems that can anticipate faults and can cope with them.
- failure - when the system as a whole stops providing the required service to the user

Best to design fault-tolerance mechanisms that prevent faults from causing failures.

SSometimes is is needed to intentionally induce faults to test and fix systems for resiliency - chaos testing. Eg.: Netflix chaos monkey.

### Hardware Faults

Hard disks are reported as having a mean time to failure (MTTF) of about 10 to 50 years [5, 6]. Thus, on a storage cluster with 10,000 disks, we should expect on  one disk to die per day.

Our first response is usually to add redundancy to the individual hardware components in order to reduce the failure rate of the system. Restoration of backup is a step in this process. Multi-machine redundancy was only required by a small number of applications for which high availability was absolutely essential.

There is a move toward systems that can tolerate the loss of entire machines, by using software fault-tolerance techniques in preference or in addition to hardware redundancy. Such systems also have operational advantages - rolling upgrades, no system downtime.

### Software Errors

The bugs that cause software faults often lie dormant for a long time until they are triggered by an unusual set of circumstances.

There is no quick solution to the problem of systematic faults in software. Lots of small things can help: carefully thinking about assumptions and interactions in the system; thorough testing; process isolation; allowing processes to crash and restart; measuring, monitoring, and analyzing system behavior in production.

### Human Errors

Humans are known to be unreliable.

How do we make our systems reliable, in spite of unreliable humans? The best systems combine several approaches:

- Design systems in a way that minimizes opportunities for error.
- Decouple the places where people make the most mistakes from the places where they can cause failures. For eg.: provide fully featured non-production sandbox environments.
- Test thoroughly at all levels, from unit tests to whole-system integration tests and manual tests. Corner case testing is important, as is automation.
- Allow quick and easy recovery from human errors, to minimize the impact in the case of a failure.
- Set up detailed and clear monitoring, such as performance metrics and error rates.
- Implement good management practices and training.

### How Important Is Reliability

- Very important.
- May be situations when to reduce development costs, reliability may be sacrificed, but need to be very conscious when cutting corners.

## Scalability

Even if a system is working reliably today, that doesn’t mean it will necessarily work reliably in the future.

Scalability is the term we use to describe a system’s ability to cope with increased load. Discussing scalability means considering questions like:

- If the system grows in a particular way, what are our options for coping with the growth?
- How can we add computing resources to handle the additional load?

### Describing Load

Load can be described with a few numbers which we call _load parameters_.

### Describing Performance