package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; //new
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUser(ModelMap modelMap) {
        List<User> list = userService.getAllUsers();
        modelMap.addAttribute("list", list);
        return "userList";
    }

    @GetMapping(value = "/new")
    public String addUserForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping("/new") // ("/new" - попробовать сделать пустым) сохраняем нового "юзера" и возвращаемся на страницу /user/
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/user/";
    }

    @GetMapping(value = "/edit/{id}")  //открывается окно с юзером для изменений В
    public String editUser(@PathVariable("id") int id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "/edit/{id}") //--> нажимаем "сохранить изменения" --> пересылает на страницу /new/edit/{2}
    public String update(@ModelAttribute("user") User user,
                             @PathVariable("id") int id) {
        userService.updateUser(user, id);
        return "redirect:/user";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }

}
