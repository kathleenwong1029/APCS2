Kathleen Wong
APCS2 pd 2
HW12 -- __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018-03-02

Q0: What do you make of the multiple class definitions in a single .java file?
A: It seems like multiple class definitions are possible if the keyword public
is not used to define the file .

Q1: How are the command line arguments processed?
A: The main method accesses the arguments in the parameter.

Q2: What happens if no command line arguments are given?
A: The main method has try and catch blocks, so even if no arguments are 
given, default values are already available.

Q3:  What is the nature/purpose of the recursion? Is it necessary for the 
animation?:
A:The purpose of recursion is to track the number of moves, but it is not
necessary, because since you are aware of the number of moves required,
a for loop will suffice.

Q4: What do you expect to see when you run it?
A:I expect to see a border of -1s and changing numbers.

Q5: How long do you expect it to run?
A: I expect it to run for around half a minutes, considering that the go method
continues until 8x8 moves are made, and there is a half second delay
between each move.

Q6: What does ANSI stand for? (You are permitted some intertubes searching 
here…). What is it good for?
A: ANSI stands for American National Stands Institue. It is good for 
establishing standards in processes or systems, so that products can be used 
globally. 

Q7: How did your expectations compare to your observations?
A:My expectations were the same as my observations.

Q8: How might you adapt this framework to animate a probing for a Knight’s Tour?
A: The borders of -1 can be used to block the locations that a kngight cannot
move to. We can also use the delay to follow the knight's movements.


Knight's Tour Algo
Knight Tour Also

Begin at leftmost column
1) Place the knight in the first available spot and update counter
2) Move knight to next possible spot (check all 8 possibilities) 
	Continue until:
		 1) case where all eight possible locations are blocked(go 
			back a step)
		 2) counter has reached n x n(solution has been found)
