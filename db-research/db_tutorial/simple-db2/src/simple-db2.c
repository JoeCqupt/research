#include <core.h>

int main(int argc, char *argv[])
{
    InputBuffer *input_buffer = new_input_buffer();
    while (true)
    {
        print_prompt();
        read_input(input_buffer);

        if (input_buffer->buffer[0] == '.')
        {
            MetaCommandResult result = do_meta_command(input_buffer->buffer);
            switch (result)
            {
            case META_COMMAND_SUCCESS:
                continue;

            case META_COMMAND_UNRECOGNIZED_COMMAND:
                printf("Unrecognized command '%s'\n", input_buffer->buffer);
                continue;
            }
        }

        Statement statement;
        PrepareResult result = prepare_statement(input_buffer->buffer, &statement);
        switch (result)
        {
        case PREPARE_SUCCESS:
            break;

        case PREPARE_SYNTAX_ERROR:
            printf("Syntax error. Could not parse statement.\n");
            continue;

        case PREPARE_UNRECOGNIZED_STATEMENT:
            printf("Unrecognized keyword at start of '%s'.\n",
                   input_buffer->buffer);
            continue;
        }

        execute_statement(&statement);
        printf("Executed.\n");
    }

    return EXIT_SUCCESS;
}
