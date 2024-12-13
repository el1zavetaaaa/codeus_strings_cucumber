package org.example.service;

import org.example.entity.Present;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PresentService {
    private Set<Present> giftList = new HashSet<>();

    public String addPresent(Present present) {
        if (giftList.contains(present)) {
            return "Present already exists";
        }
        giftList.add(present);
        return "Present added successfully";
    }

    public String removePresent(final String name) {
        List<Present> presents = giftList.stream()
                .filter(present -> present.getName().equals(name))
                .toList();
        if (!presents.isEmpty()) {
            giftList.remove(presents.get(0));
            return "Present removed successfully";
        }
        return "Present not found";
    }

    public boolean giftExists(Present present) {
        return giftList.contains(present);
    }

    public Set<Present> getGiftList() {
        return giftList;
    }

}
