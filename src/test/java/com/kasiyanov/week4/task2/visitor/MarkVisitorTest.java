package com.kasiyanov.week4.task2.visitor;

import com.kasiyanov.week4.task1.model.BinarySearchTree;
import com.kasiyanov.week4.task2.decorator.StudentMarkDecorator;
import com.kasiyanov.week4.task2.model.Student;
import com.kasiyanov.week4.task2.model.StudentImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import static org.junit.Assert.assertEquals;

public class MarkVisitorTest {

    private BinarySearchTree<StudentImpl> binarySearchTree = new BinarySearchTree<>();

    @Test
    public void checkMarkVisitor() {
        List<Integer> expectedListDFSPreOrder = Arrays.asList(8, 3, 1, 6, 4, 7, 10, 14, 13);
        double expectedAvgMark = 7.33;
        List<StudentImpl> studentsList = createStudentList();
        MarkVisitor markVisitor = new MarkVisitor();
        createBinarySearchTreeTest(studentsList);
        binarySearchTree.setStrategyName("DFSPreOrder");
        Iterator<StudentImpl> iterator = binarySearchTree.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            Decorator decorator = new StudentMarkDecorator(student);
            markVisitor.insertCurrentStudentMark(decorator);
        }

        List<Integer> actualMarksList = markVisitor.getAllMarks();

        OptionalDouble optionalActualAvgMark = markVisitor.getAvgMark();
        double actualAvgMark;
        if (optionalActualAvgMark.isPresent()) {
            actualAvgMark = optionalActualAvgMark.getAsDouble();
        } else {
            actualAvgMark = 0;
        }

        assertEquals(expectedListDFSPreOrder, actualMarksList);
        assertEquals(expectedAvgMark, actualAvgMark, 0.01);
    }

    @Test
    public void checkAcademicYearVisitor() {
        List<Integer> expectedListDFSPreOrder = Arrays.asList(8, 3, 1, 6, 4, 7, 10, 14, 13);
        int expectedMaxAcademicYear = 14;
        int expectedMinAcademicYear = 1;
        List<StudentImpl> studentsList = createStudentList();
        AcademicYearVisitor academicYearVisitor = new AcademicYearVisitor();
        createBinarySearchTreeTest(studentsList);
        binarySearchTree.setStrategyName("DFSPreOrder");
        Iterator<StudentImpl> iterator = binarySearchTree.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            Decorator decorator = new StudentMarkDecorator(student);
            academicYearVisitor.insertCurrentStudentAcademicYear(decorator);
        }

        List<Integer> actualAcademicYearsList = academicYearVisitor.getAllAcademicYears();

        Optional<Integer> optionalActualMaxAcademicYear = academicYearVisitor.getMaxAcademicYear();
        int actualMaxAcademicYear;
        if (optionalActualMaxAcademicYear.isPresent()) {
            actualMaxAcademicYear = optionalActualMaxAcademicYear.get();
        } else {
            actualMaxAcademicYear = 0;
        }

        Optional<Integer> optionalActualMinAcademicYear = academicYearVisitor.getMinAcademicYear();
        int actualMinAcademicYear;
        if (optionalActualMinAcademicYear.isPresent()) {
            actualMinAcademicYear = optionalActualMinAcademicYear.get();
        } else {
            actualMinAcademicYear = 0;
        }

        assertEquals(expectedListDFSPreOrder, actualAcademicYearsList);
        assertEquals(expectedMaxAcademicYear, actualMaxAcademicYear);
        assertEquals(expectedMinAcademicYear, actualMinAcademicYear);
    }

    private void createBinarySearchTreeTest(List<StudentImpl> studentsList) {
        studentsList.forEach(nodesValue -> binarySearchTree.add(nodesValue));
    }

    private List<StudentImpl> createStudentList() {
        return Arrays.asList(
                new StudentImpl("aaaaaaaa", 8, 8),
                new StudentImpl("aaa", 3, 3),
                new StudentImpl("a", 1, 1),
                new StudentImpl("aaaaaa", 6, 6),
                new StudentImpl("aaaa", 4, 4),
                new StudentImpl("aaaaaaa", 7, 7),
                new StudentImpl("aaaaaaaaaa", 10, 10),
                new StudentImpl("aaaaaaaaaaaaaa", 14, 14),
                new StudentImpl("aaaaaaaaaaaaa", 13, 13)
        );
    }
}