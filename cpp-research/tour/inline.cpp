#include <iostream>

int  main()
{
    int n;
    std::cout << "please input a number:" << std::endl;

    std::cin >> n;

    std::cout << "abs of n :" << abs(n) << std::endl;

    return EXIT_SUCCESS;
}

inline int abs(int x)
{
    if (x >= 0)
    {
        return x;
    }
    return -x;
}