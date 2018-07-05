package com.otus.spring.service.impl

import com.otus.spring.service.CsvService
import com.otus.spring.service.ResourceService
import spock.lang.Specification

class CsvServiceImplSpec extends Specification {

    CsvService csvService
    ResourceService resourceService

    void setup() {
        resourceService = new ResourceServiceImpl()
        csvService = new CsvServiceImpl(resourceService)
        assert csvService != null
    }

    def "getQuizList() method returns ArrayList reference type"() {
        expect:
        csvService.quizList.getClass() in ArrayList.class
    }
}
