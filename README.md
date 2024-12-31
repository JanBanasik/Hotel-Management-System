# Hotel Management System

## Overview

The **Hotel Management System** is a Java-based application designed for managing hotel rooms, booking data, and executing various commands related to room management. The system reads room data from a CSV file and allows users to interact with it through commands.

## Features

- Read hotel room data from a CSV file.
- Store room data such as room description, price, guest details, check-in date, capacity, and duration of stay.
- Execute commands related to room management.
- Handle invalid commands and allow the system to be exited gracefully.

## Requirements

- Java 8 or higher
- A CSV file containing room data

## CSV File Format

The system expects the CSV file to have the following columns:

1. **nr_pokoju** (Unique Identifier for each room)
2. **opis** (A description of the room)
3. **cena** (Price of the room)
4. **GoscGlowny** (Name of the main guest)
5. **DodatkowiGoscie** (Names of any additional guests)
6. **DataZameldowania** (Date of check-in in the format `dd.MM.yyyy`)
7. **Pojemnosc** (Maximum capacity of the room)
8. **CzasTrwaniaPobytu** (Duration of stay in days)

Example CSV:

nr_pokoju,opis,cena,GoscGlowny,DodatkowiGoscie,DataZameldowania,Pojemnosc,CzasTrwaniaPobytu

101,VIP,100,John Smith,Sarah Smith,10.11.2024,4,4

102,VIP,100,Sarah Johnson,,10.11.2024,4,1
## Installation

1. Clone the repository or download the source code.
2. Ensure you have Java 8 or higher installed on your machine.
3. Compile the project using Maven or your preferred IDE (e.g., IntelliJ IDEA or Eclipse).

## Running the Program

1. Launch the application by running mvn clean install.
2. Execute the jar file, that is: java -jar .\main\target\main-1.0.jar
3. You will be prompted to enter the **file path** of the CSV file containing room data.
4. After entering the file path, you will be able to enter commands to interact with the hotel system.

### Supported Commands

- **checkin**: Allows guest to check in given the room number and additional information.
- **checkout**: Allows guest to check out given the room number.
- **list**: Prints out details of every room in the hotel.
- **prices**: Lists all the room prices in a hotel.
- **save**: Creates a csv file of current state of a hotel.
- **view**: Prints details of the specified room given the room number.
- **exit**: Exits the program.
## Example Usage

$ Enter filePath: /path/to/rooms.csv

$ Enter command: view Executing command: view

$ Enter command: exit Executing command: exit


## Command Structure

Commands are stored in a dictionary (implemented as a map) where each command is associated with an instance of a class that extends the `Command` abstract class. The user can type commands, and if valid, the corresponding class will execute the action.

