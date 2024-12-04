package mk.ukim.finki.wp.web;


import mk.ukim.finki.wp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventListServlet {

    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public String showEventList(Model model, @RequestParam(required = false) String searchText) {
        if (searchText != null) {
            model.addAttribute("events", eventService.searchEvents(searchText));
        } else {
            model.addAttribute("events", eventService.listAll());
        }
        return "listEvents";
    }


}
