#include <core.h>

extern int row_cur_idx;

Pager *open_pager()
{
    Pager *pager = malloc(sizeof(Pager));
    for (int i = 0; i < PAGE_NUM; i++)
    {
        pager->pages[i] = NULL;
    }
    return pager;
}

Table *open_table(Database *db)
{
    fseek(db->file, 0, SEEK_END);
    long file_size = ftell(db->file);
    if (file_size < 0)
    {
        printf("fail get file size\n");
        exit(EXIT_FAILURE);
    }
    db->file_size = file_size;

    u_int32_t row_num = ((file_size / PAGE_SIZE) * PRE_PAGE_ROW_NUM) + ((file_size % PAGE_SIZE) / ROW_SZIE);
    row_cur_idx = row_num;

    u_int32_t page_num = (file_size / PAGE_SIZE);
    if (file_size % PAGE_SIZE > 0)
    {
        page_num++;
    }

    Table *table = malloc(sizeof(Table));
    table->max_page_idx = page_num > 0 ? page_num - 1 : page_num;
    table->pager = open_pager();
    return table;
}

Database *open_db(char *file_name)
{
    FILE *file = fopen(file_name, "a+");
    if (file == NULL)
    {
        printf("fail open file %s \n", file_name);
        exit(EXIT_FAILURE);
    }
    Database *db = malloc(sizeof(Database));
    db->file = file;
    db->table = open_table(db);
    return db;
}

void close_pager(Table *table, Database *db)
{
    Pager *pager = table->pager;
    FILE *file = db->file;

    for (int i = table->max_page_idx; i < PAGE_NUM; i++)
    {
        void *page = pager->pages[i];
        if (page != NULL)
        {
            fseek(file, i * PAGE_SIZE, SEEK_SET);
            fwrite(page, PAGE_SIZE, 1, file);
            free(page);
        }
    }
}

void close_table(Database *db)
{
    Table *table = db->table;
    close_pager(table, db);
    free(table->pager);
    free(table);
}

void close_db(Database *db)
{
    close_table(db);
    fclose(db->file);
    free(db);
}

void *solt_of_row(Database *db, int32_t row_idx)
{
    Table *table = db->table;
    Pager *pager = table->pager;

    int32_t page_idx = row_idx / PRE_PAGE_ROW_NUM;

    void *page = pager->pages[page_idx];
    if (page == NULL)
    {
        page = malloc(PAGE_SIZE);
        if (page_idx <= table->max_page_idx)
        {
            u_int32_t offset = page_idx * PAGE_SIZE;
            fseek(db->file, offset, SEEK_SET);
            if (page_idx < table->max_page_idx)
            {
                fread(page, PAGE_SIZE, 1, db->file);
            }
            else
            {
                fread(page, (db->file_size - offset), 1, db->file);
            }
        }
        pager->pages[page_idx] = page;
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