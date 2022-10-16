#include <iostream>
void default_args(int a, int b = 123, char c = 'a');

void default_args(int a, int b = 123, char c = 'a')
{
    using namespace std;
    cout << "a: " << a << " b: " << b << " c: " << c << endl;
}
int main()
{
    default_args(1);
    default_args(1, 2, 'b');
    return EXIT_SUCCESS;
}


