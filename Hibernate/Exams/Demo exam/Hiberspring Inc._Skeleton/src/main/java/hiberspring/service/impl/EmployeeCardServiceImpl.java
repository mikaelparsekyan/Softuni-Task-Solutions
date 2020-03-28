package hiberspring.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hiberspring.constants.FileImportPath;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
import hiberspring.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {
    @Autowired
    private final EmployeeCardRepository cardRepository;
    @Autowired
    private final Gson gson;
    @Autowired
    private final ValidationUtil validationUtil;

    public EmployeeCardServiceImpl(EmployeeCardRepository cardRepository, Gson gson, ValidationUtil validationUtil) {
        this.cardRepository = cardRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return cardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return Files.readString(Path.of(FileImportPath.CARDS_IMPORT_PATH));
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        LinkedList<EmployeeCard> cards = gson.fromJson(new FileReader(FileImportPath.CARDS_IMPORT_PATH),
                new TypeToken<LinkedList<EmployeeCard>>() {
                }.getType());

        cards.forEach(card -> {
            if (validationUtil.isValid(card)) {
                if (cardRepository.findByNumber(card.getNumber()) == null) {
                    cardRepository.saveAndFlush(card);
                    result.append(String.format("Successfully imported Employee Card %s.",
                            card.getNumber()));
                } else {
                    result.append("Duplicate number of cards");
                }
            } else {
                result.append("Error: Invalid data.");
            }
            result.append(System.lineSeparator());
        });
        return result.toString();
    }

    @Override
    public EmployeeCard getCardByNumber(String number) {
        return cardRepository.findByNumber(number);
    }
}
