package br.ufscar.dc.dsw


import grails.rest.*

@Resource(uri='/teatros', readOnly = false, formats = ['json', 'xml'])
class Teatro {
    static constraints = {
        nome blank: false
        cidade blank: false
        cnpj blank: false
    }

    String nome
    String cidade
    String cnpj
    String email
}
