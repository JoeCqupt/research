#include <core.h>

MetaCommandResult do_meta_command(char *buffer)
{
    if (strcmp(buffer, ".exit") == 0)
    {
        exit(EXIT_SUCCESS);
    }
    else
    {
        return META_COMMAND_UNRECOGNIZED_COMMAND;
    }
}

PrepareResult prepare_statement(char *buffer, Statement *statement)
{
    if (strncmp(buffer, "insert", 6) == 0)
    {
        statement->type = STATEMENT_INSERT;
        Row *row = &(statement->row_to_insert);
        int args_assigned = sscanf(buffer,
                                   "insert %d %s %s",
                                   &(row->id), row->username, row->email);
        if (args_assigned < 3)
        {
            return PREPARE_SYNTAX_ERROR;
        }
        return PREPARE_SUCCESS;
    }
    if (strncmp(buffer, "select", 6) == 0)
    {
        statement->type = STATEMENT_SELECT;
        return PREPARE_SUCCESS;
    }

    return PREPARE_UNRECOGNIZED_STATEMENT;
}