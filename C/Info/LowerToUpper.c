#include <stdio.h>

/* Program to transform lowercase to uppercase without using */
int main(){
    char lowerCase;
    printf("Enter a char in lower case: ");
    scanf("%c", &lowerCase);

    char upperCase = lowerCase - 32;
    // another way to transform lowerCase to upperCase is:
    // upperCase = lowerCase - 'a' + 'A';
    
    printf("Your upper case char is: %c", upperCase);
}