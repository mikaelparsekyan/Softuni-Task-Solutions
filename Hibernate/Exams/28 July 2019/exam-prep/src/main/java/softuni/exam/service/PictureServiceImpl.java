package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.FileImportPath;
import softuni.exam.domain.dtos.in.picture.PicturesImportDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private final PictureRepository pictureRepository;
    @Autowired
    private final XmlParser xmlParser;
    @Autowired
    private final ValidatorUtil validatorUtil;
    @Autowired
    private final ModelMapper modelMapper;

    public PictureServiceImpl(PictureRepository pictureRepository, XmlParser xmlParser, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.pictureRepository = pictureRepository;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public String importPictures() throws IOException, JAXBException {
        StringBuilder result = new StringBuilder();
        PicturesImportDto importDto = xmlParser.convertFromFile(FileImportPath.PICTURE_IMPORT_FILE_PATH,
                PicturesImportDto.class);

        importDto.getPictures()
                .stream()
                .forEach(pic -> {
                    if (validatorUtil.isValid(pic)) {
                        pictureRepository.saveAndFlush(modelMapper
                                .map(pic, Picture.class));
                        System.out.printf("Successfully imported picture - %s%n",
                                pic.getUrl());
                    } else {
                        System.out.println("Invalid picture");
                    }
                });

        return result.toString();
    }

    @Override
    public boolean areImported() {
        return pictureRepository.findAll().size() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        String content = Files.readString(Path.of(FileImportPath.PICTURE_IMPORT_FILE_PATH),
                StandardCharsets.US_ASCII);
        return content;
    }


}
