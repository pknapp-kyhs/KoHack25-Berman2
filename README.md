# Berman2
Features:
1. A system to import question data from a file and initialize a quiz.
2. A quiz system to ask the user a series of questions and keep track of a running score.
3. A system to process the resulting score and output the users closest matches and a shaded heatmap.

Files:
Answer.java: an object to represent one potential answer to a question.
App.java: the main class running the program
DataReader.java: A class to handle reading from a .txt file and processing the resulting data into question objects.
Map.java: an object representing the heatmap displayed at the end. Contains methods to draw the map from quiz result data.
Question.java: An object that represents one question to ask the user. Also contains methods to ask the user the question.
Quiz.java: A class representing the full quiz given to the user. Includes methods to ask the user a series of questions and keep track of a running score.
ResultDisplay.java: A class representing the final window shown to the user with results. Contains methods to process completed data and put it together into one window.
Results.java: A class to directly work with and sort the results from a quiz, before it is processed for final display.
SortElement.java: An object made to hold both the number value and text of a country result. I made it because java is not in fact c so I couldn't use typedef enum.

europe.svg: an svg used to display the map of european countrys underlying the heatmap
questions.txt: the questions data imported at the begining of the program
svgSalamander-1.1.4.jar: a simple library to manipulate .svg files used to create the heatmap

List of features with info of which uses what files:
1. DataReader.java imports data from questions.txt and converts it into a quiz.java instance
2. A quiz.java instance uses instances of Question.java which use Instances of Answer.java to run a quiz
3. The results are passed into a ResultDisplay.java, which sorts it with Results.java (which converts them to instances of SortElement.java). ResultDisplay then creates a heatmap with Map.java, which formats europe.svg using the library in svgSalamander-1.1.4.jar.