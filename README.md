# ClinX - Clinic Management System

## Quick Summary (for Interviewers)
ClinX is a console-based clinic management system built in Java. It demonstrates an end-to-end flow for authentication, doctor and patient management, appointment booking, billing, and prescriptions. The project is structured using a simple layered approach (View -> Service -> Repository) with an in-memory datastore.

## What This App Demonstrates
- Login and registration with password hashing
- CRUD-style flows for doctors, patients, appointments, invoices, and prescriptions
- Input validation and basic business rules
- Clean separation of concerns across layers

## Tech Stack
- Java
- SQL (planned)

## How It Works (Flow)
1) User registers or logs in.
2) Main menu routes to feature modules.
3) Each module uses View classes for input, Service classes for logic, and Repository classes for data access.
4) Data is stored in memory for quick demo purposes.

## Project Structure (High-Level)
- Main: app entry point and menu routing
- features/*: feature modules (doctor, patient, appointment, billing, prescription, auth)
- data/repository: in-memory datastore
- data/dto: data transfer objects
- security: password hashing

## Default Login (Demo)
- Email: admin@clinx.com
- Password: admin123

## How to Run
1) Open the project in VS Code or any Java IDE.
2) Run Main.java.

## Current Limitations
- In-memory storage only (resets on restart)
- No real SQL persistence yet
- Console-based UI
