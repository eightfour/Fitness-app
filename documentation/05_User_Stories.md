### Data Model
Store all data on server

- User details
	- Username
	- Password
- Trainings session
	- User
	- Time of gym visit
	- Weight
	- Body fat %
	- Muscle Mass
	- Training plan
	- List of carried out exercises
		- Optional: Calories consumed
- Training plans
	- Name
	- List of planned exercise
	- User
- Planned exercise
	- Exercise
    - Repetitions (ENUM: number, time)
	- Set
	- Break between set (ENUM: time)
	- Intensity (ENUM: Weight, Watts, RPE, m/s)
	- Aim (ENUM: Endurance, Strength, Recovery)
- Training exercises
	- Name
	- Description
	- Exercise type (ENUM: System, User)

### User Stories

##### Login
As a user I want to be able to login into the app, in order to have access to my personalized account

##### Record Training Session
As a user I want to record a training session based on a training plan. I want to record
- The time of the session
- My weight at the end of the session
- My body fat % at the end of the session
- My muscle mass at the end of the session
- Exercises carried out from the plan. On some exercises I want to be able to add a calory count

##### Create Trainings Plan
As a user I want to be able to create a trainings plan based on a list of predefined training exercises.

##### Create custom Training Exercises
As a user I want to create a custom exercise. Here I want to be able to specify a
- Name
- Description

##### Stopwatch
As a user I want to have a stopwatch to measure the time of my break

##### Analytics
Monitor
- Body Weight
- Body fat %
- Muscle Mass
- Weight per exercise
- Duration per exercise

##### Spotify connection
As a user I want to be able to control my spotify playback from within the app