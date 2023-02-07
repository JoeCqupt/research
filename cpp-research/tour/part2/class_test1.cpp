#include <iostream>

class Student
{
public:
    int m_age;
    const char *m_name;
    float m_score;

    Student(int age, const char *name, float score);
    Student(int age = 18);

    void info()
    {
        std::cout << "name:" << m_name << " age:" << m_age << " score:" << m_score << std::endl;
    }

    void say();
};

void Student::say()
{
    std::cout << "my name is " << m_name << ", nice to meet you!" << std::endl;
}

Student::Student(int age, const char *name, float score) : m_age(age), m_name(name), m_score(score) {}
Student::Student(int age) : m_age(age) {}

int main()
{
    Student stu;
    stu.m_name = "joe";
    stu.m_age = 27;
    stu.m_score = 99.0;
    stu.info();
    stu.say();

    Student stu2 = Student(27, "ysss", 100.0);
    stu2.info();
    stu2.say();

    Student stu3;
    printf("age of stu3: %d \n", stu3.m_age);

    return EXIT_SUCCESS;
}