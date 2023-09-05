package de.woock.infra.message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import de.woock.domain.ereignisse.AnfrageGestellt;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class Eingang {
	@JmsListener(destination = "Fuhrpark", containerFactory = "myFactory", subscription = "stattauto")
	@SendTo("status")
	public Message<String> antwortVerarbeiten(AnfrageGestellt anfrageGestellt) {
		String frage = anfrageGestellt.getFrage();
		log.debug("Anfrage eingegangen: {}", frage);
		anfrageGestellt.bearbeiten(anfrageGestellt);
		return MessageBuilder.withPayload("PROCESSED")
				             .setHeader("frage", frage)
				             .setHeader("status", "in Bearbeitung")
				             .build();
	}	
}