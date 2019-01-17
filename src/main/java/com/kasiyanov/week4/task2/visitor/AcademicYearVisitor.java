package com.kasiyanov.week4.task2.visitor;

import com.kasiyanov.week4.task2.decorator.StudentMarkDecorator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AcademicYearVisitor implements Visitor {

    private List<Integer> academicYearsList = new ArrayList<>();

    public void insertCurrentStudentAcademicYear(Decorator decorator) {
        academicYearsList.add(decorator.accept(this));
    }

    public Optional<Integer> getMaxAcademicYear() {
        return academicYearsList.stream().max(Comparator.naturalOrder());
    }

    public Optional<Integer> getMinAcademicYear() {
        return academicYearsList.stream().min(Integer::compare);
    }

    public List<Integer> getAllAcademicYears() {
        return academicYearsList;
    }

    @Override
    public Integer visitStudentMarkDecorator(StudentMarkDecorator studentMarkDecorator) {
        return studentMarkDecorator.getAcademicYear();
    }
}
