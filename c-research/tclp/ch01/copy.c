#include <stdlib.h>
#include <stdio.h>

int main()
{
    char *source_file = "a.txt";
    char *dist_file = "b.txt";

    FILE *source_fp = fopen(source_file, "rb");
    if (source_fp == NULL)
    {
        printf("open source file fail.");
        exit(EXIT_FAILURE);
    }

    FILE *dist_fp = fopen(dist_file, "wb+");
    if (dist_fp == NULL)
    {
        printf("open dist file fail.");
        exit(EXIT_FAILURE);
    }

    int buf_len = 1024;
    char *buffer = (char *)malloc(buf_len);

    size_t read_count = 0;
    while ((read_count = fread(buffer, sizeof(char), buf_len, source_fp)) > 0)
    {
        size_t write_count = fwrite(buffer, sizeof(char), read_count, dist_fp);
        if (write_count != read_count)
        {
            if (ferror(dist_fp))
            {
                printf("write dist file fail.");
            }
        }
    }

    if (feof(source_fp))
    {
        printf("success copy");
    }
    else if (ferror(source_fp))
    {
        printf("read source file fail.");
        exit(EXIT_FAILURE);
    }
    
    free(buffer);
    fclose(source_fp);
    fclose(dist_fp);

    return EXIT_SUCCESS;
}