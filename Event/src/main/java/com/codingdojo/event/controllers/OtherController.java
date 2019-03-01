package com.codingdojo.event.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.event.models.User;
import com.codingdojo.event.services.EventService;
import com.codingdojo.event.services.MessageService;
import com.codingdojo.event.services.UserService;

@Controller
@RequestMapping("/events")
public class OtherController {
	
	private UserService userService;
	private MessageService messageService;
	private EventService eventService;
	//constructor
	public OtherController(UserService userService, MessageService messageService, EventService eventService) {
		this.userService = userService;
		this.messageService = messageService;
		this.eventService = eventService;
	}

	//display all the events and all the tags by event
	@RequestMapping("")
	public String index(HttpSession session, Model model) {
    	if(session.getAttribute("logged") == null) {
    		return "redirect:/login";
    	}else if((session.getAttribute("logged").toString()).equals("false") == true) {
    		return "redirect:/login";
    	}
    	User user = userService.findUserById(Long.parseLong(session.getAttribute("id").toString()));
    	model.addAttribute("user", user);
//		List<Event> events = eventService.allEvents();
//		model.addAttribute("events", events);
//		System.out.println("all the events: "+events);
		return "/home/test.jsp";	
	}
	
//	//display the form for a new event
//	@RequestMapping("/3/edit")
//	public String editEvent(@ModelAttribute("eventFrom") Event eventFrom) {
//		return "/home/editEvent.jsp";
//	}

//	//process the post of the new event
//	@RequestMapping(value="/new", method=RequestMethod.POST)
//	public String createq(@RequestParam("subject") String subject, @Valid @ModelAttribute("eventFrom") Event eventFrom, BindingResult result) {
//		if(result.hasErrors()) {
//			System.out.println("Error during the post of the event: "+result);
//			return "redirect:/events/new";
//		} else {
//			System.out.println("Success of the posting new event with his tags. We are processing the save: "+eventFrom);
//			List<Tag> ListTags = tagService.findBySubject(subject);
//			List<Event> ListEvents = eventService.findByEvent(eventFrom.getEvent());
//			if(ListTags.isEmpty() && ListEvents.isEmpty()) {
//				Tag t = new Tag();//create a empty tag
//				t.setSubject(subject);//set the subject of the tag
//				Tag newTag = tagService.createTag(t); //create the new object tag with the id
//				List<Tag> newTagList = new ArrayList<Tag>(); //create an empty list
//				newTagList.add(newTag); //add the newtag to the list		
//				eventFrom.setTags(newTagList); //set the list in the event 
//				eventService.createEvent(eventFrom); // create the new events
//			} 
//			if(!ListTags.isEmpty() && ListEvents.isEmpty()) {
//				eventFrom.setTags(ListTags);
//				eventService.createEvent(eventFrom); // create the new events
//			} 
//			if(ListTags.isEmpty() && !ListEvents.isEmpty()) {
//				Tag t = new Tag();//create a empty tag
//				t.setSubject(subject);//set the subject of the tag
//				t.setEvents(ListEvents);
//				tagService.createTag(t);
//			}
//			return "redirect:/events";
//		}
//	}
	
	//process the post of the new event
	@RequestMapping(value="/events", method=RequestMethod.POST)
	public String createe(BindingResult result) {
			return "redirect:/events";
	}
	//display a event and the form for answers
	@RequestMapping("/{id}")
	public String indexp(@PathVariable("id") Long id) {
//		List<Answer> answers = answerService.allAnswers();
//		model.addAttribute("answers", answers);
//		System.out.println("Display a event: "+event);
		return "/home/oneEvent.jsp";
	}
//	//create an answer after posting 
//	@RequestMapping(value="/{id}", method=RequestMethod.POST)
//	public String createa(@Valid @ModelAttribute("answerFrom") Answer answerFrom, @PathVariable("id") Long id, BindingResult result) {
//		if(result.hasErrors()) {
//			System.out.println("Error during the post of the answer: "+result);
//			return "redirect:/events/{id}";
//		} else {
//			
//			answerService.createAnswer(answerFrom);
////			Event event = eventService.findEvent(id);
////			Answer a = answerService.createAnswer(answer);
////			List<Answer> ListAnswer = event.getAnswers();
////			ListAnswer.add(a);
////			event.setAnswers(ListAnswer);
//			return "redirect:/events/{id}";
//		}
//	}
	
}
