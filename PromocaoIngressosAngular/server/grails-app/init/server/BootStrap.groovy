package server

import br.ufscar.dc.dsw.Teatro
import br.ufscar.dc.dsw.Site
import br.ufscar.dc.dsw.Promocao
import br.ufscar.dc.dsw.User
import br.ufscar.dc.dsw.UserRole
import br.ufscar.dc.dsw.Role

class BootStrap {

    def init = { servletContext ->
        Role admin = new Role(authority: 'ROLE_ADMIN').save()
        Role site_role = new Role(authority: 'ROLE_SITE').save()
        Role teatro_role = new Role(authority: 'ROLE_TEATRO').save()
        User user = new User(username: "admin", password: "admin").save()
        UserRole.create(user, admin, true)

        Teatro t = new Teatro(nome: 'Teatro de São Carlos', cnpj: '123456', cidade: 'São Carlos', username: 'teatro@sc.com', password: 'admin')
        t.save()
        UserRole.create(t, teatro_role, true)

        Site s = new Site(nome:'Cambista Online', url: 'www.cambista.com', telefone: '16912345678', username: 'cambista@email.com', password: 'admin')
        s.save()
        UserRole.create(s, site_role, true)

        Promocao p = new Promocao(nomePeca: 'Hamlet', preco: '50', dataHora: "1/1/1", teatro: t, site: s)
        p.save()
}
    def destroy = {
    }
}
