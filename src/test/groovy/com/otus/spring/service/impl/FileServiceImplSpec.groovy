package com.otus.spring.service.impl

import com.otus.spring.service.FileService
import spock.lang.Specification

class FileServiceImplSpec extends Specification {

    FileService fileService

    void setup() {
        fileService = new FileServiceImpl()
        assert fileService.csvFile != null
    }

    def "getCsvFile() method returns File reference type"() {
        expect:
        fileService.csvFile.getClass() in File.class
    }

    def "FileService returns csv file with 'quiz.csv' name"() {
        expect:
        fileService.csvFile.name == 'quiz.csv'
    }
}
