package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller

public class HelloController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        @GetMapping("customer")
        public String sayHello(Model model) {


        Customer customer = new Customer();
        customer.setId(1231);
        customer.setFirstName("Johny");
        customer.setLastName("Miro");


        model.addAttribute("customer", customer);


        getServletContext().getRequestDispatcher("customer.html").forward(req);


        return "index";
    }
}
}
