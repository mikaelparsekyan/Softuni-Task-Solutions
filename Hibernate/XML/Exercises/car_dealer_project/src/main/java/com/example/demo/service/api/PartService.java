package com.example.demo.service.api;

import com.example.demo.data.entities.Part;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("partService")
public interface PartService {
    void seedPartsToDatabase();

    Set<Part> getRandomParts(List<Part> allParts);
}
