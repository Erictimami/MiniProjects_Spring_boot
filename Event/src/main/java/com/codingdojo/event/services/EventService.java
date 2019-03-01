package com.codingdojo.event.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.event.models.Event;
import com.codingdojo.event.repositories.EventRepository;



@Service
public class EventService {
	private final EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	//return all the events
	public List<Event> allEvents(){
		return eventRepository.findAll();
	}
	//creates a event
	public Event createEvent(Event e) {
		return eventRepository.save(e);
	}
	//find by subject
	public List<Event> findByState(String state){
		return eventRepository.findByState(state);
	}
	//retrieve a Event
	public Event findEvent(Long id) {
		Optional<Event> optionalEvent = eventRepository.findById(id);
		if(optionalEvent.isPresent()) {
			return optionalEvent.get();
		} else {
			return null;
		}
	}
	//delete a Event
	public void deleteEvent(Long id) {
		Event event = findEvent(id);
		eventRepository.delete(event);
	}
	//update a Event
	public Event updateEvent(Long id, String name, Date date, String location, String state) {
		Event event = findEvent(id);
		event.setName(name);
		event.setDate(date);
		event.setLocation(location);
		event.setState(state);
		eventRepository.save(event);
		return event;
	}
}