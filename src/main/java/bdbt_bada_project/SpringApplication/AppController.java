package bdbt_bada_project.SpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private PracownicyDAO dao;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        /* Import java.util.List 8 */
        List<Pracownicy> listPracownicy = dao.list();
        model.addAttribute("listPracownicy", listPracownicy);
        return "index";
    }
}