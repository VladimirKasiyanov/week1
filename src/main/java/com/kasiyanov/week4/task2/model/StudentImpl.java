package com.kasiyanov.week4.task2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentImpl implements Student, Comparable<StudentImpl> {

    private String name;
    private int mark;
    private int academicYear;

    @Override
    public int compareTo(StudentImpl o) {
        return this.name.compareTo(o.name);
    }
}
