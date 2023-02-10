#include <core.h>

Table *open_table()
{
    Table *table = malloc(sizeof(Table));
    table->row_num = 0;
    for (int i = 0; i < PAGE_NUM; i++)
    {
        table->pages[i] = NULL;
    }
    return table;
}
void close_table(Table *table)
{
    for (int i = 0; i < PAGE_NUM; i++)
    {
        free(table->pages[i]);
    }
    free(table);
}

void *solt_of_row(Table *table, int32_t row_idx)
{
    int32_t page_idx = row_idx / PRE_PAGE_ROW_NUM;
    void *page = table->pages[page_idx];
    if (page == NULL)
    {
        page = malloc(PAGE_SIZE);
        table->pages[page_idx] = page;
    }

    int32_t row_offset = row_idx % PRE_PAGE_ROW_NUM;

    return page + (row_offset * ROW_SZIE);
}

void serialize_row(Row *source, void *destination)
{
    memcpy(destination + ROW_ID_OFFSET, &(source->id), ROW_ID_SIZE);
    memcpy(destination + ROW_USERNAME_OFFSET, &(source->username), ROW_USERNAME_SIZE);
    memcpy(destination + ROW_EMAIL_OFFSET, &(source->email), ROW_EMAIL_SIZE);
}

void deserialize_row(void *source, Row *destination)
{
    memcpy(&(destination->id), source + ROW_ID_OFFSET, ROW_ID_SIZE);
    memcpy(&(destination->username), source + ROW_USERNAME_OFFSET, ROW_USERNAME_SIZE);
    memcpy(&(destination->email), source + ROW_EMAIL_OFFSET, ROW_EMAIL_SIZE);
}