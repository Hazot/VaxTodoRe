# VaxTodo:re

VaxTodo:re is a command line platform made for apppointments to make appointment scheduling more efficient for employees and volunteers.
This application is a working prototype made to test the functionalities and exploring the logic behind our system.

## Features implemented

Format of this list: - Functionality (who can access it)

- Log in as a VaxTodo volunteer or employee (Volunteer and employee)
- Consult the calendar (Volunteer and employee)
- Add an appointment/visit (Volunteer and employee)
- Consult the list of visitors (Volunteer and employee)
- Delete and modify an appointment (Employee)
- Create, modify and delete a visitor account (Employee)
- Consult and modify the vaccination profile of a visitor (Employee)
- Consult the list of volunteers (Employee)
- Create, modify and delete a volunteer account (Employee)
- Complete and save an identification form (Employee)
- Retrieve and print an identification form (Employee)
- Send Vaccination Report (Employee)
- Send a callback notification (Employee)

## User Manual

To use the app (run the code), there are 2 main ways:
1. You can simply go to the release folder, open your terminal there and enter the command:
   java -jar VaxToroRe.jar. The application should be open in your terminal! If VaxTodoRe.jar
   need to be updated, in intellij, it is possible to build the application using the ANT build.xml configuration file.
2. In your IDE of choice (here IntelliJ), it is possible to open the project from inside the Prototype document and
   then you can build or create your own configuration and use the VaxTodoMain class to
   run the code.

It being a prototype, we included a dataset in order to test the application.
Upon opening, you must log in as an employee or volunteer. This will give you access
to the role-specific main menu.

## Login to the application

To log in to the application, please use one of the following credentials:

- Employee role
  - username: 123123123 | password: Annapass1!
  - username: 120158220 | password: KevinPass(1)
- Volunteer role
  - username: 123123111 | password: Mahmoudpass1!
  - username: 120158221 | password: KevinPass(2)

## Data included in the application

- Appointment
  - 305537,big,boi,2021-07-20,11:00,1
  - 877900,darth,vader,2021-07-20,11:00,2
  - 305534,punch,in,2000-07-20,11:00,1
  - 305533,punch,out,1990-07-20,11:00,1
- Employees
  - 202004286910,123123123,Annapass1!,Anna,Belle,5146758765,annabelle12@gmail.com,1530 Henri-Bourassa,H3M3E2,Montreal,1992-02-23
  - 202004286919,120158220,KevinPass(1),Kevin,Peter,5147901057,kevin.peter@umontreal.ca,2900 Edouard-Montpetit Blvd,H3T1J4,Montreal,2000-12-17
- Information forms
  - 202010250001,juan,cortez,1990-01-13,COXJ00027593,2021-07-25,true,false,false,false,Moderna,true,Moderna,294757398204837474
  - 485737394826,matcha,zanmai,1206-08-03,SDXA232738273,8545-11-01,false,false,true,true,Pfizer,true,Pfizer,72389473829473829
- Vaccination profile
  - 202010250001,2000-05-31,1,Pfizer,7658375828372873
  - 202010250001,2021-07-24,2,Moderna,2865027562739573
  - 485737394826,2021-05-31,2,AstraZeneca,7658374822376873
- Visitors
  - 202010250001;cortez;juan;1990-01-13;juan.cortez@gmail.com;5147836802
  - 202004280010;hannoune;isabelle;1994-10-06;isa.hannoune@gmail.com;4382835821
- Volunteers
  - 202004123567,123123111,Mahmoudpass1!,Mahmoud,Ahmadinejad,5148752461,mahmoud12@gmail.com,1530 Henri-Bourassa,H3M3E2,Montreal,1994-01-23,Sun,Mon
  - 202082746185,123412341,Johnpass1!,John,Doe,5148630261,john23@gmail.com,1530 Henri-Bourassa,H3M3E2,Montreal,1994-01-23,Mon,Tue,Wed
  - 202004286919,120158221,KevinPass(2),Kevin,Peter,5147901057,kevin.peter@umontreal.ca,2900 Edouard-Montpetit Blvd,H3T1J4,Montreal,2000-12-17

## Screenshots


## Progran

### Main menu (Employee)

From the main menu as an employee, you can choose one of the following options by typing the corresponding number.
Either way you can type 0 to return to the main menu.

- [1] Appointment management: Access the calendar and the list of appointments, send reminders and add, modify or delete an appointment.
- [2] Form management: Access, create or print a new form
- [3] Visitor management: Access the visitor list and add, modify or delete a visitor.
- [4] Volunteer management: Access the list of volunteers and add, modify or delete a volunteer.
- [0] Exit the application: logout.

#### Appointment management

- [1] Show calendar
- [2] Add an appointment
- [3] Show existing appointment
- [4] Send reminder notification
- [0] Back to main menu

#### Visitor management

- [1] Add a new visitor
- [2] Show existing visitor
- [3] Visitor account management: allows you to modify or delete a visitor
- [4] Visitor vaccination profile management
- [0] Back to main menu

#### Management of vaccination profiles

- [1] Show vaccination profile: displays the information
- [2] Modify one of the vaccines
- [3] Send vaccination report
- [0] Back to main menu

#### Volunteer management

- [1] Show list of volunteers
- [2] Management of volunteer accounts: Add, modify or delete a volunteer
- [0] Back to main menu

### Main Menu (Volunteer)

- [1] Appointment management: Allows access to the list of appointments by date and add appointments according to the instructions.
- [2] Visitor management: Allows access to the visitor list directly by following the instructions.
- [0] Exit the application: logout.

#### Appointment Management (Volunteer)

- [1] Show calendar
- [2] Add new appointment: create a new visit
- [3] View an existing appointment
- [0] Back to the main menu

This concludes our application, I hope you like it!

Authors:
- Antoine Ho
- Mendel Sun (responsable du projet)
- Kevin Lessard
