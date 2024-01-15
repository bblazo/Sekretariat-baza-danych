package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        //registry.addViewController("/pracownicy").setViewName("admin/pracownicy");
    }
    @Controller
    public class DashboardController
    {
        @Autowired
        private PracownicyDAO dao;

        @RequestMapping("/pracownicy")
        public String viewHomePage(Model model) {
            /* Import java.util.List 8 */
            List<Pracownicy> listPracownicy = dao.list();
            model.addAttribute("listPracownicy", listPracownicy);
            return "admin/pracownicy";
        }
        @RequestMapping("/new_form_pracownik")
        public String showNewForm(Model model) {
            /* Import java.util.List 8 */
            Pracownicy pracownik = new Pracownicy();
            model.addAttribute("pracownik", pracownik);
            return "admin/new_form_pracownik";
        }
        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String save(@ModelAttribute("pracownik") Pracownicy pracownicy){
            dao.save(pracownicy);
            return "redirect:/";
        }

        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            }
            else
            {
                return "redirect:/index";
            }
        }
    }
    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
}