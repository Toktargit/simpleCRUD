package m.code.controller;

import m.code.entity.Quote;
import m.code.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Quote> quoteList = quoteService.listAll();
        model.addAttribute("listQuote",quoteList);
        System.out.print("Get / ");
    return "index";
    }

    @GetMapping("/new")
    public String createQuote(@RequestBody Quote quote) {
         quoteService.saveQuote(quote);
         return "new";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Quote std) {
       quoteService.saveQuote(std);

        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public ModelAndView updateQuote(@PathVariable(name="id") Long id){
        ModelAndView mav =new ModelAndView("new");
        Quote quote = quoteService.get(id);
        mav.addObject("Quote", quote);
        return mav;

    }


   @RequestMapping("/delete/{id}")
    public String deleteQoute(@PathVariable(name="id") Long id){
        quoteService.DeleteById(id);
        return "redirect:/";
    }

}
