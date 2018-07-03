package com.otus.spring.service.impl

import com.opencsv.CSVReader
import com.otus.spring.service.CsvService
import com.otus.spring.service.ResourceService
import spock.lang.Specification

/**
 * {@code CsvServiceImplSpec} class.
 */
class CsvServiceImplSpec extends Specification {

    CsvService csvService
    ResourceService resourceService

    void setup() {
        resourceService = new ResourceServiceImpl()
        csvService = new CsvServiceImpl(resourceService)
        assert csvService.csvReader != null
    }

    def "getCsvReader() method returns CSVReader reference type"() {
        expect:
        csvService.csvReader.getClass() in CSVReader.class
    }
}
