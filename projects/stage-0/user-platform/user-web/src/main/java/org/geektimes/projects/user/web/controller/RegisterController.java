package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;
import org.geektimes.web.mvc.controller.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/register")
public class RegisterController implements PageController {

    private UserService userService = new UserServiceImpl();

    @GET
    @POST
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        System.out.println(" joooj register !");
        String loginname = request.getParameter("loginname");
        String password = request.getParameter("password");
        System.out.println(" loginname : " + loginname + " password : " + password);
        User user = new User();
        user.setName(loginname);
        user.setPassword(password);
        if (userService.register(user)) {
            return "success.jsp";
        }
        return "error.jsp";
    }
}
