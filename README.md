# EmployeeDataManager

This application requires you to develop a java program for such a scenario that the manager of a fast
food store wants to use it for calculating weekly wage for N employees. N should be declared as a
constant and set N=5 or N=7 for the purpose of test. The program requires displaying, sorting and
searching the stored data such as employee name, and the worked hours with corresponding wages as
shown in figures on the next few pages.

The hourly pay rate depends on the skill level of an employee as below:
 Skill level Hourly rate
1 $15
2 $17
3 $21

The calculation scheme of wage for each employee. The program also requires validation for the input data – 
employee name and worked hours. A valid name is assumed
only to contain English letters, a space between first name and surname, and the length is not
exceeding 25 letters. The valid value of weekly worked hours must be at the range between 0 and 60. An error
message should be displayed and re-entering data is required, if the user enters the worked hours
outside this range.

The data of employee names, worked hours and the calculated wages (unsorted) are required to store
in three arrays (The sample data in Figure 2 on next page contain 5 records. You can enter these
sample data to test your program functionality). You must use parallel arrays or ArrayLists in this
assignment to store these data. Your application should display and execute a menu with the
following options. A switch statement must be used to execute the following menu options.
Note: if the user has not entered the employee data and one of options between 2 and 7 is selected, an
error message should be displayed and the program returns to the main menu.

1. Input & validate data
2. Display
3. Sort by name
4. Sort by hours
5. Search by name
6. Search by hours
7. Statistics
8. Exit

The details for each option are described as below.

1. Input & validate data
This option reads each employee’s name, skill level, and worked hours for N people from the
keyboard. The name and worked hours must be stored in two separate one-dimension arrays/arraylists.
If the input of worked hours exceeds the ranges
defined on the last page, then an appropriate message should be displayed and the user should be
asked to re-enter a new value.

2. Display
This option displays the employee names, worked hours and calculated wages that are stored in
Arrays/ArrayLists for all employees entered.

3. Sort by name
When this option is selected, the names of employee are sorted in ascending order and this option
also displays sorted names with their worked hours and wage data.You can use
any sorting algorithm which uses at least two while loops and one if statement. A built-in sort should
not be used.

4. Sort by hours
This option sorts the worked hours in ascending order and displays the corresponding changes of
employee names and wages.

5. Search by name
When the ‘Search by name’ option is executed and the user enters a employee’s name regardless of
the lower case or upper case in the name spelling, the worked hours, and wage for that employee will
be displayed. If the entered name doesn’t match any existing name, it should display a warning message.

6. Search by hours
If the user selects this option and enters a particular number of worked hour, the running program will
display the employee names and worked hours that are less than the particular number.

7. Statistics
If the user selects this option, the program will calculate and display the lowest and highest value of
worked hours and corresponding employee names, and the median worked hours.

8. Exit
Selecting ‘Exit’ option will exit the execution of the program.
