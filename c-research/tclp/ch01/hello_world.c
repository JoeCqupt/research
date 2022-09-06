#include <stdio.h>
#include <stdlib.h>

int main()
{

    char str[30];
    char *read = fgets(str, 30, stdin);
    if (read == NULL)
    {
        printf("read stdin error");
        exit(EXIT_SUCCESS);
    }
    printf("str:%s \n", read);

    FILE *fp = fopen("a.txt", "w+");
    if (fp == NULL)
    {
        printf("");
    }
    printf("please input:\n");

    char c;
    while ((c = getchar()) != '\n')
    {
        fputc(c, fp);
    }

    fclose(fp);

    return 0;
}