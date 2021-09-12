package wp.lab.web.servlet;

import wp.lab.service.CourseService;
import wp.lab.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author nilufer
 * @project lab
 */

@WebServlet(name = "listStudent_servlet", urlPatterns = "/AddStudent")
public class CreateStudentServlet extends HttpServlet {

    private final StudentService studentService;
    private final CourseService courseService;

    public CreateStudentServlet(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String students = String.valueOf(studentService.listAll());
        Long courses =  null;
        courseService.addStudentInCourse(students,courses);
        String ipAddress = request.getRemoteAddr();
        String clientAgent = request.getHeader("User-Agent");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h2>Info about our request</h2>");
        writer.format("IP Address:%s, Browser: %s", ipAddress, clientAgent);
        writer.println("<h2>Students</h2>");
        writer.println("<ul>");
        writer.println("</ul>");

        writer.println("<html>");
        writer.println("WP lab - Students in Course");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Students in Course </h1>");
        writer.println("<section>\n" +
                "<div>Веб програмирање</div>\n" +
                "<ul>\n" +
                "<li>Петар Петров (petar.petrov)</li>\n" +
                "<li>Јован Јованов (jovan.jovanov)</li>\n" +
                "</ul>\n" +
                "<a href=\"/listCourses\">Back</a>\n" +
                "</section>");
        writer.println("</body>");
        writer.println("<html>");

        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/StudentEnrollmentSummary");
    }
}

