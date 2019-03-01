package com.codingdojo.event.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.event.models.Message;
import com.codingdojo.event.repositories.MessageRepository;


@Service
public class MessageService {

	private final MessageRepository messageRepository;

	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	//return all the messages
	public List<Message> allMessages(){
		return messageRepository.findAll();
	}
	//creates a message
	public Message createMessage(Message m) {
		return messageRepository.save(m);
	}
	//retrieve a Message
	public Message findMessage(Long id) {
		Optional<Message> optionalMessage = messageRepository.findById(id);
		if(optionalMessage.isPresent()) {
			return optionalMessage.get();
		} else {
			return null;
		}
	}
	//delete a Message
	public void deleteMessage(Long id) {
		Message message = findMessage(id);
		messageRepository.delete(message);
	}
//	//update a Message
//	public Message updateMessage(Long id, String message) {
//		Message message = findMessage(id);
//		message.setMessage(message);
//		messageRepository.save(message);
//		return message;
//	}
}