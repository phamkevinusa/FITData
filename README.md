# FitData (Demo)
### Features
FitData is an application developed in Android Studio that contains a library of workouts to browse.

At the current state of the app, the login credentials are hard coded. This is due to the fact that we were not able to implement a database to store and retrieve user login. Addtionally, the Workout are also hard coded due to the fact that we were only able to create a database for the exercises. In database the the exercises' name, description, difficulty are sotred. The source code for the database can be access through the additonal Github link below. We decided to seperate both codes since Kevin decided that it be best to do so to keep repository clean.

Another features that we were not able to implement are the filters. In the user profile setup, the user can set the level of expertise (i.e Beginner, Expert) and the muscle groups he/she wants to focus on. However, at the current state all the exercises of all difficulties and muscle groups are diplayed.

Other than that the different screens: Log in, View Workouts, Profile and Setup, have basic functionality that allow the user to accomplish the purpose of the app.

Backend: https://github.com/phamkevinusa/FITData--backend

## How to run application
There are no requirements to run the applicaiton. All of the database prerequisites are already set up in the application itself.
Right upon cloning the repository and running it through Android Studio, the software will boot to this screen:

<img width="314" alt="Screenshot 2024-11-29 at 6 18 32 PM" src="https://github.com/user-attachments/assets/cbcfac01-a395-4ff3-a127-849f2d414586">

In this demo demonstration you must input `admin` for username and `0000` for password to continue with the program. This is due since we were not able to properly implement a user sign up; therefore, the username and login were left hardcoded.
Proceeding with `Login` you will be able to browse the database with forward and back buttons to cycle workout gruops on the top header, 
and to explore each exercise for instructions you are able to tap on them for more info.

<img width="312" alt="Screenshot 2024-11-29 at 6 21 13 PM" src="https://github.com/user-attachments/assets/760b9b60-8e0d-446c-815f-ba3abde2438b">
<img width="329" alt="Screenshot 2024-11-29 at 6 21 25 PM" src="https://github.com/user-attachments/assets/37bd0219-99e7-4f9b-abab-8508c3f41a28">

And for increased customization you are able to change your `profile` by pressing the user icon at the bottom  right of the screen to navigate to the `profile` view.
Once in the `profile` view you can change your information by tapping the gear icon in the top right which would lead you to the `setup` screen.

<img width="298" alt="Screenshot 2024-11-29 at 6 24 35 PM" src="https://github.com/user-attachments/assets/7849f616-85fc-49da-a9da-137fb4ebfea0">
<img width="317" alt="Screenshot 2024-11-29 at 6 25 03 PM" src="https://github.com/user-attachments/assets/3df26b3e-e3e4-4655-afe5-3204be379afc">
<img width="280" alt="Screenshot 2024-11-29 at 6 25 13 PM" src="https://github.com/user-attachments/assets/75722156-69f1-48d4-aeab-b3e9ab66f916">

And once you have your information in place, you are free to press the back button in the top left to return to the `profile` view and once there to access the `database` again you can press the `database` icon in the bottom left to browse once again.

Have a fun time exploring this application!
