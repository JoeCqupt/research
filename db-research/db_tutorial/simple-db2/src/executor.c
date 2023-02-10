#include <core.h>

u_int32_t row_cur_idx = 0;

void print_row(Row *row)
{
    printf(" %d %s %s \n", row->id, row->username, row->email);
}

void execute_statement(Statement *statement, Table *table)
{
    switch (statement->type)
    {
    case STATEMENT_INSERT:
    {
        void *dist_pointer = solt_of_row(table, row_cur_idx);
        serialize_row(&(statement->row_to_insert), dist_pointer);
        row_cur_idx = row_cur_idx + 1;
        break;
    }

    case STATEMENT_SELECT:
    {
        Row cur_row;
        for (int i = 0; i < row_cur_idx; i++)
        {
            void *pointer = solt_of_row(table, i);
            deserialize_row(pointer, &cur_row);
            print_row(&cur_row);
        }
        break;
    }
    }
}
