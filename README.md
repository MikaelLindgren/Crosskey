# Crosskey
In this map there are the files that are my solution to the mortgage-codetest.

## Limitations
This code works if the input is formatted as in the .txt file given in the problem.

## Usage

Put the files Crosskey.java and Entry.java in the same map as prospects.txt and compile them. Crosskey.java will read from the .txt file using a bufferedreader to acquire one line at a time, and send that line into the funcktion lineReader, which at each character evaluates wether it and its neighbour is a comma and a digit respectively. If the answer is no, then the String being built is not finished. If the answer is yes, then we start building the next String. Each element in the array of strings strA will be either left alone (if we wish to end up with a string), or be converted into a double. At this point we create an Entry object in order to return multiple connected and different types of objects back to the main function. Here, the monthly rate E is calculated exactly as in the formula given in the file Codetest-mortageplan.pdf . Since java.math was not allowed, I Houdini:ed my own power-function which through the power of mathematical wizardry returns the result of a^b.
