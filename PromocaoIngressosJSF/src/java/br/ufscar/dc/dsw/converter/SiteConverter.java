package br.ufscar.dc.dsw.converter;

import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.pojo.Site;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("SiteConverter")
public class SiteConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.parseLong(string);
        SiteDAO dao = new SiteDAO();
        return dao.get(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Site site = (Site) o;
        return site.getId().toString();
    }
}