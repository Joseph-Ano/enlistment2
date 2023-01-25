package com.orangeandbronze.enlistment;

import java.util.*;
import static org.apache.commons.lang3.Validate.*;

class Student{
    private final int studentNumber;
    private final Collection<Section> sections = new HashSet<>();

    Student(int studentNumber, Collection<Section> sections){
        if(studentNumber < 0){
            throw new IllegalArgumentException(
                "studentNumber should be non-negative, was: "
                        + studentNumber);
            }

        notEmpty(sections);

        this.studentNumber = studentNumber;
        this.sections.addAll(sections);
        this.sections.removeIf((Objects::isNull));
    }

    void enlist(Section section){
        notNull(section);
        this.sections.add(section);
    }

    @Override
    public String toString(){
        return "Student# " + studentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNumber);
    }
}
