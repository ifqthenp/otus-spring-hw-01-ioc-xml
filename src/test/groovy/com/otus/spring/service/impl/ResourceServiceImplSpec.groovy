package com.otus.spring.service.impl

import com.otus.spring.service.CsvUrlService
import spock.lang.Specification

class CsvUrlServiceImplSpec extends Specification {

    CsvUrlService fileService

    void setup() {
        fileService = new CsvUrlServiceImpl()
        assert fileService.csvURL != null
    }

    def "getCsvURL() method returns URL reference type"() {
        expect:
        fileService.csvURL.getClass() in URL.class
    }

    def "FileService returns csv file with 'quiz.csv' name"() {
        expect:
        new File(fileService.csvURL.file).name == 'quiz.csv'
    }
}
