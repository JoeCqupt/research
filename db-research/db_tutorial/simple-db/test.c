#include <stdio.h>

#define size_of_attribute(Struct, Attribute) sizeof(((Struct *)0)->Attribute)

typedef struct
{
    int field1;
    char field2[32];
} AType;

typedef struct
{
    char *data;
} Block;

typedef struct Node
{
    struct Node *left;
    int value;
    struct Node *right;
} Node;

Block *build_block()
{
    Block block;
    block.data = "this is a block";

    return &block; //  address of stack memory associated with local variable 'block' returned [-Wreturn-stack-address]
}
void test1()
{
    AType *a_type = (AType *)0;
    printf("sizeof  %lu \n", sizeof(*a_type));
    printf("sizeof field1 %lu \n", sizeof(a_type->field1));
    printf("sizeof field2 %lu \n", sizeof(a_type->field2));
    // int f1 = a_type->field1;
    // printf("value: %d \n", f1); // Segmentation fault: 11
}

void test2()
{
    Block *b = build_block();
    printf("data of Block:%s \n", b->data);

    printf("a / b : %d \n", 2 / 3);
    printf("a %% b : %d \n", 2 % 3);
}

int main()
{

    // test1();

    // test2();
}
/**
 * @brief
 * 1. db_open
 *      1.1 pager_open
 *      1.2 init pager & table
 * 2. read input_buffer
 * 3. do meta command
 *      3.1 close input_buffer
 *      3.2 pager_flush
 *      3.3 free pager & table
 * 4. prepare statement
 * 5. execute statement
 *      5.1 execute select statement
 *          5.1.1 init table_start cursor
 *          5.1.2 read from cursor value
 *          5.1.3 cursor advance
 *      5.2 execute insert statement
 *          5.2.1 init table_end cursor
 *          5.2.2 write to cursor value
 *
 */