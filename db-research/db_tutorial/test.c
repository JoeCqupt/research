#include <stdio.h>

#define size_of_attribute(Struct, Attribute) sizeof(((Struct *)0)->Attribute)

typedef struct
{
    int field1;
    char field2[32];
} AType;

int main()
{
    AType *a_type = (AType *)0;
    printf("sizeof  %lu \n", sizeof(*a_type));
    printf("sizeof field1 %lu \n", sizeof(a_type->field1));
    printf("sizeof field2 %lu \n", sizeof(a_type->field2));

    int f1 = a_type->field1;
    printf("value: %d \n", f1); // Segmentation fault: 11
}