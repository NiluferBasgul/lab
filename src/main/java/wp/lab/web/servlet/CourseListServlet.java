package wp.lab.web.servlet;

import wp.lab.model.Course;
import wp.lab.service.CourseService;

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
@WebServlet(name="course_servlet",urlPatterns = "/listCourses")
public class CourseListServlet extends HttpServlet {

    private final CourseService courseService;

    public CourseListServlet(CourseService courseService) {
        this.courseService = courseService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courseList = courseService.listAll();
        String ipAddress = req.getRemoteAddr();
        String clientAgent = req.getHeader("User-Agent");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h2>Info about our request</h2>");
        writer.format("IP Address:%s, Browser: %s",ipAddress,clientAgent);
        writer.println("<h2>Courses</h2>");
        writer.println("<ul>");
        courseList.forEach(r->
                writer.format("<li>%s (%s)</li>",r.getName(),r.getDescription()));
        writer.println("</ul>");

        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h3>Courses List</h3>");
        writer.println("<h2>Choose Course</h2>");
        writer.println("<form method='post' action='/listCourses'>" +
                "<input type=\"radio\" name=\"courseId\" value=\"1\"> Веб програмирање<br/>\n" +
                "<input type=\"radio\" name=\"courseId\" value=\"2\"> Оперативни системи<br/>\n" +
                "<input type=\"radio\" name=\"courseId\" value=\"3\"> Електронска и мобилна трговија<br/>\n" +
                "<input type=\"radio\" name=\"courseId\" value=\"4\"> Компјутерски мрежи<br/>\n"+

                "<a href=\"/АddStudent\">Submit</a>\n"+
                "</form>");
        writer.println("</body>");
        writer.println("<html>");

        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseName = (String)req.getParameter("name");
        String courseDesc = (String) req.getParameter("description");
//        courseService.create(categoryName,categoryDesc);
        resp.sendRedirect("/listCourses");
    }


}
