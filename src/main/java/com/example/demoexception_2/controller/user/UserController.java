package com.example.demoexception_2.controller.user;


import com.example.demoexception_2.dto.request.command.user.RegisterCommandRequestData;
import com.example.demoexception_2.dto.request.query.user.GetUserQueryRequestData;
import com.example.demoexception_2.dto.request.query.user.LoginQueryRequestData;
import com.example.demoexception_2.dto.response.command.user.RegisterCommandResponseData;
import com.example.demoexception_2.dto.response.query.user.GetUserQueryResponseData;
import com.example.demoexception_2.dto.response.query.user.LoginQueryResponseData;
import com.example.demoexception_2.handle.query.user.HandleManagement;
import com.example.demoexception_2.handle.command.user.RegisterHandleKeycloak;
import com.example.demoexception_2.handle.query.user.LoginHandleKeycloak;
import com.example.demoexception_2.handle.query.user.UserInforHandleKeycloak;
import com.example.demoexception_2.model.user.AddUserDTO;
import com.example.demoexception_2.model.user.Customer;
import com.example.demoexception_2.model.user.UserDTO;
import com.example.demoexception_2.service.query.user.service.UserInforService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class UserController extends BaseController {

    private final HandleManagement handleManagement;
    private final UserInforService userInforService;

    @GetMapping("/")
    public String index() {
        return "external";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }


    @GetMapping(path = "login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<LoginQueryResponseData> login1(String username, String password) {
        return excute(new LoginQueryRequestData(username, password));
    }

    @GetMapping("/users")
    //@PreAuthorize("hasRole('user')")
    public String getUserInfor(Model model) {
        String userId = userInforService.getUserId();
        GetUserQueryRequestData userRequest = new GetUserQueryRequestData(userId);
        UserInforHandleKeycloak handler = (UserInforHandleKeycloak) handleManagement.getHandleUser(userRequest);
        GetUserQueryResponseData getUserQueryResponseData = handler.handle(userRequest);
        AddUserDTO addUserDTO = getUserQueryResponseData.getAddUserDTO();
        System.out.println(addUserDTO);
        model.addAttribute("user", addUserDTO);
        return "userInfo";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterCommandResponseData> register1(UserDTO userDTO) {
        return excute(new RegisterCommandRequestData(userDTO));
    }

    @GetMapping(path = "/customers")
    //@PreAuthorize("hasRole('user')")
    public String customers(Principal principal, Model model) {

        Iterable<Customer> customers = addCustomers();
        ;
        model.addAttribute("customers", customers);
        model.addAttribute("username", principal.getName());
        return "customers";
    }

    // add customers for demonstration
    public ArrayList<Customer> addCustomers() {
        ArrayList<Customer> list = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setAddress("1111 foo blvd");
        customer1.setName("Foo Industries");
        customer1.setServiceRendered("Important services");
        list.add(customer1);

        Customer customer2 = new Customer();
        customer2.setAddress("2222 bar street");
        customer2.setName("Bar LLP");
        customer2.setServiceRendered("Important services");
        list.add(customer2);
        Customer customer3 = new Customer();
        customer3.setAddress("33 main street");
        customer3.setName("Big LLC");
        customer3.setServiceRendered("Important services");
        list.add(customer3);
        return list;
    }

}
