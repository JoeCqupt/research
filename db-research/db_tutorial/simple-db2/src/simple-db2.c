#include <core.h>
bool RUNNING = true;

int main(int argc, char *argv[])
{
    Table *table = open_table();
    InputBuffer *input_buffer = new_input_buffer();
    while (RUNNING)
    {
        print_prompt();
        read_input(input_buffer);

        if (input_buffer->buffer[0] == '.')
        {
            MetaCommandResult result = do_meta_command(input_buffer->buffer);
            switch (result)
            {
            case META_COMMAND_SUCCESS:
                break;

            case META_COMMAND_UNRECOGNIZED_COMMAND:
                printf("Unrecognized command '%s'\n", input_buffer->buffer);
                continue;
            }
        }
        else
        {

            Statement statement;
            PrepareResult result = prepare_statement(input_buffer->buffer, &statement);
            switch (result)
            {
            case PREPARE_SUCCESS:
                execute_statement(&statement, table);
                break;

            case PREPARE_SYNTAX_ERROR:
                printf("Syntax error. Could not parse statement.\n");
                continue;

            case PREPARE_UNRECOGNIZED_STATEMENT:
                printf("Unrecognized keyword at start of '%s'.\n",
                       input_buffer->buffer);
                continue;
            }
        }
        printf("Executed.\n");
    }

    close_input_buffer(input_buffer);
    close_table(table);

    return EXIT_SUCCESS;
}
