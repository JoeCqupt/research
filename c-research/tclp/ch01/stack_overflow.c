#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("make a stack overflow \n");
    // 8mb
    // char block[18 * 1024 * 1024] = {0};

    int A[20000][20000];
    return 0;
}