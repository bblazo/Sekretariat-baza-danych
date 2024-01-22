package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
            return "redirect:/pracownicy";
        }
        @RequestMapping("/edit/{Nr_pracownika}")
        public ModelAndView showEditForm(@PathVariable(name = "Nr_pracownika") int Nr_pracownika) {
            ModelAndView mav = new ModelAndView("admin/edit_form_pracownicy");
            Pracownicy pracownicy = dao.get(Nr_pracownika);
            mav.addObject("pracownicy", pracownicy);
            return mav;
        }

        @RequestMapping(value = "/update", method = RequestMethod.POST)
        public String update(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
            dao.update(pracownicy);
            return "redirect:/pracownicy";
        }

        @RequestMapping("/delete/{Nr_pracownika}")
        public String delete(@PathVariable(name = "Nr_pracownika") int Nr_pracownika) {
            dao.delete(Nr_pracownika);
            return "redirect:/pracownicy";
        }

        @Autowired
        private KlienciDAO daoK;

        @RequestMapping("/klienci")
        public String viewHomePageKlienci(Model model) {

            List<Klienci> listKlienci = daoK.listKlienci();
            model.addAttribute("listKlienci", listKlienci);
            return "admin/klienci";
        }
        @RequestMapping("/new_form_klient")
        public String showNewFormKlienci(Model model) {
            Klienci klient = new Klienci();
            model.addAttribute("klient", klient);
            return "admin/new_form_klient";
        }
        @RequestMapping(value = "/saveKlienci", method = RequestMethod.POST)
        public String save(@ModelAttribute("klient") Klienci klienci){
            daoK.saveKlienci(klienci);
            return "redirect:/klienci";
        }
        @RequestMapping("/klienci_edit/{Nr_klienta}")
        public ModelAndView showEditFormKlienci(@PathVariable(name = "Nr_klienta") int Nr_klienta) {
            ModelAndView mav = new ModelAndView("admin/edit_form_klienci");
            Klienci klienci = daoK.getKlienci(Nr_klienta);
            mav.addObject("klienci", klienci);
            return mav;
        }

        @RequestMapping(value = "/updateKlienci", method = RequestMethod.POST)
        public String update(@ModelAttribute("klienci") Klienci klienci) {
            daoK.updateKlienci(klienci);
            return "redirect:/klienci";
        }

        @RequestMapping("/klienci_delete/{Nr_klienta}")
        public String delete(@PathVariable(name = "Nr_klienta") int Nr_klienta, @ModelAttribute("klient") Klienci klienci) {
            daoK.deleteKlienci(Nr_klienta);
            return "redirect:/klienci";
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