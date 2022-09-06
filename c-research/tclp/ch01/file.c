#include <sys/stat.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>

int main()
{
    struct stat stat_buf;
    int res_code = stat("copy.c", &stat_buf);

    if (res_code == 0)
    {
        off_t file_size = stat_buf.st_size;

        printf("file size : %lld", file_size);
    }

    return EXIT_SUCCESS;
}