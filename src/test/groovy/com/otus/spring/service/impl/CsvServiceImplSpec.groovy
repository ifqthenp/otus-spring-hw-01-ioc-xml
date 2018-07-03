package com.otus.spring.service.impl

import com.opencsv.CSVReader
import com.otus.spring.service.CsvService
import com.otus.spring.service.FileService
import spock.lang.Specification

/**
 * {@code CsvServiceImplSpec} class.
 */
class CsvServiceImplSpec extends Specification {

    CsvService csvService
    FileService fileService

    void setup() {
        fileService = new FileServiceImpl()
        csvService = new CsvServiceImpl(fileService)
        assert csvService.csvReader != null
    }

    def "getCsvReader() method returns CSVReader reference type"() {
        expect:
        csvService.csvReader.getClass() in CSVReader.class
    }
}
