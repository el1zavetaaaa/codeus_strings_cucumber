package org.example.thursday.maintask.service;

import lombok.Getter;
import lombok.SneakyThrows;
import org.example.thursday.maintask.entity.Present;
import org.example.thursday.maintask.exceptions.PresentAlreadyExistsException;
import org.example.thursday.maintask.exceptions.PresentNotFoundException;

import java.util.HashSet;
import java.util.Set;

@Getter
public class PresentService {
    private final Set<Present> giftList = new HashSet<>();

    @SneakyThrows
    public void addPresent(Present present) {
        if (present == null || present.getName() == null || present.getName().isBlank()) {
            throw new IllegalArgumentException("Present or present name cannot be null/empty.");
        }
        if (giftList.contains(present)) {
            throw new PresentAlreadyExistsException(String.format("Present with name %s already exists", present.getName()));
        }
        giftList.add(present);
    }

    public void removePresent(final String name) {
        Present present = getPresent(name);
        giftList.remove(present);
    }

    @SneakyThrows
    public Present getPresent(final String name) {
        return giftList.stream()
                .filter(present -> present.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new PresentNotFoundException(String.format("Present with the name %s is not found.", name)));
    }

}