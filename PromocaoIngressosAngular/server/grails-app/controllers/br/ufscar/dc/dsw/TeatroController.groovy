package br.ufscar.dc.dsw

import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

class TeatroController extends RestfulController {
    static responseFormats = ['json', 'xml']
    TeatroController() {
        super(Teatro)
    }
    @Secured(['permitAll()'])
    @Override
    def index(Integer max) {
        super.index(max)
    }

    @Secured(['permitAll()'])
    @Override
    def show() {
        super.show()
    }

    @Secured(['ROLE_ADMIN'])
    @Override
    def save() {
        super.save()
    }

    @Secured(['ROLE_ADMIN'])
    @Override
    def update() {
        super.update()
    }

    @Secured(['ROLE_ADMIN'])
    @Override
    def delete() {
        super.delete()
    }
}
