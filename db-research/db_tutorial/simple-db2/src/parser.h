#ifndef _SIMPLE_PARSER_HEADER_
#define _SIMPLE_PARSER_HEADER_

#include "core.h"

typedef enum
{
    META_COMMAND_SUCCESS,
    META_COMMAND_UNRECOGNIZED_COMMAND
} MetaCommandResult;

typedef enum
{
    PREPARE_SUCCESS,
    PREPARE_SYNTAX_ERROR,
    PREPARE_UNRECOGNIZED_STATEMENT
} PrepareResult;

typedef enum
{
    STATEMENT_INSERT,
    STATEMENT_SELECT
} StatementType;

typedef struct
{
    StatementType type;
    Row row_to_insert; //  only used by insert statement
} Statement;

MetaCommandResult do_meta_command(char *buffer);

PrepareResult prepare_statement(char *buffer, Statement *statement);

#endif