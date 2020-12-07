// Grading Students
// Solution to https://www.hackerrank.com/challenges/grading/problem in C
#include<stdio.h>
 
int main()
{
    // getting input for number of grades
    int count;
    scanf("%d\n", &count);
    int grades[count];
    // getting input for grades
    for (int i = 0; i < count; i++)
    {
        scanf("%d\n", &grades[i]);
    }
    // iterating through the array
    for (int j = 0; j < count; j++)
    {
        // Setting the condition for rounding off
        if (grades[j] % 5 > 2 && !(grades[j] < 38))
        {
            // Adding 5 - remainder(number with 5) to  round it off to next multiple
            printf("%d\n", grades[j] + 5 - grades[j]%5);
        } else {
            printf("%d\n", grades[j]);
        }
    }
    return 0;
}
