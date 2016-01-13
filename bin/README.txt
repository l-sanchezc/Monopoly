Name and student ID number:
	Lazaro Sanchez Campos (A20362245)
	
i. How do you run your program (i.e. what is the command line)?
	cd Monopoly
	set classpath=C:\Program Files\Java\jdk1.7.0_79\bin;
	set path=C:\Program Files\Java\jdk1.7.0_79\bin;
	cd src
	javac .\edu\iit\itmd510\Monopoly.java
	Automatic roll: java -classpath . edu.iit.itmd510.Monopoly.java
	Manual roll: java -classpath . edu.iit.itmd510.Monopoly.java -dice
	
ii. Describe your object-oriented design for the program:
	A. How are you implementing the game board?
	My game board is an array of 40 Spaces. Moreover, I use the substitution principle with the object variables
	due to most of the spaces have their own subclass.
	B. How are you implementing the spaces and the types of spaces?
	I have created a Space superclass, which its constructor only assign a name to the space.
	Then, I have 4 subclasses (Company, Property, Railroad, Tax) which extends the Space class and 
	override its constructor adding credits or a multiplier in the case of the companies (Electric company and Water works).
	C. How are you implementing the Chance and Community Chest cards?
	The Chance and Community Chest cards are Spaces with their specific names in order to identify them
	and to call the methods of drawing cards (drawChanceCard and drawCommunityChestCard) in the Monopoly class.
	
iii. What specific problems or challenges did you have implementing your solution? For example,
was there a particular requirement that you had difficulty implementing? Or perhaps
there was a particularly nasty bug in your implementation you had problems tracking down.
I had some challenges trying to implement the unit tests of MonopolyTest. Moreover, I had problems 
implementing the manual input game, but I could solve them.

iv. Were there any requirements that were not implemented or not implemented properly in
your solution? If so, please elaborate.
No.

v. Were there any requirements that were vague or open to interpretation that you had to make
a decision on how to implement? How did you elect to interpret them?
Yes, for example there are not any specifications to know if the input dice is valid (numbers between 1-6). Therefore,
I made the decision of validating the manual input in each turn. Moreover, I have added some unit tests that I do not know
if there were necessary (for example, test to draw a card).

vi. How would you rate the complexity of this MP on a scale of 1 to 10 where 1 is very easy
and 10 is very difficult. Why did you give this rating?
I think that this MP was easier than the first one, but it is also very instructive. Then, I would rate the complexity
of this MP with 6.