# Student-Record-Manager-File-I-O-Exceptions-Threads-and-OOP
A Java program demonstrating practical use of Object-Oriented Programming, exception handling, validation, file handling, and multithreading through a Student Record Management workflow using StudentManager, custom exceptions, and a loader thread.


This Java project demonstrates how to build a **Student Record Management System**  
using advanced Object-Oriented Programming concepts, exception handling, file storage,  
multithreading (loader simulation), and input validation.

The `Main` class reads user input, validates it, adds a student, handles errors, and  
saves all student records using a separate loader thread.

---

##  Features

###  **1. OOP Concepts**
- Uses `Student`, `StudentManager`, and `StudentNotFoundException`
- Demonstrates **abstraction, encapsulation, overriding, and clean class structure**

###  **2. Input Handling & Validation**
- Converts String input to numeric fields  
- Throws meaningful validation errors (e.g., empty fields, invalid marks)

###  **3. Exception Handling**
Handles:
- `NumberFormatException`
- `IllegalArgumentException`
- Custom `StudentNotFoundException`

###  **4. Multithreading**
A loader thread displays simulated “saving…” animation while writing student data.

###  **5. File Handling**
- Records are saved to a file using the manager  
- Includes method `saveAllWithLoading()` that demonstrates threaded saving

---

##  System Flow 

1. User enters:
   - Roll number  
   - Name  
   - Email  
   - Course  
   - Marks  

2. `StudentManager.addFromInput()`  
   - Converts string values  
   - Validates data  
   - Prevents duplicate roll numbers  
   - Creates and stores a `Student` object  

3. The program fetches the student using: manager.findStudent(roll)
4. Student details are displayed.

5. Records are saved using:
