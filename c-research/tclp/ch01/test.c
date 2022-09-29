#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>

int main()
{
    int err = errno;

    char *err_msg = strerror(err);

    printf("error msg: %s ", err_msg);
    return EXIT_SUCCESS;
}