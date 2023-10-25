# Advanced Programming Assignment-1

**Name:** Aniket Gupta
**Roll no.:** 2022073

## Project Overview

The library system is structured using five key classes to manage members, books, and librarian functionalities. The Main class serves as the project's primary driver, orchestrating its functionality. The following are the key classes used:

1. **Main Class:** Contains the `main()` method and serves as the entry point of the program.

2. **Library Class:** Acts as a central repository, housing data such as lists of members and books.

3. **Librarian Class:** Responsible for making modifications to the data stored within the library class and provides access to librarian-specific menu options.

4. **Member Class:** Designed to provide members with access to menu options tailored for members.

5. **Book Class:** Contains comprehensive information about individual books in the system.

## Running the Program

To run the program, follow these steps:

1. Extract the zip folder.

2. Ensure that Maven is present in the same directory as the project (A1_2022073 folder).

3. Open Windows Powershell and navigate to the directory containing the project (A1_2022073 folder).

4. Compile the project using the following command: `mvn clean install`

5. Execute the project using the following command: `java -jar .\target\A1_2022073-1.0-SNAPSHOT.jar`

## Input Format

**Member information:**

- Name: String
- Age: Integer (do not input any string characters)
- Phone Number: Long Integer (do not input any string characters)

**For Book Information:**

- Book Title: String
- Book Author: String
- Total Copies: Integer

## Important Error Handling Points

1. **Member with Books or Pending Fine:** The program handles errors when attempting to remove a member who has books issued to their name or has a pending fine. It displays an appropriate error message, preventing unintended removal.

2. **Book Issued by a Member:** Similarly, the system prevents the removal of books that are currently issued by a member. It ensures that books are returned before they can be removed from the library system.

3. **Unique Member ID (Phone No.):** The phone number serves as the unique member ID, and the program enforces this uniqueness. When adding a new member, it checks if the phone number is already associated with an existing member, providing an error message if a duplicate is detected.

4. **Error Handling for Non-Existent Members/Books:** Robust error handling is in place to address scenarios where users attempt to remove members or books that do not exist in the system. The program ensures that removal operations are performed only on valid and existing records.

These error handling mechanisms enhance the reliability and user-friendliness of the library system, preventing common mistakes and ensuring the integrity of the data. Users are guided and informed about potential issues, making the system more user-centric and efficient. Please ensure that you provide valid input to avoid encountering any exceptions.

**Rest of the implementation is exactly as the same as the sample dry run in the assignment document.**
