package ua.opnu;


public class TimeSpan {

    private int hours;
    private int minutes;

    // Конструктор
    TimeSpan(int hours, int minutes) {
        // Якщо аргументи не задовольняють (відʼємні години, або хвилини, або хвилин більше 60) ставимо інтервал 0
        if (hours < 0 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        }
        else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    // Повертає години
    int getHours() {
        return hours;
    }

    // Повертає хвилини
    int getMinutes() {
        return minutes;
    }

    // Додає вкахану кількість годин та хвилин до інтервалу
    void add(int hours, int minutes) {
        // Якщо аргументи не задовальняють - виходимо з методу
        if (hours < 0 || minutes < 0 || minutes > 59) {
            return;
        }
        // Якщо задовальняють - додаємо хвилини та години,
        else {
            this.hours += hours;
            this.minutes += minutes;
            // Переводимо зайві хвилини у години та знаходимо залишок хвилин
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    // Додає новий інтервал, до вже заданого
    void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    // Повертає години дробовим числом
    double getTotalHours() {
        return hours + minutes / 60.0;
    }

    // Повертає хвилини
    int getTotalMinutes() {
        return minutes + hours * 60;
    }

    // Знаходимо різницю між поточним та новим інтервалами
    void subtract(TimeSpan span) {
    int currentTotalMinutes =  getTotalMinutes();
    int otherTotalMinutes = span.getTotalMinutes();
    // Якщо вхідний інтервал більше за поточний - виходимо
    if (otherTotalMinutes > currentTotalMinutes) {
        return;
    }
    // Інакше знаходимо різницю інтервалів
    else {
        int newTotalMinutes = currentTotalMinutes - otherTotalMinutes;
        this.hours = newTotalMinutes / 60;
        this.minutes = newTotalMinutes % 60;
    }

    }

    // Знаходимо інтервал помножений у factor разів
    void scale(int factor) {
        // Якщо factor <= 0 - виходимо
        if (factor <= 0){
            return;
        }
        // Інакше знаходимо інтервал помножений у factor разів
        else {
            int factorTotalMinutes = getTotalMinutes() * factor;
            this.hours = factorTotalMinutes / 60;
            this.minutes = factorTotalMinutes % 60;
        }
    }
}