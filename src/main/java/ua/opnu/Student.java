package ua.opnu;

public class Student {
    String name;
    int year;
    String [] coursesArray = new  String [101];
    int courseCount = 0;
    static final int ONE_YEAR_COST = 20000;

    // Конструктор студента (в якому перевіряємо правильність років навчання)
    Student(String name, int year) {
        this.name = name;
        if (year < 1 || year > 4) {
            this.year = 1;
        }
        else {
            this.year = year;
        }

     }

     // Додає курс
    void addCourse(String course) {
    if(course != null && courseCount < coursesArray.length) {
        coursesArray[courseCount] = course;
        courseCount++;
    }
    }

    // Видаляє всі курси
    void dropAll() {
        for (int i = 0; i < courseCount; i++) {
            coursesArray[i] = null;
        }
        courseCount = 0;
    }


    int getYear() {
        return this.year;
    }

    String getName(){
        return this.name;
    }

    int getCourseCount() {
        return this.courseCount;
    }

    int getTuition(){
        return this.year * ONE_YEAR_COST;
    }


}

