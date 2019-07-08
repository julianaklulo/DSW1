package br.ufscar.dc.dsw

import grails.rest.*
import br.ufscar.dc.dsw.Teatro
import br.ufscar.dc.dsw.Site

@Resource(uri='/promocoes', readOnly = false, formats = ['json', 'xml'])
class Promocao {
    static constraints = {
        nomePeca blank: false
        preco blank: false
        dataHora blank: false
        teatro blank: false
        site blank: false
    }

    String nomePeca
    String preco
    String dataHora
    Teatro teatro
    Site site
}
