package org.example.service;

import org.example.entity.Present;

import java.util.HashSet;
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

    public String removePresent(Present present) {
        if (giftList.contains(present)) {
            giftList.remove(present);
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
