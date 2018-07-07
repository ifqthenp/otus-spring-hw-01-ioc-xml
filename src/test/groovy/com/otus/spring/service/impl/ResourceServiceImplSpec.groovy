package com.otus.spring.service.impl

import com.otus.spring.service.ResourceService
import spock.lang.Specification

class ResourceServiceImplSpec extends Specification {

    ResourceService resourceService

    void setup() {
        resourceService = new ResourceServiceImpl()
        assert resourceService.csvURL != null
    }

    def "getCsvURL() method returns URL reference type"() {
        expect:
        resourceService.csvURL.getClass() in URL.class
    }

    def "ResourceService returns csv file with 'quiz.csv' name"() {
        expect:
        new File(resourceService.csvURL.file).name == 'quiz.csv'
    }
}
