#ifndef _SIMPLE_STORAGE_HEADER_
#define _SIMPLE_STORAGE_HEADER_

#include <core.h>
#define size_of_attribute(Struct, Attribute) sizeof(((Struct*)0)->Attribute)

void serialize_row(Row* source, void* destination);
void deserialize_row(void* source, Row* destination);

#endif