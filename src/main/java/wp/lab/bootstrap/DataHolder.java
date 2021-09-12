package wp.lab.bootstrap;

import wp.lab.model.Course;
import wp.lab.model.Student;
import org.springframework.stereotype.Component;
import wp.lab.model.Teacher;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nilufer
 * @project lab
 */

@Component
public class DataHolder {

    public static List<Course> courseList = new ArrayList<>();
    public static List<Student> allStudentList = new ArrayList<>();
    public static  List<Teacher> teacherList = new ArrayList<>();

    private static List<Student> fewStudentList = new ArrayList<>();

    private static Student dilara = new Student("dilara.bashgul","db","Dilara","Bashgul");
    private static Student bajram = new Student("bajram.bashgul","bb","Bajram","Bashgul");
    private static Student alican = new Student("alican.ali","al","Alican","Ali");
    private static Student ela = new Student("ela.lilla","el","Elanur","Lilla");
    private static Student nilufer = new Student("nilufer.bashgul","nb","Nilufer","Bashgul");


    @PostConstruct
    public void init() {
        allStudentList.add(nilufer);
        allStudentList.add(ela);
        allStudentList.add(alican);
        allStudentList.add(bajram);
        allStudentList.add(dilara);

        fewStudentList.add(ela);
        fewStudentList.add(alican);


        courseList.add(new Course(1l, "OS", "Operativni Sistemi", allStudentList));
        courseList.add(new Course(2l, "WP", "Web programiranje", fewStudentList));
        courseList.add(new Course(3l, "APS", "Algoritmi i podatocni strukturi", allStudentList));
        courseList.add(new Course(4l, "SP", "Strukturno Programiranje", allStudentList));
        courseList.add(new Course(5l, "OP", "Objektno Programiranje", allStudentList));

        teacherList.add(new Teacher(1l, "teacher1", "surname1"));
        teacherList.add(new Teacher(2l, "teacher2", "surname2"));
        teacherList.add(new Teacher(3l, "teacher3", "surname3"));
        teacherList.add(new Teacher(4l, "teacher4", "surname4"));
        teacherList.add(new Teacher(5l, "teacher5", "surname5"));

    }

    }

