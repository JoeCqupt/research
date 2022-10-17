#include <iostream>

class Student
{
public:
    int age;
    const char *name;
    float score;

    void info()
    {
        std::cout << "name:" << name << " age:" << age << " score:" << score << std::endl;
    }

    void say();
};

void Student::say()
{
    std::cout << "my name is " << name << ", nice to meet you!" << std::endl;
}

int main()
{
    Student stu;
    stu.name = "joe";
    stu.age = 27;
    stu.score = 99.0;
    stu.info();

    stu.say();

    return EXIT_SUCCESS;
}