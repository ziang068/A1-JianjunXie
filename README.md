# PROG2004 Assignment 1 - Health Clinic Appointment System

Student: Jianjun Xie (student ID: 25259492)

A console-based Java application for managing appointments at a health clinic.
No GUI, no file storage, no database.

## Project structure
| File | Role |
|---|---|
| `HealthProfessional.java` | Abstract parent class: id, name, available days. Encapsulated fields, validation in constructor, equals/hashCode based on id |
| `GeneralPractitioner.java` | GP subclass, adds registration number |
| `Nurse.java` | Nurse subclass, adds certificate id and takeBloodSample() |
| `Surgeon.java` | Surgeon subclass, adds surgical specialty |
| `Dietitian.java` | Dietitian subclass, adds qualification |
| `Appointment.java` | Same-day appointment. Validates clinic slots (08:00-16:00, 30 min). Implements Comparable |
| `AppointmentManager.java` | Add, filter by professional id, filter by patient mobile, sort by time, cancel (two overloads) |
| `AssignmentOne.java` | Entry point with main(). Demonstrates Part 3 and Part 6 |

## OOP concepts demonstrated
- Abstraction: `HealthProfessional` is abstract, so a generic professional cannot be instantiated
- Encapsulation: all fields private, getters only, constructor validation, defensive copies
- Inheritance: subclasses use `extends` and `super(...)`
- Polymorphism: all professional types stored in one `ArrayList<HealthProfessional>` and printed in one loop

## How to run
Compile all files in `src/` and run `AssignmentOne.main()`.
The console output walks through part 3 and the part 6 demonstration steps 6.1 to 6.10.
