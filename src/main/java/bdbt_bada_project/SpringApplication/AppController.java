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
        registry.addViewController("/main_staz").setViewName("staz/main_staz");
        registry.addViewController("/main_pracownik").setViewName("pracownik/main_pracownik");
        //registry.addViewController("/pracownicy").setViewName("admin/pracownicy");
    }

    @Controller
    public class DashboardController
    {

        //Pracownicy

        @Autowired
        private PracownicyDAO daoP;

        @RequestMapping("/main_admin/pracownicy")
        public String viewHomePage(Model model) {
            List<Pracownicy> listPracownicy = daoP.listPracownicy();
            model.addAttribute("listPracownicy", listPracownicy);

            return "admin/pracownicy";
        }

        @RequestMapping("/main_admin/new_form_pracownik")
        public String showNewForm(Model model) {
            Pracownicy pracownik = new Pracownicy();
            model.addAttribute("pracownik", pracownik);
            pracownik.setNr_sekretariatu(1);

            return "admin/new_form_pracownik";
        }

        @RequestMapping(value = "/main_admin/save", method = RequestMethod.POST)
        public String save(@ModelAttribute("pracownik") Pracownicy pracownicy){
            daoP.savePracownicy(pracownicy);

            return "redirect:/main_admin/pracownicy";
        }

        @RequestMapping("/main_admin/edit/{Nr_pracownika}")
        public ModelAndView showEditForm(@PathVariable(name = "Nr_pracownika") int Nr_pracownika) {
            ModelAndView mav = new ModelAndView("admin/edit_form_pracownicy");
            Pracownicy pracownicy = daoP.getPracownicy(Nr_pracownika);
            mav.addObject("pracownicy", pracownicy);

            return mav;
        }

        @RequestMapping(value = "/main_admin/update", method = RequestMethod.POST)
        public String update(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
            daoP.updatePracownicy(pracownicy);

            return "redirect:/main_admin/pracownicy";
        }

        @RequestMapping("/main_admin/delete/{Nr_pracownika}")
        public String delete(@PathVariable(name = "Nr_pracownika") int Nr_pracownika) {
            daoP.deletePracownicy(Nr_pracownika);

            return "redirect:/main_admin/pracownicy";
        }

        //Pracownik

        @RequestMapping("/main_pracownik/pracownik_pracownicy")
        public String viewHomePagePracownik(Model model) {
            List<Pracownicy> listPracownicy = daoP.listPracownicy();
            model.addAttribute("listPracownicy", listPracownicy);

            return "pracownik/pracownik_pracownicy";
        }

        //Klienci

        @Autowired
        private KlienciDAO daoK;

        @RequestMapping("/main_admin/klienci")
        public String viewHomePageKlienci(Model model) {
            List<Klienci> listKlienci = daoK.listKlienci();
            model.addAttribute("listKlienci", listKlienci);

            return "admin/klienci";
        }

        @RequestMapping("/main_admin/new_form_klient")
        public String showNewFormKlienci(Model model) {
            Klienci klient = new Klienci();
            model.addAttribute("klient", klient);
            klient.setNr_sekretariatu(1);

            return "admin/new_form_klient";
        }

        @RequestMapping(value = "/main_admin/saveKlienci", method = RequestMethod.POST)
        public String save(@ModelAttribute("klient") Klienci klienci){
            daoK.saveKlienci(klienci);

            return "redirect:/main_admin/klienci";
        }

        @RequestMapping("/main_admin/klienci_edit/{Nr_klienta}")
        public ModelAndView showEditFormKlienci(@PathVariable(name = "Nr_klienta") int Nr_klienta) {
            ModelAndView mav = new ModelAndView("admin/edit_form_klienci");
            Klienci klienci = daoK.getKlienci(Nr_klienta);
            mav.addObject("klienci", klienci);

            return mav;
        }

        @RequestMapping(value = "/main_admin/updateKlienci", method = RequestMethod.POST)
        public String update(@ModelAttribute("klienci") Klienci klienci) {
            daoK.updateKlienci(klienci);

            return "redirect:/main_admin/klienci";
        }

        @RequestMapping("/main_admin/klienci_delete/{Nr_klienta}")
        public String delete(@PathVariable(name = "Nr_klienta") int Nr_klienta, @ModelAttribute("klient") Klienci klienci) {
            daoK.deleteKlienci(Nr_klienta);

            return "redirect:/main_admin/klienci";
        }

        //Staz

        @RequestMapping("/main_staz/staz_klienci")
        public String viewHomePageStazKlienci(Model model) {
            List<Klienci> listKlienci = daoK.listKlienci();
            model.addAttribute("listKlienci", listKlienci);

            return "staz/staz_klienci";
        }

        @RequestMapping("/main_staz/new_form_staz_klient")
        public String showNewFormStazKlienci(Model model) {
            Klienci klient = new Klienci();
            model.addAttribute("klient", klient);
            klient.setNr_sekretariatu(1);

            return "staz/new_form_staz_klient";
        }

        @RequestMapping(value = "/main_staz/saveStazKlienci", method = RequestMethod.POST)
        public String saveS(@ModelAttribute("klient") Klienci klienci){
            daoK.saveKlienci(klienci);

            return "redirect:/main_staz/staz_klienci";
        }

        //Pracownik

        @RequestMapping("/main_pracownik/pracownik_klienci")
        public String viewHomePagePracownikKlienci(Model model) {
            List<Klienci> listKlienci = daoK.listKlienci();
            model.addAttribute("listKlienci", listKlienci);

            return "pracownik/pracownik_klienci";
        }

        @RequestMapping("/main_pracownik/new_form_pracownik_klient")
        public String showNewFormPracownikKlienci(Model model) {
            Klienci klient = new Klienci();
            model.addAttribute("klient", klient);
            klient.setNr_sekretariatu(1);

            return "pracownik/new_form_pracownik_klient";
        }

        @RequestMapping(value = "/main_pracownik/savePracownikKlienci", method = RequestMethod.POST)
        public String saveP(@ModelAttribute("klient") Klienci klienci){
            daoK.saveKlienci(klienci);

            return "redirect:/main_pracownik/pracownik_klienci";
        }

        @RequestMapping("/main_pracownik/pracownik_klienci_edit/{Nr_klienta}")
        public ModelAndView showEditFormPracownikKlienci(@PathVariable(name = "Nr_klienta") int Nr_klienta) {
            ModelAndView mav = new ModelAndView("pracownik/edit_form_pracownik_klienci");
            Klienci klienci = daoK.getKlienci(Nr_klienta);
            mav.addObject("klienci", klienci);

            return mav;
        }

        @RequestMapping(value = "/main_pracownik/updatePracownikKlienci", method = RequestMethod.POST)
        public String updateP(@ModelAttribute("klienci") Klienci klienci) {
            daoK.updateKlienci(klienci);

            return "redirect:/main_pracownik/pracownik_klienci";
        }

        @RequestMapping("/main_pracownik/pracownik_klienci_delete/{Nr_klienta}")
        public String deleteP(@PathVariable(name = "Nr_klienta") int Nr_klienta, @ModelAttribute("klient") Klienci klienci) {
            daoK.deleteKlienci(Nr_klienta);

            return "redirect:/main_pracownik/pracownik_klienci";
        }

        //Uslugi

        @Autowired
        private UslugiDAO daoU;

        @RequestMapping("/main_admin/uslugi")
        public String viewHomePageUslugi(Model model) {
            /* Import java.util.List 8 */
            List<Uslugi> listUslugi = daoU.listUslugi();
            model.addAttribute("listUslugi", listUslugi);

            return "admin/uslugi";
        }

        @RequestMapping("/main_admin/new_form_uslugi")
        public String showNewFormUslugi(Model model) {
            Uslugi usluga = new Uslugi();
            model.addAttribute("usluga", usluga);
            usluga.setNr_sekretariatu(1);

            return "admin/new_form_uslugi";
        }

        @RequestMapping(value = "/main_admin/saveUslugi", method = RequestMethod.POST)
        public String save(@ModelAttribute("usluga") Uslugi uslugi){
            daoU.saveUslugi(uslugi);

            return "redirect:/main_admin/uslugi";
        }

        @RequestMapping("/main_admin/uslugi_edit/{Nr_uslugi}")
        public ModelAndView showEditFormUslugi(@PathVariable(name = "Nr_uslugi") int Nr_uslugi) {
            ModelAndView mav = new ModelAndView("admin/edit_form_uslugi");
            Uslugi uslugi = daoU.getUslugi(Nr_uslugi);
            mav.addObject("uslugi", uslugi);

            return mav;
        }


        @RequestMapping(value = "/main_admin/updateUslugi", method = RequestMethod.POST)
        public String update(@ModelAttribute("uslugi") Uslugi uslugi) {
            daoU.updateUslugi(uslugi);

            return "redirect:/main_admin/uslugi";
        }

        @RequestMapping("/main_admin/uslugi_delete/{Nr_uslugi}")
        public String delete(@PathVariable(name = "Nr_uslugi") int Nr_uslugi, @ModelAttribute("klient") Uslugi uslugi) {
            daoU.deleteUslugi(Nr_uslugi);

            return "redirect:/main_admin/uslugi";
        }

        @RequestMapping("/main_user/new_form_usluga_inne")
        public String showNewFormUslugiInne(Model model) {
            Uslugi usluga = new Uslugi();
            model.addAttribute("usluga", usluga);
            usluga.setRodzaj_uslugi("Inne");

            return "user/new_form_usluga_inne";
        }

        @RequestMapping("/main_user/new_form_usluga_doradztwo")
        public String showNewFormUslugiDoradztwo(Model model) {
            Uslugi usluga = new Uslugi();
            model.addAttribute("usluga", usluga);
            usluga.setRodzaj_uslugi("Doradztwo");

            return "user/new_form_usluga_doradztwo";
        }

        @RequestMapping("/main_user/new_form_usluga_konsultacje")
        public String showNewFormUslugiKonsultacje(Model model) {
            Uslugi usluga = new Uslugi();
            model.addAttribute("usluga", usluga);
            usluga.setRodzaj_uslugi("Konsultacje");

            return "user/new_form_usluga_konsultacje";
        }

        @RequestMapping("/main_user/new_form_usluga_finanse")
        public String showNewFormUslugiFinanse(Model model) {
            Uslugi usluga = new Uslugi();
            model.addAttribute("usluga", usluga);
            usluga.setRodzaj_uslugi("Finanse");

            return "user/new_form_usluga_finanse";
        }

        @RequestMapping(value = "/main_user/saveUslugiUser", method = RequestMethod.POST)
        public String saveU(@ModelAttribute("usluga") Uslugi uslugi){
            daoU.saveUslugi(uslugi);

            return "redirect:/main_user";
        }

        //Staz

        @RequestMapping("/main_staz/staz_uslugi")
        public String viewHomePageStazUslugi(Model model) {
            List<Uslugi> listUslugi = daoU.listUslugi();
            model.addAttribute("listUslugi", listUslugi);

            return "staz/uslugi";
        }

        @RequestMapping("/main_staz/new_form_staz_uslugi")
        public String showNewFormStazUslugi(Model model) {
            Uslugi usluga = new Uslugi();
            model.addAttribute("usluga", usluga);
            usluga.setNr_sekretariatu(1);

            return "staz/new_form_staz_uslugi";
        }

        @RequestMapping(value = "/main_staz/saveStazUslugi", method = RequestMethod.POST)
        public String saveS(@ModelAttribute("usluga") Uslugi uslugi){
            daoU.saveUslugi(uslugi);

            return "redirect:/main_staz/staz_uslugi";
        }

        //Pracownik

        @RequestMapping("/main_pracownik/pracownik_uslugi")
        public String viewHomePagePracownikUslugi(Model model) {
            List<Uslugi> listUslugi = daoU.listUslugi();
            model.addAttribute("listUslugi", listUslugi);

            return "pracownik/pracownik_uslugi";
        }

        @RequestMapping("/main_pracownik/new_form_pracownik_uslugi")
        public String showNewFormPracownikUslugi(Model model) {
            Uslugi usluga = new Uslugi();
            model.addAttribute("usluga", usluga);
            usluga.setNr_sekretariatu(1);

            return "pracownik/new_form_pracownik_uslugi";
        }

        @RequestMapping(value = "/main_pracownik/savePracownikUslugi", method = RequestMethod.POST)
        public String saveP(@ModelAttribute("usluga") Uslugi uslugi){
            daoU.saveUslugi(uslugi);

            return "redirect:/main_pracownik/pracownik_uslugi";
        }

        @RequestMapping("/main_pracownik/pracownik_uslugi_edit/{Nr_uslugi}")
        public ModelAndView showEditFormPracownikUslugi(@PathVariable(name = "Nr_uslugi") int Nr_uslugi) {
            ModelAndView mav = new ModelAndView("pracownik/edit_form_pracownik_uslugi");
            Uslugi uslugi = daoU.getUslugi(Nr_uslugi);
            mav.addObject("uslugi", uslugi);

            return mav;
        }


        @RequestMapping(value = "/main_pracownik/updatePracownikUslugi", method = RequestMethod.POST)
        public String updateP(@ModelAttribute("uslugi") Uslugi uslugi) {
            daoU.updateUslugi(uslugi);

            return "redirect:/pracownik_uslugi";
        }

        @RequestMapping("/main_pracownik/pracownik_uslugi_delete/{Nr_uslugi}")
        public String deleteP(@PathVariable(name = "Nr_uslugi") int Nr_uslugi, @ModelAttribute("usluga") Uslugi uslugi) {
            daoU.deleteUslugi(Nr_uslugi);

            return "redirect:/pracownik_uslugi";
        }


        //Adresy

        @Autowired
        private AdresyDAO daoA;

        @RequestMapping("/main_admin/adresy")
        public String viewHomePageAdresy(Model model) {
            /* Import java.util.List 8 */
            List<Adresy> listAdresy = daoA.listAdresy();
            model.addAttribute("listAdresy", listAdresy);

            return "admin/adresy";
        }

        @RequestMapping("/main_admin/new_form_adresy")
        public String showNewFormAdresy(Model model) {
            Adresy adres = new Adresy();
            model.addAttribute("adres", adres);

            return "admin/new_form_adresy";
        }

        @RequestMapping(value = "/main_admin/saveAdresy", method = RequestMethod.POST)
        public String save(@ModelAttribute("adres") Adresy adresy){
            daoA.saveAdresy(adresy);

            return "redirect:/adresy";
        }

        @RequestMapping("/main_admin/adresy_edit/{Nr_adresu}")
        public ModelAndView showEditFormAdresy(@PathVariable(name = "Nr_adresu") int Nr_adresu) {
            ModelAndView mav = new ModelAndView("admin/edit_form_adresy");
            Adresy adresy = daoA.getAdresy(Nr_adresu);
            mav.addObject("adresy", adresy);

            return mav;
        }

        @RequestMapping(value = "/main_admin/updateAdresy", method = RequestMethod.POST)
        public String update(@ModelAttribute("adresy") Adresy adresy) {
            daoA.updateAdresy(adresy);

            return "redirect:/main_admin/adresy";
        }

        @RequestMapping("/main_admin/adresy_delete/{Nr_adresu}")
        public String delete(@PathVariable(name = "Nr_adresu") int Nr_adresu, @ModelAttribute("adres") Adresy adresy) {
            daoA.deleteAdresy(Nr_adresu);

            return "redirect:/main_admin/adresy";
        }

        //Staz

        @RequestMapping("/main_staz/staz_adresy")
        public String viewHomePageStazAdresy(Model model) {
            List<Adresy> listAdresy = daoA.listAdresy();
            model.addAttribute("listAdresy", listAdresy);

            return "staz/staz_adresy";
        }

        @RequestMapping("/main_staz/new_form_staz_adresy")
        public String showNewFormStazAdresy(Model model) {
            Adresy adres = new Adresy();
            model.addAttribute("adres", adres);

            return "staz/new_form_staz_adresy";
        }

        @RequestMapping(value = "/main_staz/saveStazAdresy", method = RequestMethod.POST)
        public String saveS(@ModelAttribute("adres") Adresy adresy){
            daoA.saveAdresy(adresy);

            return "redirect:/main_staz/staz_adresy";
        }

        //Pracownik

        @RequestMapping("/main_pracownik/pracownik_adresy")
        public String viewHomePagePracownikAdresy(Model model) {
            List<Adresy> listAdresy = daoA.listAdresy();
            model.addAttribute("listAdresy", listAdresy);

            return "pracownik/pracownik_adresy";
        }

        @RequestMapping("/main_pracownik/new_form_pracownik_adresy")
        public String showNewFormPracownikAdresy(Model model) {
            Adresy adres = new Adresy();
            model.addAttribute("adres", adres);

            return "pracownik/new_form_pracownik_adresy";
        }

        @RequestMapping(value = "/main_pracownik/savePracownikAdresy", method = RequestMethod.POST)
        public String saveP(@ModelAttribute("adres") Adresy adresy){
            daoA.saveAdresy(adresy);

            return "redirect:/main_pracownik/pracownik_adresy";
        }

        @RequestMapping("/main_pracownik/pracownik_adresy_edit/{Nr_adresu}")
        public ModelAndView showEditFormPracownikAdresy(@PathVariable(name = "Nr_adresu") int Nr_adresu) {
            ModelAndView mav = new ModelAndView("pracownik/edit_form_pracownik_adresy");
            Adresy adresy = daoA.getAdresy(Nr_adresu);
            mav.addObject("adresy", adresy);

            return mav;
        }

        @RequestMapping(value = "/main_pracownik/updatePracownikAdresy", method = RequestMethod.POST)
        public String updateP(@ModelAttribute("adresy") Adresy adresy) {
            daoA.updateAdresy(adresy);

            return "redirect:/main_pracownik/pracownik_adresy";
        }

        @RequestMapping("/main_pracownik/pracownik_adresy_delete/{Nr_adresu}")
        public String deleteP(@PathVariable(name = "Nr_adresu") int Nr_adresu, @ModelAttribute("adres") Adresy adresy) {
            daoA.deleteAdresy(Nr_adresu);

            return "redirect:/main_pracownik/pracownik_adresy";
        }

        //Wynagrodzenia

        @Autowired
        private WynagrodzeniaDAO daoW;

        @RequestMapping("/main_admin/wynagrodzenia")
        public String viewHomePageW(Model model) {
            /* Import java.util.List 8 */
            List<Wynagrodzenia> listWynagrodzenia = daoW.listWynagrodzenia();
            model.addAttribute("listWynagrodzenia", listWynagrodzenia);

            return "admin/wynagrodzenia";
        }

        @RequestMapping("/main_admin/new_form_wynagrodzenia")
        public String showNewFormW(Model model) {
            Wynagrodzenia wynagrodzenie = new Wynagrodzenia();
            model.addAttribute("wynagrodzenie", wynagrodzenie);

            return "admin/new_form_wynagrodzenia";
        }

        @RequestMapping(value = "/main_admin/saveWynagrodzenia", method = RequestMethod.POST)
        public String save(@ModelAttribute("wynagrodzenie") Wynagrodzenia wynagrodzenia){
            daoW.saveWynagrodzenia(wynagrodzenia);

            return "redirect:/main_admin/wynagrodzenia";
        }

        @RequestMapping("/main_admin/wynagrodzenia_edit/{Nr_wynagrodzenia}")
        public ModelAndView showEditFormW(@PathVariable(name = "Nr_wynagrodzenia") int Nr_wynagrodzenia) {
            ModelAndView mav = new ModelAndView("admin/edit_form_wynagrodzenia");
            Wynagrodzenia wynagrodzenia = daoW.getWynagrodzenia(Nr_wynagrodzenia);
            mav.addObject("wynagrodzenia", wynagrodzenia);

            return mav;
        }

        @RequestMapping(value = "/main_admin/updateWynagrodzenia", method = RequestMethod.POST)
        public String update(@ModelAttribute("wynagrodzenia") Wynagrodzenia wynagrodzenia) {
            daoW.updateWynagrodzenia(wynagrodzenia);

            return "redirect:/main_admin/wynagrodzenia";
        }

        @RequestMapping("/main_admin/wynagrodzenia_delete/{Nr_wynagrodzenia}")
        public String delete(@PathVariable(name = "Nr_wynagrodzenia") int Nr_wynagrodzenia, @ModelAttribute("wynagrodzenie") Wynagrodzenia wynagrodzenia) {
            daoW.deleteWynagrodzenia(Nr_wynagrodzenia);

            return "redirect:/main_admin/wynagrodzenia";
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
            else if
            (request.isUserInRole
                            ("STAŻYSTA")) {
                return "redirect:/main_staz";
            }
            else if
            (request.isUserInRole
                            ("PRACOWNIK")) {
                return "redirect:/main_pracownik";
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
    @RequestMapping(value={"/main_staz"})
    public String showStazPage(Model model) {
        return "staz/main_staz";
    }
    @RequestMapping(value={"/main_pracownik"})
    public String showPracownikPage(Model model) {
        return "pracownik/main_pracownik";
    }
}