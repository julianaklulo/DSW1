package br.ufscar.dc.dsw


import grails.rest.*

@Resource(uri='/sites', readOnly = false, formats = ['json', 'xml'])
class Site extends User{
    static constraints = {
        nome blank: false
        telefone blank: false
        url blank: false
    }

    String nome
    String telefone
    String url
}
