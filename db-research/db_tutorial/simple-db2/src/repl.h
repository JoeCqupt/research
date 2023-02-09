#ifndef _SIMPLE_REPL_HEADER_
#define _SIMPLE_REPL_HEADER_

#include "core.h"

typedef struct
{
    char *buffer;
    size_t buffer_length;
    ssize_t input_length;
} InputBuffer;

void print_prompt();

InputBuffer *new_input_buffer();

void read_input(InputBuffer *input_buffer);

void close_input_buffer(InputBuffer *input_buffer);

#endif
