package de.woock.infra.message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import de.woock.domain.ereignisse.AnfrageGestellt;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class Eingang {
	@JmsListener(destination = "Fuhrpark", containerFactory = "myFactory", subscription = "stattauto")
	public void antwortVerarbeiten(AnfrageGestellt anfrage) {
		log.debug("Anfrage eingegangen: {}", anfrage.getFrage());
		anfrage.bearbeiten(anfrage);
	}	
}