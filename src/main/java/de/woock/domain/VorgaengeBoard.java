package de.woock.domain;

import org.springframework.stereotype.Service;

import de.woock.domain.ereignisse.AnfrageGestellt;
import de.woock.infra.message.Ausgang;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VorgaengeBoard {
	
	private Ausgang ausgang;

	public void neueAntwortAnheften(AnfrageGestellt anfrage) {
		ausgang.neueAntwort(anfrage);
	}
}
