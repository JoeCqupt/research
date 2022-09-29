#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void func(char *str);

int main()
{

    char *str = malloc(sizeof(char)*100);
    // func(str);

    char temp[] = "12345678";
    str = temp;
    
    printf("str:%s \n", str);
    return EXIT_SUCCESS;
}

void func(char *str)
{
    char temp[] = "12345678";

    // str = temp;
    strcpy(str, temp);
}