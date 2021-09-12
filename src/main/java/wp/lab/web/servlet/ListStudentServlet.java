//package wp.lab.web.servlet;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import wp.lab.model.Student;
//import wp.lab.service.StudentService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
///**
// * @author nilufer
// * @project lab
// */
//@ConditionalOnMissingBean
//@WebServlet(name="listStudent_servlet",urlPatterns = "/AddStudent")
//
//public class ListStudentServlet  extends HttpServlet {
//    private final StudentService studentService;
//
//    public ListStudentServlet(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        List<Student> students = studentService.listAll();
//        String ipAddress = request.getRemoteAddr();
//        String clientAgent = request.getHeader("User-Agent");
//        response.setContentType("text/html;charset=UTF-8");
////        request.getSession().setAttribute("students", students);
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<head>");
//        writer.println("</head>");
//        writer.println("<body>");
//        writer.println("<h2>Info about our request</h2>");
//        writer.format("IP Address:%s, Browser: %s",ipAddress,clientAgent);
//        writer.println("<h2>Students</h2>");
//        writer.println("<ul>");
//        students.forEach(r->
//                writer.format("<li>%s (%s)</li>",r.getName(),r.getSurname(),r.getUsername(),r.getPassword()));
//        writer.println("</ul>");
//
//        writer.println("<html>");
//        writer.println("<head>");
//        writer.println("</head>");
//        writer.println("<body>");
//        writer.println("<h1>Student Enrollment - Select the Student</h1>");
//        writer.println("<h2>Select the student to enroll:</h2>");
//        writer.println("<form method='post' action='/AddStudent '>" +
//                "<a href='/createStudent' type='button'>Create New Student</a> <br/> <br/>\n" +
//                "<input type=\"radio\" name=\"size\" value=\"petar.petrov\"> Петар Петров <br/>\n" +
//                "<input type=\"radio\" name=\"size\" value=\"mile.milev\"> Миле Милев <br/>\n" +
//                "<input type=\"radio\" name=\"size\" value=\"gjorgji.gjorgjiev\"> Ѓорѓи Ѓорѓиев <br/>\n" +
//                "<br/>"+
//
//                "<a href=\"/StudentEnrollmentSummary\">Submit</a>\n"+
//                "</form>");
//        writer.println("<tr>\n" +
//                "<th colspan=\"2\">\n" +
//                "Your Enrollment Status\n" +
//                " </th>\n" +
//                " </tr>");
//        writer.println(" <tr>\n" +
//                "<td><b>Course Id</b></td>\n" +
//                "<td>2</td>\n" +
//                "</tr>");
//        writer.println("</body>");
//        writer.println("<html>");
//
//        writer.println("</body>");
//        writer.println("</html>");
//        writer.flush();
//    }
//
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.sendRedirect("/StudentEnrollmentSummary");
//    }
//
//}