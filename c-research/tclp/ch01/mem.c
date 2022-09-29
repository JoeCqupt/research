#include <stdio.h>
#include <stdlib.h>

struct Block
{
    long a;
    char b;
    long c;
};

int main()
{

    struct Block block;

    printf("a:%p b:%p c:%p \n", &block.a, &block.b, &block.c);

    printf("size of block: %lu", sizeof(block));

    return EXIT_SUCCESS;
}