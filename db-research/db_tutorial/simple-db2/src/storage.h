#ifndef _SIMPLE_STORAGE_HEADER_
#define _SIMPLE_STORAGE_HEADER_

#include "core.h"
#define size_of_attribute(Struct, Attribute) sizeof(((Struct *)0)->Attribute)
#define ROW_ID_SIZE size_of_attribute(Row, id)
#define ROW_USERNAME_SIZE size_of_attribute(Row, username)
#define ROW_EMAIL_SIZE size_of_attribute(Row, email)
#define ROW_SZIE (ROW_ID_SIZE + ROW_USERNAME_SIZE + ROW_EMAIL_SIZE)

#define ROW_ID_OFFSET 0
#define ROW_USERNAME_OFFSET (ROW_ID_OFFSET + ROW_ID_SIZE)
#define ROW_EMAIL_OFFSET (ROW_USERNAME_OFFSET + ROW_USERNAME_SIZE)

#define COLUMN_USERNAME_SIZE 32
#define COLUMN_EMAIL_SIZE 255
typedef struct
{
    u_int32_t id;
    char username[COLUMN_USERNAME_SIZE];
    char email[COLUMN_EMAIL_SIZE];
} Row;

#define PAGE_SIZE 4096
#define PRE_PAGE_ROW_NUM (PAGE_SIZE / ROW_SZIE)
#define PAGE_NUM 100
#define MAX_ROW_NUM (PRE_PAGE_ROW_NUM * PRE_PAGE_ROW_NUM)

typedef struct
{
    uint32_t row_num;
    void *pages[PAGE_NUM];
} Table;

Table *open_table();
void close_table(Table *table);

void *solt_of_row(Table *table, int32_t row_idx);

void serialize_row(Row *source, void *destination);
void deserialize_row(void *source, Row *destination);

#endif